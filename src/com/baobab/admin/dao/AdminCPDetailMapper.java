package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PokeVO;

@Mapper
public interface AdminCPDetailMapper {
	CPInfoVO cpInfo(String cpName);
	List<PokeVO> poke(String cpName);
	List<MenuVO> menu(String cpName);
	
	//delete
	void delStaff(int cpSeq);
	void delHits(int cpSeq);
	void delMainImg(int cpSeq);
	void delInfo(int cpSeq);
	void delCpUser(String email);
	void delMenu(int cpSeq);
	
	void upUserCode(String email);
	
	void delReview(int cpSeq);
	void delReviewImgs(String revCode);
	
	List<String> selRevCode(int cpSeq);
	
	void delEventMenu(String optionSerial);
	void delEventOption(String eventSerial);
	void delEvent(int cpSeq);
	
	List<String> selEventSerial(int cpSeq);
	List<String> selOptionSerial(String eventSerial);
	List<String> selMainImgUrl(int cpSeq);
	List<String> selMenuImg(int cpSeq);
	List<String> selRevImgUrl(String revCode);
	
	void logoUpdate(CPInfoVO vo);
}
