package com.baobab.admin.dao.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.service.fcm.SendFCM;
import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

@Service
public class AdminPushService {
	
	@Autowired
	AdminPushDAO dao;
	
	public int adminPushInit(HttpServletRequest request, HttpSession session) throws IOException {
		int insertResult = insertPush(request, session);
		if(insertResult > 0) {
			int sendResult = sendPush(request);
			if(sendResult > 0) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public int insertPush(HttpServletRequest request, HttpSession session) {
		AdminPushVO vo = new AdminPushVO();
		vo.setTitle(request.getParameter("title"));
		vo.setMessage(request.getParameter("message"));
		vo.setWriter((String)session.getAttribute("id"));
		
		return dao.insert(vo);
	}
	
	public int sendPush(HttpServletRequest request) throws IOException {
		List<UserLocationVO> userList = new ArrayList<>();
		userList.addAll(dao.selectOurUsers());
		userList.addAll(dao.selectVisitUsers());
		
		SendFCM fcm = new SendFCM();
		return fcm.send(request, userList);
	}
}
