package com.baobab.m.service.main_list;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.admin.dao.mainList.MainListDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.MainCpListVO;
import com.baobab.m.vo.MainListSearchVO;
import com.baobab.m.vo.MainListTotalVO;

@Service
public class MainListServiceimpl implements MainListService {
	
	@Autowired
	MainListDAO dao;

	@Override
	public List<MainListTotalVO> getMainList(HttpServletRequest request) {
		List<MainListTotalVO> list = new ArrayList<MainListTotalVO>();
		
		MainListSearchVO searchVo = new MainListSearchVO();
		searchVo.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		searchVo.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		List<MainCpListVO> mainCpList = dao.getForUsers(searchVo);
		
		for(int i=0;i<mainCpList.size();i++) {
			MainListTotalVO totalVo = new MainListTotalVO();
			totalVo.setMainListVO(mainCpList.get(i));
			searchVo.setCpSeq(mainCpList.get(i).getCpSeq());
			CPInfoVO infoVo = dao.getInfo(searchVo);
			infoVo.setRev_grade(dao.getRevRate(mainCpList.get(i).getCpSeq()));
			totalVo.setCpInfoVO(infoVo);
			EventCpMenuVO menuVo = dao.selectOneMenu(mainCpList.get(i).getMenuSeq());
			if(menuVo == null) {
				menuVo = dao.ifNullRandomMenu(mainCpList.get(i).getCpSeq());
			}
			totalVo.setMenuVO(menuVo);
			totalVo.setTotalSales(dao.getSalesRate(mainCpList.get(i).getCpSeq()));
			list.add(totalVo);
		}
		
		return list;
	}

}
