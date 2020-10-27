package com.baobab.m.dao.event;

import java.util.List;

import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.SalesHistoryVO;

public interface EventCpDAO {
	List<EventCpVO> eventInfo(int cpSeq);
	List<EventCpVO> eventCpSelect(int cpSeq);
	List<EventCpOptionVO> optionSelect(int eventSeq);
	List<EventCpMenuVO> menuSelect(int optionSeq);
	
	int eventInsert(EventCpVO vo);
	int optionInsert(EventCpOptionVO vo);
	int menuInsert(EventCpMenuVO vo);
	
	List<EventCpOptionVO> optionSelFromEv(String eventSerial);
	int menuDelete(String optionSerial);
	int optionDelete(String eventSerial);
	int eventUpdate(EventCpVO vo);
	
	int eventDelete(String eventSerial);
	
	int turnNumSetting(EventCpVO vo);
	int turnUpdate(EventCpVO vo);
	
	String optionNameSelect(String optionSerial);
	
	int menuRateUp(int seqNum);
	int optionRateUp(String optionSerial);
	int eventRateUp(String optionSerial);
	
	int changeMain(int cpSeq, int menuSeq);
	int getMain(int cpSeq);
	
	int salesHistoryInsert(SalesHistoryVO vo);
	int updateSales(SalesHistoryVO vo);
	List<SalesHistoryVO> selectSalesList(int cpSeq, String start, String end);
	
	String setOnOff(String eventSerial, String onOff, int mainSeq, int cpSeq);
	EventCpMenuVO checkedMain(EventCpVO vo);
}
