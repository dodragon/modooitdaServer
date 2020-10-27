package com.baobab.admin.dao.event;

import java.util.List;

import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;

public interface AdminEventDAO {
	int eventUpdate(EventCpVO vo);
	int optionUpdate(EventCpOptionVO vo);
	int menuUpdate(EventCpMenuVO vo);
	int deleteEvent(String eventSerial);
	List<String> getOptionSeirials(String eventSerial);
	int deleteOption(String optionSerial);
	int deleteEventMenu(String optionSerial);
	int deleteOneMenu(int seq);
	int eventMainCheck(String serial);
	int eventOffCheck(String serial);
	
	int evnetInsert(EventCpVO vo);
	int optionInsert(EventCpOptionVO vo);
	int menuInsert(EventCpMenuVO vo);
}
