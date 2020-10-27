package com.baobab.m.dao.cpfunction;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.vo.MenuVO;

@Repository
public class MenuUploadDAOimpl implements MenuUploadDAO{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate upload;
	private String saveFolder = "/baobabMenus/";
	
	@Override
	public void menuUpload(MenuVO mvo, MultipartFile menuImg) throws FileNotFoundException, IOException {
		mvo.setMenu_img(menuUpload(menuImg, mvo.getCp_name()+"-"+mvo.getMenu_name()));
		upload.update("com.baobab.m.dao.MenuUploadMapper.menuUp", mvo);
	}
	
	public String menuUpload(MultipartFile menuImg, String menuName) throws FileNotFoundException, IOException{
		FtpClient ftp = new FtpClient();
		if(menuImg != null) {
			if(!menuImg.isEmpty()) {
				String saveName = menuName+".webp";
				if(saveName.contains(" ")) {
					return ftp.ftp(ftp.convert(menuImg), saveName.replace(" ", "+"), saveFolder);
				}else {
					return ftp.ftp(ftp.convert(menuImg), saveName, saveFolder);
				}
			}
			return null;
		}else {
			return "이미지없음";
		}
	}

	@Override
	public void menuDel(String cpName, String menuName, String option) throws Exception {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setMenu_option(option);
		upload.update("com.baobab.m.dao.MenuUploadMapper.menuDel", vo);
		
		if((int)upload.selectOne("com.baobab.m.dao.MenuUploadMapper.ifImgdel", vo) == 0) {
			FtpClient ftp = new FtpClient();
			if(ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".webp") != 1) {
				ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".jpg");
				ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".png");
			}
		}
	}

	@Override
	public int menuModi(MultipartHttpServletRequest request) throws IOException {
		MenuVO vo = new MenuVO();
		String cpName = request.getParameter("cpName");
		vo.setSeq_num(Integer.parseInt(request.getParameter("menuSeq")));
		vo.setMenu_name(request.getParameter("menuName"));
		vo.setMenu_option(request.getParameter("option"));
		vo.setMenu_div(request.getParameter("category"));
		vo.setMenu_price(Integer.parseInt(request.getParameter("price")));
		vo.setMenu_intro(request.getParameter("intro"));
		
		String imageUrl = request.getParameter("imageUrl");
		
		
		try {
			FtpClient ftp = new FtpClient();
			
			
			if(imageUrl.equals("이미지없음")) {
				imageUrl = ftp.ftp(ftp.convert(request.getFile(vo.getMenu_name())), cpName + "-" + vo.getMenu_name() + ".webp", saveFolder);
			}else {
				imageUrl = ftp.ftp(ftp.convert(request.getFile(vo.getMenu_name())), imageUrl.split("/")[imageUrl.split("/").length - 1], saveFolder);
			}
			
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("메뉴 이미지 null");
		}finally {
			vo.setMenu_img(imageUrl);
		}
		
		return upload.update("com.baobab.m.dao.MenuUploadMapper.menuModi", vo);
	}

}
