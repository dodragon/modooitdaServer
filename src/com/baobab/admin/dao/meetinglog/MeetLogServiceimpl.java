package com.baobab.admin.dao.meetinglog;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.vo.MeetingLogVO;

@Service
public class MeetLogServiceimpl implements MeetLogSevice {
	
	@Autowired
	MeetingLogDAO dao;

	@Override
	public int insertML(HttpServletRequest request) throws ParseException {
		return dao.insert(dataMerge(request, true));
	}

	@Override
	public MeetingLogVO dataMerge(HttpServletRequest request, boolean isInsert) throws ParseException {
		MeetingLogVO vo = new MeetingLogVO();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		vo.setMeetingTitle(request.getParameter("meetTitle"));
		vo.setMainAgenda(request.getParameter("mainAgenda"));
		vo.setPlace(request.getParameter("place"));
		vo.setMeetingDate(dateFormat.parse(request.getParameter("meetDate")));
		dateFormat = new SimpleDateFormat("HH:mm");
		vo.setStartTime(dateFormat.parse(request.getParameter("startTime")));
		vo.setEndTime(dateFormat.parse(request.getParameter("endTime")));
		vo.setMeetingContents(request.getParameter("contents"));
		vo.setMeetingResult(request.getParameter("result"));
		vo.setDirector(request.getParameter("director"));
		vo.setWriter(request.getParameter("writer"));
		vo.setAttendees(request.getParameter("attendees"));
		vo.setNop(request.getParameter("attendees").split(", ").length);
		
		if(!isInsert) {
			vo.setSeqNum(Integer.parseInt(request.getParameter("seqNum")));
		}
		
		return vo;
	}

	@Override
	public int updateML(HttpServletRequest request) throws ParseException {
		return dao.update(dataMerge(request, false));
	}

}
