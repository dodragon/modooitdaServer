package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PageBottomListVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.SafeCpVO;

@Mapper
public interface GetOurCPMapper {
	List<CPInfoVO> distanceAll(PageSearchVO vo);
	List<CPInfoVO> distanceSafe(PageSearchVO vo);
	List<CPInfoVO> populateAll(PageSearchVO vo);
	List<CPInfoVO> populateSafe(PageSearchVO vo);
	
	List<PageBottomListVO> bottomAll(PageSearchVO vo);
	List<PageBottomListVO> bottomSafe(PageSearchVO vo);
	List<PageBottomListVO> bottomPD(PageSearchVO vo);
	List<PageBottomListVO> bottomPP(PageSearchVO vo);
	
	EventCpMenuVO selectMainEvent(int cpSeq);
	EventCpMenuVO selectEventOne(int cpSeq);
	List<CPInfoVO> selectAllCp();
	List<String> selectAddrGroup();
	
	SafeCpVO bottomSafeDetail(int safeNo);
	CPInfoVO bottomCpDetail(int seq);
}
