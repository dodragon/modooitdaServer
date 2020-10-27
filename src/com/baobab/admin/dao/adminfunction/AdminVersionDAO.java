package com.baobab.admin.dao.adminfunction;

import javax.servlet.http.HttpServletRequest;

public interface AdminVersionDAO {
	int getVersion();
	int upVersion(HttpServletRequest request);
	String getCheckServer();
	int checkServer(HttpServletRequest request);
}	
