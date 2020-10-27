package com.baobab.m.dao.coupon;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponHistoryDetailVO;
import com.baobab.m.vo.CouponHistoryVO;

@Repository
public class CouponHistoryDAOimpl implements CouponHistoryDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;
	
	@Override
	public List<CouponHistoryVO> couponDayHistory(HttpServletRequest request) {
		CouponHistoryDetailVO vo = new CouponHistoryDetailVO();
		vo.setEmail(request.getParameter("email"));
		vo.setStartDate(request.getParameter("startDate"));
		vo.setEndDate(request.getParameter("endDate"));
		
		return coupon.selectList("com.baobab.m.dao.CouponHistoryMapper.couponDayHistory", vo);
	}

	@Override
	public List<CouponHistoryVO> couponMonthHistory(HttpServletRequest request) {
		CouponHistoryDetailVO vo = new CouponHistoryDetailVO();
		vo.setEmail(request.getParameter("email"));
		vo.setMonth(request.getParameter("month"));
		return coupon.selectList("com.baobab.m.dao.CouponHistoryMapper.couponMonthHistory", vo);
	}

	@Override
	public List<CouponHistoryVO> couponHomeHistory(HttpServletRequest request) {
		return coupon.selectList("com.baobab.m.dao.CouponHistoryMapper.couponHomeHistory", request.getParameter("email"));
	}
	
}
