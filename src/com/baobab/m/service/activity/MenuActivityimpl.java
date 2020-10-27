package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.coupon.CouRecommendDAO;
import com.baobab.m.dao.cpfunction.MainImgUploadDAO;
import com.baobab.m.dao.review.ReviewsDAO;
import com.baobab.m.dao.selectcp.StoreMenuDAO;
import com.baobab.m.service.event.EventCpDataBind;
import com.baobab.m.vo.MenuActivityVO;

@Service
public class MenuActivityimpl implements MenuActivity {

	@Autowired
	StoreMenuDAO store;
	@Autowired
	MainImgUploadDAO mainImg;
	@Autowired
	CouRecommendDAO rec;
	@Autowired
	EventCpDataBind event;
	@Autowired
	ReviewsDAO rev;
	
	@Override
	public MenuActivityVO MenuAct(HttpServletRequest request) {
		MenuActivityVO vo = new MenuActivityVO();
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		vo.setMenuVOList(store.getMenus(cpSeq));
		vo.setcPmainImgVOList(mainImg.getMainImg(cpSeq));
		vo.setRecommendCPVO(rec.couponRecommend(cpSeq));
		vo.setEventCpVOList(event.dataBinding(cpSeq));
		vo.setReviewsListVO(rev.menuActSelectRev(cpSeq));
		return vo;
	}

}
