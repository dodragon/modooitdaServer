package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;
import com.baobab.m.vo.CouponManagementVO;

public interface CouponManagement {
	CouponManagementVO couponActivity(HttpServletRequest request);
	
}
