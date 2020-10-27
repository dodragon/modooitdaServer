package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PaypleInfoVO;
import com.baobab.m.vo.UserLocationVO;

public interface PaymentMapper {
	void paymentInsert(PaymentVO vo);
	void paymenuInsert(PayMenusVO vo);
	
	UserLocationVO cpLocationInfo(int cpSeq);
	UserLocationVO userLocationInfo(String email);
	String findTid(String orderNum);
	
	String cancelCheck(String oid);
	void changeStatus(String orderNum);
	
	UserLocationVO userCancelLocationInfo(String orderNum);
	UserLocationVO cpCancelLocationInfo(String orderNum);
	
	List<PaymentVO> selectPayment(PaymentVO vo);
	List<PayMenusVO> selectPaymenus(String orderNum);
	//юлго payple
	List<String> selectPayerIds(String email);
	int isIdCount(PaypleInfoVO vo);
	void insertPayerId(PaypleInfoVO vo);
	void deletePayerId(String payerId);
	String findPg(String orderNum);
	PaymentVO selectAllFromOid(String orderNum);
	
	void justInsert(PaypleInfoVO vo);
	List<UserLocationVO> findAdmin();
	
	PaymentVO payDetail(String orderNum);
}
