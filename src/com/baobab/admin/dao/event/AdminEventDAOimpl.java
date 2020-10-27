package com.baobab.admin.dao.event;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;

@Repository
public class AdminEventDAOimpl implements AdminEventDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ev;

	@Override
	public int eventUpdate(EventCpVO vo) {
		return ev.update("com.baobab.admin.dao.AdminEventMapper.eventUpdate", vo);
	}
	
	@Override
	public int optionUpdate(EventCpOptionVO vo) {
		return ev.update("com.baobab.admin.dao.AdminEventMapper.optionUpdate", vo);
	}

	@Override
	public int menuUpdate(EventCpMenuVO vo) {
		return ev.update("com.baobab.admin.dao.AdminEventMapper.menuUpdate", vo);
	}

	@Override
	public int deleteEvent(String eventSerial) {
		return ev.delete("com.baobab.admin.dao.AdminEventMapper.deleteEvent", eventSerial);
	}

	@Override
	public List<String> getOptionSeirials(String eventSerial) {
		return ev.selectList("com.baobab.admin.dao.AdminEventMapper.getOptionSeirials", eventSerial);
	}

	@Override
	public int deleteOption(String optionSerial) {
		return ev.delete("com.baobab.admin.dao.AdminEventMapper.deleteOption", optionSerial);
	}

	@Override
	public int deleteEventMenu(String optionSerial) {
		return ev.delete("com.baobab.admin.dao.AdminEventMapper.deleteEventMenu", optionSerial);
	}

	@Override
	public int deleteOneMenu(int seq) {
		return ev.delete("com.baobab.admin.dao.AdminEventMapper.deleteOneMenu", seq);
	}

	@Override
	public int eventMainCheck(String serial) {
		return ev.selectOne("com.baobab.admin.dao.AdminEventMapper.eventMainCheck", serial);
	}

	@Override
	public int eventOffCheck(String serial) {
		return ev.selectOne("com.baobab.admin.dao.AdminEventMapper.eventOffCheck", serial);
	}

	@Override
	public int evnetInsert(EventCpVO vo) {
		return ev.insert("com.baobab.admin.dao.AdminEventMapper.evnetInsert", vo);
	}

	@Override
	public int optionInsert(EventCpOptionVO vo) {
		return ev.insert("com.baobab.admin.dao.AdminEventMapper.optionInsert", vo);
	}

	@Override
	public int menuInsert(EventCpMenuVO vo) {
		return ev.insert("com.baobab.admin.dao.AdminEventMapper.menuInsert", vo);
	}
}
