package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.LocationInquHistoryVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.UserHistoryVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface AdminUserDetailMapper {
	UserLocationVO loctaionInfo(String email);
	List<PaymentVO> paymentInfo(String email);
	List<UserHistoryVO> historyInfo(String email);
	List<CallHistoryVO> callHistoryInfo(String email);
	List<PokeVO> pokeInfo(String email);
	List<ReviewsVO> reviews(String email);
	void locationInqu(LocationInquHistoryVO vo);
}
