package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.FreeTicketHistoryVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.UserLocationVO;
import com.baobab.m.vo.UserTicketHistoryVO;
import com.baobab.m.vo.UserTicketVO;

@Mapper
public interface UserTicketMapper {
	void ticketInsert(UserTicketVO vo);
	void ticketHistoryInsert(UserTicketHistoryVO vo);
	List<UserTicketVO> selectUserTicket(String email);
	List<PayMenusVO> getPaidMenus(String orderNum);
	void paymentUsed(String serial);
	void ticketDelete(String serial);
	int ticketUsedConfirm(String serial);
	UserTicketVO ticketScanConfirm(String serial);
	int getCpSeq(String email);
	UserLocationVO userPush(String serial);
	UserLocationVO localUserPush(String phone);
	UserLocationVO cpPush(String serial);
	UserLocationVO cpPushSelect(String email);
	void ticketCancel(String orderNum);
	void ticketCancelHistory(String orderNum);
	List<UserTicketHistoryVO> useTicketHistory(String email);
	String getSerial(String orderNum);
	int passwordCheck(CPInfoVO vo);
	void freeTicket(FreeTicketHistoryVO vo);
}	
