package com.baobab.m.dao.cpfunction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.rsa.RandomNumber;
import com.baobab.m.vo.CPmainImgVO;

@Repository
public class MainImgUploadDAOimpl implements MainImgUploadDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate imgLoad;

	private String saveFolder = "/baobabMainImg/";

	@Override
	public void mainImg(MultipartFile img, String cpName, int cpSeq) throws Exception {
		CPmainImgVO vo = new CPmainImgVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		RandomNumber rn = new RandomNumber(8, 1);		
		
		String imgUrl = imgUpload(img, String.valueOf(cpSeq) + format.format(new Date()) + rn.numberGen());
		if (!imgUrl.equals("이미지없음")) {
			vo.setCp_name(cpName);
			vo.setImg_url(imgUrl);
			vo.setCp_seq(cpSeq);
			imgLoad.update("com.baobab.m.dao.MainImgUploadMapper.mainImgUpload", vo);
		}
	}

	@Override
	public List<CPmainImgVO> getMainImg(int cpSeq) {
		return imgLoad.selectList("com.baobab.m.dao.MainImgUploadMapper.getMainImg", cpSeq);
	}

	@Override
	public String imgUpload(MultipartFile img, String imgName) throws Exception {
		FtpClient ftp = new FtpClient();
		if (img != null) {
			String saveName = imgName.replaceAll(".jpg", "").replaceAll(".png", "").replaceAll(".webp", "") + ".webp";
			if (saveName.contains(" ")) {
				saveName.replace(" ", "+");
			}
			String result = ftp.ftp(ftp.convert(img), saveName, saveFolder);
			return result;
		} else {
			return "이미지없음";
		}
	}

	@Override
	public int mainImgDel(String url) throws Exception {
		FtpClient ftp = new FtpClient();
		ftp.deleteFile(saveFolder, url.split("/")[url.split("/").length - 1]);
		ftp.deleteFile("/baobabMinMainImg/", url.split("/")[url.split("/").length - 1]);
		return imgLoad.delete("com.baobab.m.dao.MainImgUploadMapper.mainImgDel", url);
	}

	@Override
	public int urlUpdate(String url) {
		String fileName = url.replaceAll(".jpg", "").replaceAll(".png", "").replaceAll(".webp", "");
		fileName = fileName.split("/")[fileName.split("/").length - 1];
		CPmainImgVO vo = new CPmainImgVO();
		vo.setImg_url(url);
		vo.setCp_name("%" + fileName + "%");
		return imgLoad.update("com.baobab.m.dao.MainImgUploadMapper.urlUpdate", vo);
	}
}
