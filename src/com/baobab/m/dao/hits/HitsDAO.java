package com.baobab.m.dao.hits;

import java.util.List;

import com.baobab.m.vo.HitsVO;

public interface HitsDAO {
	int newHits(HitsVO vo);
	List<HitsVO> todaySelect(int cpSeq);
	List<HitsVO> yesterdaySelect(int cpSeq);
	List<HitsVO> allSelect(int cpSeq);
}
