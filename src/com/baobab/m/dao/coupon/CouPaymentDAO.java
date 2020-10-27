package com.baobab.m.dao.coupon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponPaymentVO;

public interface CouPaymentDAO {

	int couPayInfoInsert(HttpServletRequest request);
	void couTidUpdate(HttpServletRequest request);
	List<CouponPaymentVO> couPaySelect(HttpServletRequest request);
}
