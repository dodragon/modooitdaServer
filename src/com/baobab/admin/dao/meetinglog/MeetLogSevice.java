package com.baobab.admin.dao.meetinglog;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.MeetingLogVO;

public interface MeetLogSevice {
	public int insertML(HttpServletRequest request) throws ParseException;
	public int updateML(HttpServletRequest request) throws ParseException;
	MeetingLogVO dataMerge(HttpServletRequest request, boolean isInsert) throws ParseException;
}