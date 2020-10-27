package com.baobab.m.service.statistics;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.EventOptionStatVO;
import com.baobab.m.vo.StatisticsVO;

public interface StatisticsService {
	StatisticsVO makeVO(int cpSeq, String curDate, String statDiv) throws ParseException;
	String yesterday(String curDate, String statDiv) throws ParseException;
	List<EventOptionStatVO> eventDetailStat(HttpServletRequest request);
}