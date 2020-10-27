package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baobab.m.dao.coupon.CouCpDAO;
import com.baobab.m.dao.coupon.CouponListDAO;
import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.vo.CouponManagementVO;
@Service
public class CouponManagementimpl implements CouponManagement {

	@Autowired
	CouponListDAO couList;
	@Autowired
	CouCpDAO couCp;
	@Autowired
	EventCpDAO event;
	
	@Override
	public CouponManagementVO couponActivity(HttpServletRequest request) {
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		
		CouponManagementVO vo = new CouponManagementVO();
		vo.setCouponCpVOList(couCp.getCpCouList(cpSeq));
		vo.setCouponListVOList(couList.couponListSelect());
		vo.setCouponSampleVOList(couList.couponEX());
		return vo;
	}

}
