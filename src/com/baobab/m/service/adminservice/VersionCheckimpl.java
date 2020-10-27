package com.baobab.m.service.adminservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.adminfunction.VersionDAO;

@Service
public class VersionCheckimpl implements VersionCheck {
	
	@Autowired
	VersionDAO ver;

	@Override
	public int versionChecking(HttpServletRequest request) {
		int version = Integer.parseInt(request.getParameter("version"));
		System.out.println("version ===============" + version);
		int newVersion = ver.newVersion();
		System.out.println("newVersion ============" + newVersion);
		if(version != newVersion) {
			return 0;
		}else {
			return 1;
		}
	}

}
