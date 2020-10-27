package com.baobab.m.dao.ticket;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.UserLocationVO;
import com.baobab.m.vo.UserTicketHistoryVO;
import com.baobab.m.vo.UserTicketVO;

public interface UserTicketDAO {
	int ticketInsert(UserTicketVO vo);
	int ticketHistoryInsert(UserTicketHistoryVO vo);
	List<UserTicketVO> selectUserTicket(String email);
	List<PayMenusVO> getPaidMenus(String orderNum);
	int paymentUsed(String serial);
	int ticketDelete(String serial);
	int ticketUsedConfirm(String serial);
	UserTicketVO ticketScanConfirm(String serial);
	int getCpSeq(String email);
	UserLocationVO userPush(String serial);
	UserLocationVO localUserPush(String phone);
	UserLocationVO cpPush(String serial);
	UserLocationVO cpPushSelect(String email);
	int ticketCancel(String orderNum);
	int ticketCancelHistory(String orderNum);
	List<UserTicketHistoryVO> useTicketHistory(String email);
	String getSerial(String orderNum);
	int passwordCheck(HttpServletRequest request);
	int freeTicketInsert(HttpServletRequest request);
}
