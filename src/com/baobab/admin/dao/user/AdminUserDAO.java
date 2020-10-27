package com.baobab.admin.dao.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserTicketHistoryVO;

public interface AdminUserDAO {
	List<UserAllVO> selectUser();
	UserAllVO defaultInfo(String email);
	String loctaionInfo(String email);
	List<PaymentVO> payInfo(String email);
	List<PayMenusVO> paymenuInfo(String orderNum);
	List<UserTicketHistoryVO> ticketInfo(String email);
	List<ReviewsVO> revInfo(String email);
	List<PokeVO> pokeInfo(String email);
	
	int insertAdmin(HttpServletRequest request);
}
