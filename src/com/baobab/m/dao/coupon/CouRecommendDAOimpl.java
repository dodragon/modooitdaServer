package com.baobab.m.dao.coupon;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;

@Repository
public class CouRecommendDAOimpl implements CouRecommendDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate couRec;
	
	@Override
	public List<CPInfoVO> couponRecommend(int cpSeq) {
		List<CPInfoVO> list = couRec.selectList("com.baobab.m.dao.CouRecommendMapper.couponRecommend", cpSeq);
		list.add(findThisCp(cpSeq));
		return list;
	}

	@Override
	public CPInfoVO findThisCp(int cpSeq) {
		return couRec.selectOne("com.baobab.m.dao.CouRecommendMapper.findThisCp", cpSeq);
	}
}
