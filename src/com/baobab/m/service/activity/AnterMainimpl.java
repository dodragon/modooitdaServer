package com.baobab.m.service.activity;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.admin.dao.mainList.MainListDAO;
import com.baobab.m.dao.adminfunction.VisitantDAO;
import com.baobab.m.dao.advertisement.AdImagesDAO;
import com.baobab.m.service.adminservice.VersionCheck;
import com.baobab.m.service.main_list.MainListService;
import com.baobab.m.vo.AnterMainVO;

@Service
public class AnterMainimpl implements AnterMain {
	
	@Autowired
	VisitantDAO vis;
	@Autowired
	VersionCheck ver;
	@Autowired
	AdImagesDAO adver;
	@Autowired
	MainListService list;
	@Autowired
	MainListDAO mDao;

	@Override
	public AnterMainVO anterMain(HttpServletRequest request) throws ParseException {
		vis.visit(request.getParameter("user"), request.getParameter("os"));
		
		AnterMainVO vo = new AnterMainVO();

		vo.setMainListVO(list.getMainList(request));
		vo.setMainTitle(mDao.selectTitle());
		vo.setVersion(ver.versionChecking(request));
		vo.setAdImgVOList(adver.selAdImages());
		return vo;
	}
}
