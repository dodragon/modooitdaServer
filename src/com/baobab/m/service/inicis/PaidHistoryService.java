package com.baobab.m.service.inicis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.dao.ticket.UserTicketDAO;
import com.baobab.m.vo.CpPaidHistoryVO;

@Service
public class PaidHistoryService {
	
	@Autowired
	PaymentDAO pay;
	@Autowired
	UserTicketDAO ticket;
	
	public CpPaidHistoryVO gethistories(String orderNum) {
		CpPaidHistoryVO vo = new CpPaidHistoryVO();
		vo.setPayMenusVOS(pay.selectPaymenus(orderNum));
		vo.setTicketSerial(ticket.getSerial(orderNum));
		return vo;
	}
}
