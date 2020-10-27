package com.baobab.admin.dao.mainImg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.rsa.RandomNumber;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;

@Service
public class MainImgService {
	
	@Autowired
	MainImgDAO dao;
	
	public int imgUpload(String cpName, int cpSeq, List<MultipartFile> fileList) throws IOException {
		FtpClient ftp = new FtpClient();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		RandomNumber rn = new RandomNumber(8, 1);
		
		CPmainImgVO vo = new CPmainImgVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		
		int result = 0;
		
		for(int i=0;i<fileList.size();i++) {
			File file = ftp.convert(fileList.get(i));
			String imgUrl = ftp.ftp(file, cpSeq + format.format(new Date()) + rn.numberGen() + ".webp", "/baobabMainImg/");
			vo.setImg_url(imgUrl);
			result += dao.insertImg(vo);
		}
		
		return result;
	}
	
	public int logoUpdate(MultipartHttpServletRequest request) throws IOException {
		FtpClient ftp = new FtpClient();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		RandomNumber rn = new RandomNumber(8, 1);
		
		File file = ftp.convert(request.getFile("logo"));
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		String imgUrl = ftp.ftp(file, cpSeq + format.format(new Date()) + rn.numberGen() + ".webp", "/cpLogo/");
		
		CPInfoVO vo = new CPInfoVO();
		vo.setSeq_num(cpSeq);
		vo.setCpLogo(imgUrl);
		
		return dao.logoUpdate(vo);
	}
	
	public void imgUpdate(MultipartFile file, String url) throws IOException {
		FtpClient ftp = new FtpClient();
		File newFile = ftp.convert(file);
		System.out.println("ÆÄÀÏ¸í : " + url.split("/")[url.split("/").length - 1]);
		
		ftp.ftp(newFile, url.split("/")[url.split("/").length - 1], "/baobabMainImg/");
	}
}
