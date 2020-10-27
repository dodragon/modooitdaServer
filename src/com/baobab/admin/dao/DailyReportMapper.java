package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.DailyReportVO;

@Mapper
public interface DailyReportMapper {
	List<DailyReportVO> selectAll();
	DailyReportVO selectOne(int seqNum);
	void insertReport(DailyReportVO vo);
	void updateReport(DailyReportVO vo);
	String divCodeCheck(String email);
	String getBeforeJob(String email);
}
