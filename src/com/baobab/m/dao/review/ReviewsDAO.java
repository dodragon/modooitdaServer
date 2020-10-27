package com.baobab.m.dao.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.vo.ReviewsSelectVO;

public interface ReviewsDAO {
	int reviewInsert(HttpServletRequest request);
	int reviewImgInsert(MultipartHttpServletRequest request) throws IOException;
	int changeFlag(String orderNum);
	
	List<ReviewsSelectVO> menuActSelectRev(int cpSeq);
	String getPaymenus(String orderNum);
	List<String> getReviewImgs(String revCode);
}
