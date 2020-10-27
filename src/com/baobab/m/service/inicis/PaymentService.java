package com.baobab.m.service.inicis;

import java.util.List;

import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;

public interface PaymentService {
	int paySuccess(PaymentVO vo, List<EventCpMenuVO> eventList, String orderNum, String email, int cpSeq);
	int payMenusInsert(List<PayMenusVO> list);
	List<PayMenusVO> makePaymenuList(List<EventCpMenuVO> list, String orderNum, String email, int cpSeq);
	int insertSalesHistory(List<EventCpMenuVO> eventList, String orderNum, int cpSeq);
	
	int payCancel(String orderNum);
	
	int pushPaySuccess(PaymentVO vo);
}
