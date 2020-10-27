package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Mapper
public interface CPJoinMapper {
	void cpUserAllJoin(UserAllVO vo);
	void userHistoryJoin(UserHistoryVO vo);
	void cpUserJoin(CPUserVO vo);
	void cpJoin(CPInfoVO vo);
	void cpHistoryJoin(String cpName);
	void cpUpdate(CPInfoVO vo);
	void divCodeChange(String email);
	String dupName(String cpName);
	void cpUserUpdate(CPUserVO vo);
	List<MenuVO> getMenu(MenuVO vo);
	void updateMenu(MenuVO vo);
	CPInfoVO getCpInfo(CPInfoVO vo);
	void updateBasket(BasketVO vo);
	void updatePayment(PaymentVO vo);
	void updatePoke(PokeVO vo);
	CPUserVO getCpUserInfo(String email);
	CPUseVO cpUserInfo(String email);
	void changeCpUser(CPUseVO vo);
	CPInfoVO getQRCode(String email);
	void setOnOffCp(CPInfoVO vo);
	String selectCpStatus(CPInfoVO vo);
}
