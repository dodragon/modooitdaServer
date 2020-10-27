package com.baobab.admin.dao.adminfunction;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.UserAllVO;

public interface AdminCodeChangeDAO {
	int codeChange(HttpServletRequest request);
	void insertHistory(UserAllVO vo);
}
