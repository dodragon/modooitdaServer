package com.baobab.m.dao.login;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.UserAllVO;

public interface LoginDAO {
	UserAllVO loginConfirm(String email, String password);
	CPInfoVO getMyInfo(int cpSeq);
	String getCpUserInfo(String email);
	void getHistory(HttpServletRequest request);
	CPInfoVO getStoreInfo(String cpName, String email);
	CPInfoVO getStoreInfoForManager(String email);
	int socialAccountBackup(String email);
}
