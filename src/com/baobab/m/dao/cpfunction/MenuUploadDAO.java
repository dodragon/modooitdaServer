package com.baobab.m.dao.cpfunction;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.vo.MenuVO;

public interface MenuUploadDAO {
	public void menuUpload(MenuVO mvo, MultipartFile menuImg)throws FileNotFoundException, IOException;
	void menuDel(String cpName, String menuName, String option) throws Exception;
	int menuModi(MultipartHttpServletRequest request) throws IOException;
}
