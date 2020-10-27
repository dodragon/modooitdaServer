package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPmainImgVO;

@Mapper
public interface AdminMainImgMapper {
	List<CPmainImgVO> getImgs(int cpSeq);
	void insertImg(CPmainImgVO vo);
	void deleteImg(CPmainImgVO vo);
}
