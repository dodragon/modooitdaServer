package com.baobab.m.dao.coupon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponHistoryVO;

public interface CouponHistoryDAO {

	List<CouponHistoryVO>couponDayHistory(HttpServletRequest request);
	List<CouponHistoryVO>couponMonthHistory(HttpServletRequest request);
	List<CouponHistoryVO>couponHomeHistory(HttpServletRequest request);



}
