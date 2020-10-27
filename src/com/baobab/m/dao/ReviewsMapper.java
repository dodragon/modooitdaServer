package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.ReviewImgVO;
import com.baobab.m.vo.ReviewsSelectVO;
import com.baobab.m.vo.ReviewsVO;

@Mapper
public interface ReviewsMapper {
	void reviewInsert(ReviewsVO vo);
	void reviewImgInsert(ReviewImgVO vo);
	void changeFlag(String orderNum);
	
	void cpRevInfoUpdate(int cpSeq);
	
	List<ReviewsSelectVO> menuActSelectRev(int cpSeq);
	List<String> getPaymenus(String orderNum);
	List<String> getReviewImgs(String revCode);
}
