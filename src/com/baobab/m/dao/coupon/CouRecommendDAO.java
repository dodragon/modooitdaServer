package com.baobab.m.dao.coupon;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;

public interface CouRecommendDAO {
	List<CPInfoVO> couponRecommend(int cpSeq);
	CPInfoVO findThisCp(int cpSeq);
}
