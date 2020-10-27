package com.baobab.admin.dao.app;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.AdminAppVO;

public interface AppDAO {
	AdminAppVO dataSelect();
	void updateData(HttpServletRequest request);
}
