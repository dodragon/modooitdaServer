package com.baobab.m.dao.event;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.SalesHistoryVO;

@Repository
public class EventCpDAOimpl implements EventCpDAO{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate event;
	
	@Override
	public List<EventCpVO> eventCpSelect(int cpSeq){
		return event.selectList("com.baobab.m.dao.EventMapper.eventCpSelect", cpSeq);
	}

	@Override
	public List<EventCpOptionVO> optionSelect(int eventSeq) {
		return event.selectList("com.baobab.m.dao.EventMapper.optionSelect", eventSeq);
	}

	@Override
	public List<EventCpMenuVO> menuSelect(int optionSeq) {
		return event.selectList("com.baobab.m.dao.EventMapper.menuSelect", optionSeq);
	}

	@Override
	public int eventInsert(EventCpVO vo) {
		return event.insert("com.baobab.m.dao.EventMapper.eventInsert", vo);
	}

	@Override
	public int optionInsert(EventCpOptionVO vo) {
		return event.insert("com.baobab.m.dao.EventMapper.optionInsert", vo);
	}

	@Override
	public int menuInsert(EventCpMenuVO vo) {
		return event.insert("com.baobab.m.dao.EventMapper.menuInsert", vo);
	}

	@Override
	public List<EventCpOptionVO> optionSelFromEv(String eventSerial) {
		return event.selectList("com.baobab.m.dao.EventMapper.optionSelFromEv", eventSerial);
	}

	@Override
	public int menuDelete(String optionSerial) {
		return event.delete("com.baobab.m.dao.EventMapper.menuDelete", optionSerial);
	}

	@Override
	public int optionDelete(String eventSerial) {
		return event.delete("com.baobab.m.dao.EventMapper.optionDelete", eventSerial);
	}

	@Override
	public int eventUpdate(EventCpVO vo) {
		return event.update("com.baobab.m.dao.EventMapper.eventUpdate", vo);
	}

	@Override
	public int eventDelete(String eventSerial) {
		return event.delete("com.baobab.m.dao.EventMapper.eventDelete", eventSerial);
	}

	@Override
	public int turnNumSetting(EventCpVO vo) {
		return event.update("com.baobab.m.dao.EventMapper.turnNumSetting", vo);
	}

	@Override
	public int turnUpdate(EventCpVO vo) {
		return event.update("com.baobab.m.dao.EventMapper.turnUpdate", vo);
	}

	@Override
	public String optionNameSelect(String optionSerial) {
		return event.selectOne("com.baobab.m.dao.EventMapper.optionNameSelect", optionSerial);
	}

	@Override
	public int menuRateUp(int seqNum) {
		return event.update("com.baobab.m.dao.EventMapper.menuRateUp", seqNum);
	}

	@Override
	public int optionRateUp(String optionSerial) {
		return event.update("com.baobab.m.dao.EventMapper.optionRateUp", optionSerial);
	}

	@Override
	public int eventRateUp(String optionSerial) {
		return event.update("com.baobab.m.dao.EventMapper.eventRateUp", optionSerial);
	}

	@Override
	public int changeMain(int cpSeq, int menuSeq) {
		CPInfoVO vo = new CPInfoVO();
		vo.setMainEvent(menuSeq);
		vo.setSeq_num(cpSeq);
		return event.update("com.baobab.m.dao.EventMapper.changeMain", vo);
	}

	@Override
	public int getMain(int cpSeq) {
		return event.selectOne("com.baobab.m.dao.EventMapper.getMain", cpSeq);
	}

	@Override
	public int salesHistoryInsert(SalesHistoryVO vo) {
		return event.insert("com.baobab.m.dao.EventMapper.salesHistoryInsert", vo);
	}

	@Override
	public int updateSales(SalesHistoryVO vo) {
		return event.update("com.baobab.m.dao.EventMapper.updateSales", vo);
	}

	@Override
	public List<SalesHistoryVO> selectSalesList(int cpSeq, String start, String end) {
		SalesHistoryVO vo = new SalesHistoryVO();
		vo.setCpSeq(cpSeq);
		vo.setMenuName(start);
		vo.setOptionName(end);
		return event.selectList("com.baobab.m.dao.EventMapper.selectSalesList", vo);
	}

	@Override
	public String setOnOff(String eventSerial, String onOff, int mainSeq, int cpSeq) {
		EventCpVO vo = new EventCpVO();
		vo.setEventSerial(eventSerial);
		vo.setEventStatus(onOff);
		vo.setSeqNum(mainSeq);
		
		EventCpMenuVO mainMenu = checkedMain(vo);
		List<EventCpVO> eventList = eventCpSelect(cpSeq);
		if(mainMenu == null) {
			boolean allClose = true;
			for(int i=0;i<eventList.size();i++) {
				if(!eventList.get(i).getEventSerial().equals(eventSerial) && eventList.get(i).getEventStatus().equals("open")) {
					allClose = false;
				}
			}
			if(allClose) {
				return "allClose";
			}else {
				event.update("com.baobab.m.dao.EventMapper.setOnOff", vo);
				return "success";
			}
		}else {
			return "isMain";
		}
	}

	@Override
	public EventCpMenuVO checkedMain(EventCpVO vo) {
		return event.selectOne("com.baobab.m.dao.EventMapper.checkedMain", vo);
	}

	@Override
	public List<EventCpVO> eventInfo(int cpSeq) {
		return event.selectList("com.baobab.m.dao.EventMapper.eventInfo", cpSeq);
	}
}
