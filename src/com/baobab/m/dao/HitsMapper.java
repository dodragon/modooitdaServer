package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.HitsVO;

@Mapper
public interface HitsMapper {
	void newHits(HitsVO vo);
	List<HitsVO> todaySelect(int cpSeq);
	List<HitsVO> yesterdaySelect(int cpSeq);
	List<HitsVO> allSelect(int cpSeq);
}
