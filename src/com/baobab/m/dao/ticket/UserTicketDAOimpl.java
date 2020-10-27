package com.baobab.m.dao.ticket;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.FreeTicketHistoryVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.UserLocationVO;
import com.baobab.m.vo.UserTicketHistoryVO;
import com.baobab.m.vo.UserTicketVO;

@Repository
public class UserTicketDAOimpl implements UserTicketDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate tic;

	@Override
	public int ticketInsert(UserTicketVO vo) {
		return tic.insert("com.baobab.m.dao.UserTicketMapper.ticketInsert", vo);
	}

	@Override
	public int ticketHistoryInsert(UserTicketHistoryVO vo) {
		return tic.insert("com.baobab.m.dao.UserTicketMapper.ticketHistoryInsert", vo);
	}

	@Override
	public List<UserTicketVO> selectUserTicket(String email) {
		return tic.selectList("com.baobab.m.dao.UserTicketMapper.selectUserTicket", email);
	}

	@Override
	public List<PayMenusVO> getPaidMenus(String orderNum) {
		return tic.selectList("com.baobab.m.dao.UserTicketMapper.getPaidMenus", orderNum);
	}

	@Override
	public int paymentUsed(String serial) {
		return tic.update("com.baobab.m.dao.UserTicketMapper.paymentUsed", serial);
	}

	@Override
	public int ticketDelete(String serial) {
		return tic.delete("com.baobab.m.dao.UserTicketMapper.ticketDelete", serial);
	}

	@Override
	public int ticketUsedConfirm(String serial) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.ticketUsedConfirm", serial);
	}

	@Override
	public UserTicketVO ticketScanConfirm(String serial) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.ticketScanConfirm", serial);
	}

	@Override
	public int getCpSeq(String email) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.getCpSeq", email);
	}

	@Override
	public UserLocationVO userPush(String serial) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.userPush", serial);
	}

	@Override
	public UserLocationVO localUserPush(String phone) {
		if(phone.contains("+")) {
			phone = phone.replaceAll("+82", "0");
		}
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.localUserPush", phone);
	}

	@Override
	public UserLocationVO cpPush(String serial) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.cpPush", serial);
	}

	@Override
	public int ticketCancel(String orderNum) {
		return tic.delete("com.baobab.m.dao.UserTicketMapper.ticketCancel", orderNum);
	}

	@Override
	public int ticketCancelHistory(String orderNum) {
		return tic.insert("com.baobab.m.dao.UserTicketMapper.ticketCancelHistory", orderNum);
	}

	@Override
	public List<UserTicketHistoryVO> useTicketHistory(String email) {
		return tic.selectList("com.baobab.m.dao.UserTicketMapper.useTicketHistory", email);
	}

	@Override
	public String getSerial(String orderNum) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.getSerial", orderNum);
	}

	@Override
	public int passwordCheck(HttpServletRequest request) {
		String pw = request.getParameter("pw");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		
		CPInfoVO vo = new CPInfoVO();
		vo.setSeq_num(cpSeq);
		vo.setCpPassword(pw);
		
		int selectSeq = tic.selectOne("com.baobab.m.dao.UserTicketMapper.passwordCheck", vo);
		
		if(cpSeq == selectSeq) {
			return 0;
		}else {
			return 1;
		}
	}

	@Override
	public UserLocationVO cpPushSelect(String email) {
		return tic.selectOne("com.baobab.m.dao.UserTicketMapper.cpPushSelect", email);
	}

	@Override
	public int freeTicketInsert(HttpServletRequest request) {
		FreeTicketHistoryVO vo = new FreeTicketHistoryVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setDisprice(Integer.parseInt(request.getParameter("disprice")));
		vo.setCpName(request.getParameter("cpName"));
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		return tic.insert("com.baobab.m.dao.UserTicketMapper.freeTicket", vo);
	}
	
}
