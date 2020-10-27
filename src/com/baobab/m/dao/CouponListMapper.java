package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponListVO;
import com.baobab.m.vo.CouponSampleVO;
import com.baobab.m.vo.CouponTypeVO;
@Mapper
public interface CouponListMapper {
	
	void couponInfoInsert(CouponListVO vo);
	List<CouponListVO> couponListSelect(CouponListVO vo);
	List<CouponSampleVO> couponEX();
	List<CouponTypeVO> couponSpecial();
}
