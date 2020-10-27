package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.ReviewImgVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.SalesHistoryVO;

@Mapper
public interface AdminCPMapper {
	List<CPInfoVO> cpList();
	
	CPInfoVO defaultInfo(int cpSeq);
	List<CpStaffVO> staffInfo(int cpSeq);
	List<CPmainImgVO> mainImage(int cpSeq);
	int hits(int cpSeq);
	List<EventCpVO> events(int cpSeq);
	EventCpVO oneEvent(String serial);
	List<EventCpOptionVO> options(String serial);
	EventCpOptionVO oneOption(String serial);
	List<EventCpMenuVO> menus(String serial);
	EventCpMenuVO oneMenu(int seq);
	List<EventCpVO> selectEventSerials(int cpSeq);
	List<EventCpOptionVO> selectOptionSerials(int cpSeq);
	List<MenuVO> defaultMenu(int cpSeq);
	List<SalesHistoryVO> sales(int cpSeq);
	List<ReviewsVO> reivews(int cpSeq);
	List<ReviewImgVO> revImages(String code);
	
	void infoUpdate(CPInfoVO vo);
}
