package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.MainCpListTitleVO;
import com.baobab.m.vo.MainCpListVO;
import com.baobab.m.vo.MainListSearchVO;

@Mapper
public interface MainListMapper {
	List<MainCpListTitleVO> selectTitle();
	String selectOneTitle(String div);
	void updateTitle(MainCpListTitleVO vo);
	List<EventCpMenuVO> selectMenus(int cpSeq);
	EventCpMenuVO selectOneMenu(int seqNum);
	EventCpMenuVO ifNullRandomMenu(int cpSeq);
	List<CPmainImgVO> selectImgs(int cpSeq);
	void insertMenus(MainCpListVO vo);
	List<MainCpListVO> selectAll();
	MainCpListVO selectOneCp(int cpSeq);
	void deleteCp(int seqNum);
	void updateCp(MainCpListVO vo);
	List<MainCpListVO> getForUsers(MainListSearchVO vo);
	CPInfoVO getInfo(MainListSearchVO vo);
	int getSalesRate(int cpSeq);
	double getRevRate(int cpSeq);
}
