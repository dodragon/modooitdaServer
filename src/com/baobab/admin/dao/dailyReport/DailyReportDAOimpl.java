package com.baobab.admin.dao.dailyReport;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.DailyReportVO;

@Repository
public class DailyReportDAOimpl implements DailyReportDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate dr;

	@Override
	public List<DailyReportVO> selectAll() {
		return dr.selectList("com.baobab.admin.dao.DailyReportMapper.selectAll");
	}

	@Override
	public int insertReport(HttpServletRequest request) {
		DailyReportVO vo = new DailyReportVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setDepartment(request.getParameter("department"));
		vo.setJobClass(request.getParameter("jobClass"));
		vo.setAttendTime(request.getParameter("attendTime"));
		vo.setCloseTime(request.getParameter("closeTime"));
		vo.setTodayJob(request.getParameter("todayJob"));
		vo.setTomorrowJob(request.getParameter("tomorrowJob"));
		vo.setSuccessJob(request.getParameter("successJob"));
		vo.setUnSuccessJob(request.getParameter("unSuccessJob"));
		return dr.insert("com.baobab.admin.dao.DailyReportMapper.insertReport", vo);
	}

	@Override
	public int updateReport(HttpServletRequest request) {
		DailyReportVO vo = new DailyReportVO();
		vo.setSeqNum(Integer.parseInt(request.getParameter("seq")));
		vo.setAttendTime(request.getParameter("attendTime"));
		vo.setCloseTime(request.getParameter("closeTime"));
		vo.setTodayJob(request.getParameter("todayJob"));
		vo.setTomorrowJob(request.getParameter("tomorrowJob"));
		vo.setSuccessJob(request.getParameter("successJob"));
		vo.setUnSuccessJob(request.getParameter("unSuccessJob"));
		return dr.update("com.baobab.admin.dao.DailyReportMapper.updateReport", vo);
	}

	@Override
	public String divCodeCheck(String email) {
		return dr.selectOne("com.baobab.admin.dao.DailyReportMapper.divCodeCheck", email);
	}

	@Override
	public DailyReportVO selectOne(int seqNum) {
		return replaceEnter(dr.selectOne("com.baobab.admin.dao.DailyReportMapper.selectOne", seqNum));
	}

	@Override
	public String getBeforeJob(String email) {
		return dr.selectOne("com.baobab.admin.dao.DailyReportMapper.getBeforeJob", email);
	}

	private DailyReportVO replaceEnter(DailyReportVO vo) {
		vo.setSuccessJob(vo.getSuccessJob().replaceAll("\r\n", "<br>"));
		vo.setTodayJob(vo.getTodayJob().replaceAll("\r\n", "<br>"));
		vo.setTomorrowJob(vo.getTomorrowJob().replaceAll("\r\n", "<br>"));
		vo.setUnSuccessJob(vo.getUnSuccessJob().replaceAll("\r\n", "<br>"));
		return vo;
	}
}
