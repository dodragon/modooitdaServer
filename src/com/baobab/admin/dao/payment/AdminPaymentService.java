package com.baobab.admin.dao.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.vo.AdminPayDetailVO;

@Service
public class AdminPaymentService {
	
	@Autowired
	AdminPaymentDAO dao;
	
	public AdminPayDetailVO getData(String orderNum) {
		AdminPayDetailVO vo = new AdminPayDetailVO();
		vo.setPayment(dao.getPayment(orderNum));
		vo.setPaymenus(dao.getPaymenus(orderNum));
		vo.setTicket(dao.getTickets(orderNum));
		return vo;
	}
}
