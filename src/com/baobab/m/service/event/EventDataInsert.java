package com.baobab.m.service.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class EventDataInsert {
	
	@Autowired
	EventCpDAO dao;
	
	public int allInsert(String data) {
		Gson gson = new Gson();
		EventCpVO vo = gson.fromJson(data, EventCpVO.class);
		
		int eventInsert = dao.eventInsert(vo);
		int optionInsert = 0;
		int menuInsert = 0;
		
		for(int i=0;i<vo.getOptionList().size();i++) {
			optionInsert += dao.optionInsert(vo.getOptionList().get(i));
			for(int j=0;j<vo.getOptionList().get(i).getMenuList().size();j++) {
				menuInsert += dao.menuInsert(vo.getOptionList().get(i).getMenuList().get(j));
			}
		}
		
		int turnNumSetting = dao.turnNumSetting(vo);
		
		return eventInsert + optionInsert + menuInsert + turnNumSetting;
	}
	
	public int eventUpdate(String data, String isMain) {
		Gson gson = new Gson();
		EventCpVO vo = gson.fromJson(data, EventCpVO.class);
		
		String eventSerial = vo.getEventSerial();
		List<EventCpOptionVO> optionList = dao.optionSelFromEv(eventSerial);
		
		int menuDelResult = 0;
		for(int i=0;i<optionList.size();i++) {
			menuDelResult += dao.menuDelete(optionList.get(i).getOptionSerial());
		}
		
		int eventUpdateResult = dao.eventUpdate(vo);
		
		int optionDelResult = dao.optionDelete(eventSerial);
		
		int newOption = 0;
		int newMenu = 0;
		for(int i=0;i<vo.getOptionList().size();i++) {
			newOption += dao.optionInsert(vo.getOptionList().get(i));
			for(int j=0;j<vo.getOptionList().get(i).getMenuList().size();j++) {
				newMenu = dao.menuInsert(vo.getOptionList().get(i).getMenuList().get(j));
			}
		}
		
		if(isMain.equals("true")) {
			dao.changeMain(vo.getCpSeq(), 0);
		}
		
		return menuDelResult + eventUpdateResult + optionDelResult + newOption + newMenu;
	}
	
	public int eventDelete(String data) {
		Gson gson = new Gson();
		List<String> serialList = gson.fromJson(data, new TypeToken<List<String>>() {}.getType());
		
		int eventResult = 0;
		int optionResult = 0;
		int menuResult = 0;
		
		for(int i=0;i<serialList.size();i++) {
			List<EventCpOptionVO> optionList = dao.optionSelFromEv(serialList.get(i));
			
			for(int j=0;j<optionList.size();j++) {
				menuResult += dao.menuDelete(optionList.get(j).getOptionSerial());
			}
			
			optionResult += dao.optionDelete(serialList.get(i));
			eventResult += dao.eventDelete(serialList.get(i));
		}
		
		return eventResult + optionResult + menuResult;
	}
	
	public int turnChange(String data) {
		int result = 0;
		
		Gson gson = new Gson();
		List<EventCpVO> list = gson.fromJson(data, new TypeToken<List<EventCpVO>>() {}.getType());
		
		for(int i=0;i<list.size();i++) {
			result += dao.turnUpdate(list.get(i));
		}
		
		return result;
	}
}
