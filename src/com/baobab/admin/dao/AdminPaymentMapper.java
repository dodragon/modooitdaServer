package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Mapper
public interface AdminPaymentMapper {
	List<PaymentVO> selectPayList();
	
	PaymentVO getPayment(String orderNum);
	List<PayMenusVO> getPaymenus(String orderNum);
	List<UserTicketHistoryVO> getTickets(String orderNum);
}
