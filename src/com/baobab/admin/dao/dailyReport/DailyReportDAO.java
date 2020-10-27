package com.baobab.admin.dao.dailyReport;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.DailyReportVO;

public interface DailyReportDAO {
	List<DailyReportVO> selectAll();
	DailyReportVO selectOne(int seqNum);
	int insertReport(HttpServletRequest request);
	int updateReport(HttpServletRequest request);
	String divCodeCheck(String email);
	String getBeforeJob(String email);
}
