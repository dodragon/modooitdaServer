package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponHistoryDetailVO;
import com.baobab.m.vo.CouponHistoryVO;

@Mapper
public interface CouponHistroyMapper {

	List<CouponHistoryVO>couponDayHistory(CouponHistoryDetailVO vo);
	List<CouponHistoryVO>couponMonthHistory(CouponHistoryDetailVO vo);
	List<CouponHistoryVO>couponHomeHistory(CouponHistoryDetailVO vo);

}
