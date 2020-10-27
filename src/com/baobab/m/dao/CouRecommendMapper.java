package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;

@Mapper
public interface CouRecommendMapper {
	List<CPInfoVO> couponRecommend(int seq_num);
	CPInfoVO findThisCp(int cpSeq);
}
