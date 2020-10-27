package com.baobab.m.dao.coupon;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.baobab.m.vo.CouponListVO;
import com.baobab.m.vo.CouponSampleVO;
import com.baobab.m.vo.CouponTypeVO;

public interface CouponListDAO {

	void couponInfoInsert(HttpServletRequest request);
	List<CouponListVO> couponListSelect();
	List<CouponSampleVO> couponEX();
	List<CouponTypeVO> couponSpecial();
}
