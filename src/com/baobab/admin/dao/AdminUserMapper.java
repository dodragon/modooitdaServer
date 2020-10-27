package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Mapper
public interface AdminUserMapper {
	List<UserAllVO> selectUser();
	UserAllVO defaultInfo(String email);
	String loctaionInfo(String email);
	List<PaymentVO> payInfo(String email);
	List<PayMenusVO> paymenuInfo(String orderNum);
	List<UserTicketHistoryVO> ticketInfo(String email);
	List<ReviewsVO> revInfo(String email);
	List<PokeVO> pokeInfo(String email);
	
	void insertAdmin(AdminAccountVO vo);
}
