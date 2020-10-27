package com.baobab.m.dao.join;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.vo.MeCertVO;
import com.baobab.m.vo.UserAllVO;

public interface UserJoinDAO {
	int userAllJoin(MeCertVO vo, String email, String pw, String pushAgree, String nickName);
	void userHistoryJoin(String email);
	String getUserPhone(String email);
	String getCpPhone(int cpSeq);
	void userInfoChange(String email, String password, String pushCheck);
	void leaveUserAll(String email);
	void leaveUserHistory(String email);
	int userCodeUpdate(HttpServletRequest request);
	List<UserAllVO> dupEmail(HttpServletRequest request);
	int emailCheck(HttpServletRequest request);
	int point(String email);
	int nowPoint(String email);
	//profile
	int profileDelete(HttpServletRequest request) throws Exception;
	String setProfile(MultipartHttpServletRequest request) throws Exception;
	List<UserAllVO> nickNameCheck(String nickName);
	String selectProfileImg(String email);
	//dataChecking
	UserAllVO userDataCheck(String email);
	int userDataAdd(MeCertVO vo, String email);
	//Marketing
	UserAllVO getUserDataForMarketing(MeCertVO mvo, String email, String pw, String pushAgree, String nickName);
	void insertUserMarketing(UserAllVO vo);
	int emailDup(String email);
}
