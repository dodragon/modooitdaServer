package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baobab.m.dao.login.LoginDAO;
import com.baobab.m.dao.selectcp.StoreMenuDAO;
import com.baobab.m.vo.CPMenuActivityVO;

@Service
public class CPMenuActivityimpl implements CPMenuActivity {
	@Autowired
	LoginDAO log;
	@Autowired
	StoreMenuDAO store;
	
	@Override
	public CPMenuActivityVO cpMenu(HttpServletRequest request) {
		CPMenuActivityVO vo = new CPMenuActivityVO();
		vo.setCpInfoVO(log.getStoreInfo(request.getParameter("cpName"), request.getParameter("email")));
		vo.setMenuVOList(store.getMenus(Integer.parseInt(request.getParameter("cpSeq"))));
		if(vo.getCpInfoVO() ==  null) {
			vo.setCpInfoVO(log.getStoreInfoForManager(request.getParameter("email")));
		}
		return vo;
	}

	
}
