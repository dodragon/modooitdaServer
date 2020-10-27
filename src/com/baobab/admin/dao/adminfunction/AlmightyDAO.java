package com.baobab.admin.dao.adminfunction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPInfoVO;

public interface AlmightyDAO {
	List<CPInfoVO> cpSearch(String searchWord);
	int almightyLogin(HttpServletRequest request);
}
