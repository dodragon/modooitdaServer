package com.baobab.m.dao.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.vo.ReviewImgVO;
import com.baobab.m.vo.ReviewsSelectVO;
import com.baobab.m.vo.ReviewsVO;

@Repository
public class ReviewsDAOimpl implements ReviewsDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate rev;

	@Override
	public int reviewInsert(HttpServletRequest request) {
		ReviewsVO vo = new ReviewsVO();
		vo.setUserEmail(request.getParameter("userEmail"));
		vo.setNickName(request.getParameter("nickName"));
		vo.setScore(Integer.parseInt(request.getParameter("score")));
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setContent(request.getParameter("content"));
		vo.setRevCode(request.getParameter("revCode"));
		vo.setOrderNum(request.getParameter("orderNum"));
		
		int result = rev.insert("com.baobab.m.dao.ReviewsMapper.reviewInsert", vo) + changeFlag(request.getParameter("orderNum"));
		
		if(result > 0) {
			rev.update("com.baobab.m.dao.ReviewsMapper.cpRevInfoUpdate", vo.getCpSeq());
		}
		
		return result;
	}

	@Override
	public int reviewImgInsert(MultipartHttpServletRequest request) throws IOException {
		ReviewImgVO vo = new ReviewImgVO();
		FtpClient ftp = new FtpClient();
		vo.setRevCode(request.getParameter("revCode"));
		vo.setImgUrl(ftp.ftp(ftp.convert(request.getFile("revImg")), request.getParameter("imgName"), "/ourReviews/"));
		return rev.insert("com.baobab.m.dao.ReviewsMapper.reviewImgInsert", vo);
	}

	@Override
	public int changeFlag(String orderNum) {
		return rev.update("com.baobab.m.dao.ReviewsMapper.changeFlag", orderNum);
	}

	@Override
	public List<ReviewsSelectVO> menuActSelectRev(int cpSeq) {
		List<ReviewsSelectVO> list = rev.selectList("com.baobab.m.dao.ReviewsMapper.menuActSelectRev", cpSeq);
		for(int i=0;i<list.size();i++) {
			list.get(i).setPayMenus(getPaymenus(list.get(i).getOrderNum()));
			list.get(i).setImgUrls(getReviewImgs(list.get(i).getRevCode()));
		}
		return list;
	}

	@Override
	public String getPaymenus(String orderNum) {
		List<String> payMenusList = rev.selectList("com.baobab.m.dao.ReviewsMapper.getPaymenus", orderNum);
		if(payMenusList.size() > 1) {
			return payMenusList.get(0) + "¿Ü " + (payMenusList.size() - 1) + "°³";
		}else {
			return payMenusList.get(0);
		}
	}

	@Override
	public List<String> getReviewImgs(String revCode) {
		return rev.selectList("com.baobab.m.dao.ReviewsMapper.getReviewImgs", revCode);
	}
}
