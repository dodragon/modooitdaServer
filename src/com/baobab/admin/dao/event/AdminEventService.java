package com.baobab.admin.dao.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baobab.m.service.rsa.RandomNumber;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.google.gson.Gson;

@Service
public class AdminEventService {
	
	@Autowired
	AdminEventDAO dao;
	
	public int eventUpdate(HttpServletRequest request) {
		String status = request.getParameter("status");
		String serial = request.getParameter("serial");
		if(status.equals("open")) {
			EventCpVO vo = new EventCpVO();
			vo.setEventName(request.getParameter("eventName"));
			vo.setEventSerial(serial);
			vo.setEventStatus(status);
			return dao.eventUpdate(vo);
		}else {
			if(dao.eventMainCheck(serial) == 1) {
				return 0;
			}else if(dao.eventOffCheck(serial) == 0) {
				return -1;
			}else {
				EventCpVO vo = new EventCpVO();
				vo.setEventName(request.getParameter("eventName"));
				vo.setEventSerial(serial);
				vo.setEventStatus(status);
				return dao.eventUpdate(vo);
			}
		}
	}
	
	public int optionUpdate(HttpServletRequest request) {
		EventCpOptionVO vo = new EventCpOptionVO();
		vo.setOptionName(request.getParameter("optionName"));
		vo.setEventSerial(request.getParameter("eventSerial"));
		vo.setOptionSerial(request.getParameter("optionSerial"));
		return dao.optionUpdate(vo);
	}
	
	public int menuUpdate(HttpServletRequest request) {
		EventCpMenuVO vo = new EventCpMenuVO();
		vo.setMenuName(request.getParameter("menuName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setDisPrice(Integer.parseInt(request.getParameter("disPrice")));
		vo.setPercentAge(Integer.parseInt(request.getParameter("percentAge")));
		vo.setMenuInfo(request.getParameter("menuInfo"));
		vo.setOptionSerial(request.getParameter("optionSerial"));
		vo.setSeqNum(Integer.parseInt(request.getParameter("seqNum")));
		return dao.menuUpdate(vo);
	}
	
	public String eventDelete(Model model, HttpServletRequest request) {
		String eventSerial = request.getParameter("serial");
		List<String> optionSerials = dao.getOptionSeirials(eventSerial);
		
		int optionResult = 0;
		int menuResult = 0;
		for(int i=0;i<optionSerials.size();i++) {
			optionResult += dao.deleteOption(optionSerials.get(i));
			menuResult += dao.deleteEventMenu(optionSerials.get(i));
		}
		
		model.addAttribute("action", "delete");
		model.addAttribute("eventResult", dao.deleteEvent(eventSerial));
		model.addAttribute("optionResult", optionResult);
		model.addAttribute("menuResult", menuResult);
		model.addAttribute("seq", Integer.parseInt(request.getParameter("cpSeq")));
		model.addAttribute("url", "./cpDetail.api");
		
		return "admin/adminEventRedirect";
	}
	
	public String optionDelete(Model model, HttpServletRequest request) {
		String optionSerial = request.getParameter("serial");
		model.addAttribute("action", "delete");
		model.addAttribute("optionResult", dao.deleteOption(optionSerial));
		model.addAttribute("menuResult", dao.deleteEventMenu(optionSerial));
		model.addAttribute("serial", request.getParameter("eventSerial"));
		model.addAttribute("url", "./eventDetail.api");
		return "admin/adminEventRedirect";
	}
	
	public String menuDelete(Model model, HttpServletRequest request) {
		model.addAttribute("action", "delete");
		model.addAttribute("menuResult", dao.deleteOneMenu(Integer.parseInt(request.getParameter("seq"))));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("cpSeq")));
		model.addAttribute("serial", request.getParameter("optionSerial"));
		model.addAttribute("url", "./optionDetail.api");
		return "admin/adminEventRedirect";
	}
	
	public String insertAllEventInfo(Model model, HttpServletRequest request) {
		EventCpVO vo = new Gson().fromJson(request.getParameter("data"), EventCpVO.class);
		String eventSerial = makeSerial("ev", vo.getCpSeq());
		vo.setEventSerial(eventSerial);
		int eventResult = dao.evnetInsert(vo);
		int optionResult = 0;
		int menuResult = 0;
		
		for(int i=0;i<vo.getOptionList().size();i++) {
			vo.getOptionList().get(i).setEventSerial(eventSerial);
			String optionSerial = makeSerial("op", vo.getCpSeq());
			vo.getOptionList().get(i).setOptionSerial(optionSerial);
			optionResult += dao.optionInsert(vo.getOptionList().get(i));
			
			for(int j=0;j<vo.getOptionList().get(i).getMenuList().size();j++) {
				vo.getOptionList().get(i).getMenuList().get(j).setOptionSerial(optionSerial);
				menuResult += dao.menuInsert(vo.getOptionList().get(i).getMenuList().get(j));
			}
		}
		
		model.addAttribute("action", "insert");
		model.addAttribute("eventResult", eventResult);
		model.addAttribute("optionResult", optionResult);
		model.addAttribute("menuResult", menuResult);
		model.addAttribute("seq", vo.getCpSeq());
		model.addAttribute("url", "./cpDetail.api");
		
		return "admin/adminEventRedirect";
	}
	
	public String optionInsert(Model model, HttpServletRequest request) {
		EventCpOptionVO vo = new Gson().fromJson(request.getParameter("data"), EventCpOptionVO.class);
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		String optionSerial = makeSerial("op", cpSeq);
		
		vo.setOptionSerial(optionSerial);
		int optionResult = dao.optionInsert(vo);
		int menuResult = 0;
		
		for(int i=0;i<vo.getMenuList().size();i++) {
			vo.getMenuList().get(i).setOptionSerial(optionSerial);
			menuResult += dao.menuInsert(vo.getMenuList().get(i));
		}
		
		model.addAttribute("action", "insert");
		model.addAttribute("optionResult", optionResult);
		model.addAttribute("menuResult", menuResult);
		model.addAttribute("serial", vo.getEventSerial());
		model.addAttribute("url", "./eventDetail.api");
		
		return "admin/adminEventRedirect";
	}
	
	public String menuInsert(Model model, HttpServletRequest request) {
		EventCpMenuVO vo = new Gson().fromJson(request.getParameter("data"), EventCpMenuVO.class);
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		
		model.addAttribute("action", "insert");
		model.addAttribute("menuResult", dao.menuInsert(vo));
		model.addAttribute("serial", vo.getOptionSerial());
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("url", "./optionDetail.api");
		
		return "admin/adminEventRedirect";
	}
	
	private String makeSerial(String div, int cpSeq) {
		RandomNumber rn = new RandomNumber(10, 1);
		return div + cpSeq + rn.numberGen();
	}
}
