package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminLoginHistoryVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.VisitUserVO;

@Mapper
public interface AdminMainMapper {
	List<UserAllVO> userAll();
	List<CPInfoVO> cpAll();
	List<EventCpMenuVO> menuAll();
	List<VisitUserVO> visitantAll();
	List<PaymentVO> paymentAll();
	List<CpPushVO> pushAll();
	List<AdminLoginHistoryVO> loginHistory(String email);
}
