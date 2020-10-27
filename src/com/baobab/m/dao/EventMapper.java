package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.SalesHistoryVO;

@Mapper
public interface EventMapper {
	List<EventCpVO> eventInfo(int cpSeq);
	List<EventCpVO> eventCpSelect(int cpSeq);
	List<EventCpOptionVO> optionSelect(int eventSeq);
	List<EventCpMenuVO> menuSelect(int optionSeq);
	
	void eventInsert(EventCpVO vo);
	void optionInsert(EventCpOptionVO vo);
	void menuInsert(EventCpMenuVO vo);
	
	List<EventCpOptionVO> optionSelFromEv(String eventSerial);
	void menuDelete(String optionSerial);
	void optionDelete(String eventSerial);
	void eventUpdate(EventCpVO vo);
	
	void eventDelete(String eventSerial);
	
	void turnNumSetting(EventCpVO vo);
	void turnUpdate(EventCpVO vo);
	
	String optionNameSelect(String optionSerial);
	
	void menuRateUp(int seqNum);
	void optionRateUp(String optionSerial);
	void eventRateUp(String optionSerial);
	
	void changeMain(CPInfoVO vo);
	int getMain(int cpSeq);
	
	void salesHistoryInsert(SalesHistoryVO vo);
	void updateSales(SalesHistoryVO vo);
	List<SalesHistoryVO> selectSalesList(SalesHistoryVO vo);
	
	void setOnOff(EventCpVO vo);
	EventCpMenuVO checkedMain(EventCpVO vo);
}
