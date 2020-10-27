package com.baobab.admin.dao.payment;

import java.util.List;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserTicketHistoryVO;

public interface AdminPaymentDAO {
	List<PaymentVO> selectPayList();
	
	PaymentVO getPayment(String orderNum);
	List<PayMenusVO> getPaymenus(String orderNum);
	List<UserTicketHistoryVO> getTickets(String orderNum);
}
