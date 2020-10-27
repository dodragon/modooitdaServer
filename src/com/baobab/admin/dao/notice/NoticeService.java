package com.baobab.admin.dao.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.service.fcm.SendNoticeFCM;
import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;
	
	public int noticeInit(HttpServletRequest request, HttpSession session) throws IOException {
		int insertResult = insertNotice(request, session);
		int sendResult = 0;
		if(insertResult > 0) {
			sendResult = sendNotice(request);
			if(sendResult > 0) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public int insertNotice(HttpServletRequest request, HttpSession session) {
		NoticeVO vo = new NoticeVO();
		
		
		String[] readDivs = request.getParameter("readers").split(",");
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter((String)session.getAttribute("id"));
		
		int result = 0;
		for(int i=0;i<readDivs.length;i++) {
			vo.setRead_div(readDivs[i]);
			result += dao.insertNotice(vo);
		}
		
		return result;
	}
	
	public int sendNotice(HttpServletRequest request) throws IOException {
		List<UserLocationVO> userList = new ArrayList<>();
		String readDiv = request.getParameter("readers");
		if(readDiv.equals("all")) {
			readDiv = "A,C,U";
		}
		String[] readers = readDiv.toLowerCase().split(",");
		for(int i=0;i<readers.length;i++) {
			userList.addAll(dao.selectUsers(readers[i] + "%"));
		}
		
		SendNoticeFCM fcm = new SendNoticeFCM();
		return fcm.send("[공지사항]" + request.getParameter("title"), request.getParameter("content"), userList);
	}
}
