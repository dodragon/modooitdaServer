package com.baobab.admin.dao.mainList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baobab.m.vo.MainCpListTitleVO;
import com.baobab.m.vo.MainCpListVO;

@Service
public class MainListService {

	@Autowired
	MainListDAO dao;
	
	public String selectTitlts(Model model) {
		List<MainCpListTitleVO> list = dao.selectTitle();
		for(MainCpListTitleVO vo : list) {
			if(vo.getTitleDiv().equals("t")) {
				model.addAttribute("top", vo);
			}else if(vo.getTitleDiv().equals("b")){
				model.addAttribute("bot", vo);
			}
		}
		return "admin/mainListTitle";
	}
	
	public int updateTitlts(HttpServletRequest request) {
		MainCpListTitleVO top = new MainCpListTitleVO();
		MainCpListTitleVO bot = new MainCpListTitleVO();
		
		top.setMainText(request.getParameter("mainTitleTop"));
		top.setSubText(request.getParameter("subTitleTop"));
		top.setTitleStatus(request.getParameter("statusTop"));
		top.setTitleDiv("t");
		top.setWriter(request.getParameter("writer"));
		
		bot.setMainText(request.getParameter("mainTitleBot"));
		bot.setSubText(request.getParameter("subTitleBot"));
		bot.setTitleStatus(request.getParameter("statusBot"));
		bot.setTitleDiv("b");
		bot.setWriter(request.getParameter("writer"));
		
		return dao.updateTitle(top) + dao.updateTitle(bot);
	}
	
	public int insertCp(HttpServletRequest request) {
		MainCpListVO vo = new MainCpListVO();
		
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setListDiv(request.getParameter("title"));
		vo.setMenuSeq(Integer.parseInt(request.getParameter("menuSeq")));
		vo.setImgUrl(request.getParameter("imgUrl"));
		
		return dao.insertMenus(vo);
	}
	
	public String cpListSelect(Model model) {
		List<MainCpListVO> cpList = dao.selectAll();
		
		for(MainCpListVO vo : cpList) {
			vo.setMenuName(dao.selectOneMenu(vo.getMenuSeq()).getMenuName());
			
			if(vo.getListDiv().equals("b")) {
				vo.setListDiv("(하단)" + dao.selectOneTitle(vo.getListDiv()));
			}else {
				vo.setListDiv("(상단)" + dao.selectOneTitle(vo.getListDiv()));
			}
		}
		
		model.addAttribute("cpList", cpList);
		
		return "admin/mainCp";
	}
	
	public void cpOneSelect(Model model, int cpSeq) {
		MainCpListVO vo = dao.selectOneCp(cpSeq);

		
		if(vo.getListDiv().equals("b")) {
			vo.setListDiv("(하단)" + dao.selectOneTitle(vo.getListDiv()));
		}else {
			vo.setListDiv("(상단)" + dao.selectOneTitle(vo.getListDiv()));
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("menu", dao.selectOneMenu(vo.getMenuSeq()));
	}
	
	public int updateMainCp(HttpServletRequest request) {
		MainCpListVO vo = new MainCpListVO();
		vo.setListDiv(request.getParameter("title"));
		vo.setMenuSeq(Integer.parseInt(request.getParameter("menuSeq")));
		vo.setImgUrl(request.getParameter("imgUrl"));
		vo.setSeqNum(Integer.parseInt(request.getParameter("seqNum")));
		
		return dao.updateCp(vo);
	}
}
