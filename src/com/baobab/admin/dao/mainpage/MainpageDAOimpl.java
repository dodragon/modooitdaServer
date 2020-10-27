package com.baobab.admin.dao.mainpage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.UserTicketHistoryVO;

@Repository
public class MainpageDAOimpl implements MainpageDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate mp;

	@Override
	public int getUsers() {
		return mp.selectOne("com.baobab.admin.dao.AdminMainpageMapper.getUsers");
	}

	@Override
	public int getCp() {
		return mp.selectOne("com.baobab.admin.dao.AdminMainpageMapper.getCp");
	}

	@Override
	public int getPaid() {
		return mp.selectOne("com.baobab.admin.dao.AdminMainpageMapper.getPaid");
	}

	@Override
	public int getSales(String month) {
		return mp.selectOne("com.baobab.admin.dao.AdminMainpageMapper.getSales", month);
	}

	@Override
	public List<UserTicketHistoryVO> ticketHistory() {
		return mp.selectList("com.baobab.admin.dao.AdminMainpageMapper.ticketHistory");
	}

	@Override
	public int getVisit(String date) {
		return mp.selectOne("com.baobab.admin.dao.AdminMainpageMapper.getVisit", date);
	}

}
