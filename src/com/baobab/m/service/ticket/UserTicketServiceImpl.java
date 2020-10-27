package com.baobab.m.service.ticket;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.dao.ticket.UserTicketDAO;
import com.baobab.m.vo.SalesHistoryVO;
import com.baobab.m.vo.UserTicketHistoryVO;
import com.baobab.m.vo.UserTicketVO;

@Service
public class UserTicketServiceImpl implements UserTicketService {
	
	@Autowired
	UserTicketDAO ticket;
	@Autowired
	EventCpDAO event;

	@Override
	public int ticketUsed(HttpServletRequest request) {
		String serial = request.getParameter("serial");
		int cpSeq = 0;
		if(request.getParameter("scanner").equals("cp")) {
			cpSeq = ticket.getCpSeq(request.getParameter("email"));
		}else {
			cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		}
		if(ticket.ticketUsedConfirm(serial) > 0) {
			//사용처리 확인
			return 10;
		}else {
			UserTicketVO vo = ticket.ticketScanConfirm(serial);
			if(vo.getCpSeq() != cpSeq) {
				return 9;
			}else {
				//사용처리
				ticket.paymentUsed(serial);
				ticket.ticketDelete(serial);
				UserTicketHistoryVO hisVo = new UserTicketHistoryVO();
				hisVo.setTicketTitle(vo.getTicketTitle());
				hisVo.setTicketSerial(vo.getTicketSerial());
				hisVo.setOrderNum(vo.getOrderNum());
				hisVo.setTicketStatus("사용");
				hisVo.setEmail(vo.getEmail());
				hisVo.setCpSeq(cpSeq);
				hisVo.setAmount(vo.getAmount());
				ticket.ticketHistoryInsert(hisVo);
				
				SalesHistoryVO salesVo = new SalesHistoryVO();
				salesVo.setSalesStatus("사용");
				salesVo.setOrderNum(vo.getOrderNum());
				event.updateSales(salesVo);
				return 0;
			}
		}
	}

	@Override
	public int ticketDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
