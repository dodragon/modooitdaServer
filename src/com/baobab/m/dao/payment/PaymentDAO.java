package com.baobab.m.dao.payment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PaypleInfoVO;
import com.baobab.m.vo.UserLocationVO;

public interface PaymentDAO {
	int paymentInsert(PaymentVO vo);
	int paymenuInsert(PayMenusVO vo);
	
	UserLocationVO cpLocationInfo(int cpSeq);
	UserLocationVO userLocationInfo(String email);
	
	String findTid(String orderNum);
	
	String cancelCheck(String oid);
	int changeStatus(String orderNum);
	
	UserLocationVO userCancelLocationInfo(String orderNum);
	UserLocationVO cpCancelLocationInfo(String orderNum);
	
	List<PaymentVO> selectPayment(HttpServletRequest request);
	List<PayMenusVO> selectPaymenus(String orderNum);
	
	List<String> selectPayerIds(String email);
	int isIdCount(String email, String payerId);
    int insertPayerId(PaypleInfoVO vo);
    int deletePayerId(String payerId);
    String findPg(String orderNum);
    PaymentVO selectAllFromOid(String orderNum);
    
    int justInsert(String email, String payerId);
    List<UserLocationVO> findAdmin();
    
    PaymentVO payDetail(String orderNum);
}
