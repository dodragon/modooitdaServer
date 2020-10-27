package com.baobab.m.dao.coupon;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.baobab.m.vo.CouponCpVO;

public interface CouCpDAO {

	List<CouponCpVO> getCpCouList(int cp_seq);
	int couCpInfoInsert(HttpServletRequest request);
	int couponCpUse(HttpServletRequest request);
	List<CouponCpVO> couponCpPeriod(HttpServletRequest request);
	List<CouponCpVO> couPayDetail(String orderNum);
	List<CouponCpVO> getCouponMenu(int cp_seq);
	void cpCouponExpiry();
	int couponUpdate(HttpServletRequest request);
	int deleteCoupon(HttpServletRequest request);
	List<CouponCpVO> allCouponSelect(int cpSeq);
	void randomMainSet(int cpSeq);
	List<CouponCpVO> expirySelect();
	void mainCouponSet(String mainCoupon, int cpSeq);
}
