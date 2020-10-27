package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;

@Mapper
public interface AdminEventMapper {
	void eventUpdate(EventCpVO vo);
	void optionUpdate(EventCpOptionVO vo);
	void menuUpdate(EventCpMenuVO vo);
	void deleteEvent(String eventSerial);
	List<String> getOptionSeirials(String eventSerial);
	void deleteOption(String optionSerial);
	void deleteEventMenu(String optionSerial);
	void deleteOneMenu(int seq);
	int eventMainCheck(String serial);
	int eventOffCheck(String serial);
	
	void evnetInsert(EventCpVO vo);
	void optionInsert(EventCpOptionVO vo);
	void menuInsert(EventCpMenuVO vo);
}
