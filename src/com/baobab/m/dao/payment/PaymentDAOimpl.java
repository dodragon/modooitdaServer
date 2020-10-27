package com.baobab.m.dao.payment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PaypleInfoVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class PaymentDAOimpl implements PaymentDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate pay;

	@Override
	public int paymentInsert(PaymentVO vo) {
		return pay.insert("com.baobab.m.dao.PaymentMapper.paymentInsert", vo);
	}

	@Override
	public int paymenuInsert(PayMenusVO vo) {
		return pay.insert("com.baobab.m.dao.PaymentMapper.paymenuInsert", vo);
	}

	@Override
	public UserLocationVO cpLocationInfo(int cpSeq) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.cpLocationInfo", cpSeq);
	}

	@Override
	public UserLocationVO userLocationInfo(String email) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.userLocationInfo", email);
	}

	@Override
	public String findTid(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.findTid", orderNum);
	}

	@Override
	public int changeStatus(String orderNum) {
		return pay.update("com.baobab.m.dao.PaymentMapper.changeStatus", orderNum);
	}

	@Override
	public UserLocationVO userCancelLocationInfo(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.userCancelLocationInfo", orderNum);
	}

	@Override
	public UserLocationVO cpCancelLocationInfo(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.cpCancelLocationInfo", orderNum);
	}

	@Override
	public List<PaymentVO> selectPayment(HttpServletRequest request) {
		PaymentVO vo = new PaymentVO();
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setUsed(request.getParameter("date"));
		return pay.selectList("com.baobab.m.dao.PaymentMapper.selectPayment", vo);
	}

	@Override
	public List<PayMenusVO> selectPaymenus(String orderNum) {
		return pay.selectList("com.baobab.m.dao.PaymentMapper.selectPaymenus", orderNum);
	}

	@Override
	public String cancelCheck(String oid) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.cancelCheck", oid);
	}

	@Override
	public List<String> selectPayerIds(String email) {
		return pay.selectList("com.baobab.m.dao.PaymentMapper.selectPayerIds", email);
	}

	@Override
	public int isIdCount(String email, String payerId) {
		PaypleInfoVO vo = new PaypleInfoVO();
		vo.setEmail(email);
		vo.setPayerId(payerId);
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.isIdCount", vo);
	}

	@Override
	public int insertPayerId(PaypleInfoVO vo) {
		return pay.insert("com.baobab.m.dao.PaymentMapper.insertPayerId", vo);
	}

	@Override
	public int deletePayerId(String payerId) {
		return pay.delete("com.baobab.m.dao.PaymentMapper.deletePayerId", payerId);
	}

	@Override
	public String findPg(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.findPg", orderNum);
	}

	@Override
	public PaymentVO selectAllFromOid(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.selectAllFromOid", orderNum);
	}

	@Override
	public int justInsert(String email, String payerId) {
		PaypleInfoVO vo = new PaypleInfoVO();
		vo.setEmail(email);
		vo.setPayerId(payerId);
		return pay.insert("com.baobab.m.dao.PaymentMapper.justInsert", vo);
	}

	@Override
	public List<UserLocationVO> findAdmin() {
		return pay.selectList("com.baobab.m.dao.PaymentMapper.findAdmin");
	}

	@Override
	public PaymentVO payDetail(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.payDetail", orderNum);
	}
}
