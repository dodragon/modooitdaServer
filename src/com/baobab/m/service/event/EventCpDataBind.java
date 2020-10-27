package com.baobab.m.service.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;

@Service
public class EventCpDataBind {

	@Autowired
	EventCpDAO event;
	
	public List<EventCpVO> dataBinding(int cpSeq){
		List<EventCpVO> list = event.eventCpSelect(cpSeq);
		for(int i=0;i<list.size();i++) {
			List<EventCpOptionVO> optionList = event.optionSelect(list.get(i).getSeqNum());
			for(int j=0;j<optionList.size();j++) {
				List<EventCpMenuVO> menuList = event.menuSelect(optionList.get(j).getSeqNum());
				optionList.get(j).setMenuList(menuList);
			}
			list.get(i).setOptionList(optionList);
		}
		return list;
	}
	
	public List<EventCpVO> infoDataBinding(int cpSeq){
		List<EventCpVO> list = event.eventInfo(cpSeq);
		for(int i=0;i<list.size();i++) {
			List<EventCpOptionVO> optionList = event.optionSelect(list.get(i).getSeqNum());
			for(int j=0;j<optionList.size();j++) {
				List<EventCpMenuVO> menuList = event.menuSelect(optionList.get(j).getSeqNum());
				optionList.get(j).setMenuList(menuList);
			}
			list.get(i).setOptionList(optionList);
		}
		return list;
	}
}
