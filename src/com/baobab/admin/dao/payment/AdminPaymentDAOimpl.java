package com.baobab.admin.dao.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Repository
public class AdminPaymentDAOimpl implements AdminPaymentDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate pa;

	@Override
	public List<PaymentVO> selectPayList() {
		return pa.selectList("com.baobab.admin.dao.AdminPaymentMapper.selectPayList");
	}

	@Override
	public PaymentVO getPayment(String orderNum) {
		return pa.selectOne("com.baobab.admin.dao.AdminPaymentMapper.getPayment", orderNum);
	}

	@Override
	public List<PayMenusVO> getPaymenus(String orderNum) {
		return pa.selectList("com.baobab.admin.dao.AdminPaymentMapper.getPaymenus", orderNum);
	}

	@Override
	public List<UserTicketHistoryVO> getTickets(String orderNum) {
		return pa.selectList("com.baobab.admin.dao.AdminPaymentMapper.getTickets", orderNum);
	}
}
