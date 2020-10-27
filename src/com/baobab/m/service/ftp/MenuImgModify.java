package com.baobab.m.service.ftp;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.dao.cpfunction.GetMyMenuDAO;

@Service
public class MenuImgModify {
	
	private static final String menuFolder = "/baobabMenus/";
	@Autowired
	GetMyMenuDAO gmm;
	
	public String imgModify(MultipartHttpServletRequest request) throws Exception {
		MultipartFile img = request.getFile("newImage");
		String cpName = request.getParameter("cpName");
		String menuName = request.getParameter("menuName");
		String div = request.getParameter("div");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		
		if(div.equals("menu")) {
			imgChange(menuFolder, cpName, menuName, img, cpSeq);
			return "ok";
		}else {
			return "fail";
		}
	}
	
	public void imgChange(String folder, String cpName, String menuName, MultipartFile img, int cpSeq) throws IOException, Exception {
		FtpClient ftp = new FtpClient();
		if(ftp.deleteFile(folder, cpName + "-" + menuName + ".png") != 1) {
			ftp.deleteFile(folder, cpName + "-" + menuName + ".jpg");
		}
		
		String newUrl = ftp.ftp(ftp.convert(img), cpName + "-" + menuName + ".png", folder);
		gmm.menuUrlUpdate(newUrl, menuName, cpSeq);
	}
}
