package com.baobab.m.service.activity;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.admin.dao.mainList.MainListDAO;
import com.baobab.m.dao.adminfunction.UserLocationDAO;
import com.baobab.m.dao.selectcp.GetOurCPDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.PageTobListVO;
import com.baobab.m.vo.PageVO;

@Service
public class PageActivityimpl implements PageActivity {

	@Autowired
	UserLocationDAO userLoc;
	@Autowired
	GetOurCPDAO getour;
	@Autowired
	MainListDAO listDao;
	
	@Override
	public PageVO Page(HttpServletRequest request) {
		PageVO vo = new PageVO();
		vo.setLoclog(userLoc.locationLog(request));
		
		PageSearchVO svo = new PageSearchVO();
		svo.setSearchWord(request.getParameter("searchWord"));
		svo.setDiv(request.getParameter("categoryDiv"));
		svo.setLocation(request.getParameter("location"));
		svo.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		svo.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		svo.setTopPageInt(Integer.parseInt(request.getParameter("topPageInt")));
		svo.setBotPageInt(Integer.parseInt(request.getParameter("botPageInt")));
		
		String tabDiv = request.getParameter("tabDiv");
		String sortDiv = request.getParameter("sortDiv");
		
		if(sortDiv.equals("거리순")) {
			if(tabDiv.equals("전체")) {
				vo.setTobList(topList(getour.distanceAll(svo)));
				vo.setBotList(getour.bottomAll(svo));
			}else if(tabDiv.equals("안심")) {
				vo.setTobList(topList(getour.distanceSafe(svo)));
				vo.setBotList(getour.bottomSafe(svo));
			}else {
				vo.setTobList(topList(getour.distanceAll(svo)));
				vo.setBotList(getour.bottomPD(svo));
			}
		}else {
			if(tabDiv.equals("전체")) {
				vo.setTobList(topList(getour.populateAll(svo)));
				vo.setBotList(getour.bottomAll(svo));
			}else if(tabDiv.equals("안심")) {
				vo.setTobList(topList(getour.populateSafe(svo)));
				vo.setBotList(getour.bottomSafe(svo));
			}else {
				vo.setTobList(topList(getour.populateAll(svo)));
				vo.setBotList(getour.bottomPP(svo));
			}
		}
		
		
		return vo;
	}
	
	public List<PageTobListVO> topList(List<CPInfoVO> infoList){
		List<PageTobListVO> list = new ArrayList<>();
		
		for(int i=0;i<infoList.size();i++) {
			PageTobListVO vo = new PageTobListVO();
			vo.setInfoVO(infoList.get(i));
			if(infoList.get(i).getMainEvent() == 0) {
				vo.setMenuVO(getour.selectEventOne(infoList.get(i).getSeq_num()));
			}else {
				EventCpMenuVO menuVo = getour.selectMainEvent(infoList.get(i).getSeq_num());
				if(menuVo == null) {
					menuVo = listDao.ifNullRandomMenu(infoList.get(i).getSeq_num());
				}
				vo.setMenuVO(menuVo);
			}
			
			list.add(vo);
		}
		return list;
	}
}
