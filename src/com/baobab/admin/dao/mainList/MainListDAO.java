package com.baobab.admin.dao.mainList;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.MainCpListTitleVO;
import com.baobab.m.vo.MainCpListVO;
import com.baobab.m.vo.MainListSearchVO;

public interface MainListDAO {
	List<MainCpListTitleVO> selectTitle();
	String selectOneTitle(String div);
	int updateTitle(MainCpListTitleVO vo);
	List<EventCpMenuVO> selectMenus(int cpSeq);
	EventCpMenuVO selectOneMenu(int seqNum);
	EventCpMenuVO ifNullRandomMenu(int cpSeq);
	List<CPmainImgVO> selectImgs(int cpSeq);
	int insertMenus(MainCpListVO vo);
	List<MainCpListVO> selectAll();
	MainCpListVO selectOneCp(int cpSeq);
	int deleteCp(int seqNum);
	int updateCp(MainCpListVO vo);
	//list
	List<MainCpListVO> getForUsers(MainListSearchVO vo);
	CPInfoVO getInfo(MainListSearchVO vo);
	int getSalesRate(int cpSeq);
	double getRevRate(int cpSeq);
}
