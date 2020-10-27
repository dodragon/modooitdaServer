package com.baobab.m.dao.hits;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.HitsVO;

@Repository
public class HitsDAOimpl implements HitsDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate hit;

	@Override
	public int newHits(HitsVO vo) {
		return hit.insert("com.baobab.m.dao.HitsMapper.newHits", vo);
	}

	@Override
	public List<HitsVO> todaySelect(int cpSeq) {
		return hit.selectList("com.baobab.m.dao.HitsMapper.todaySelect", cpSeq);
	}

	@Override
	public List<HitsVO> yesterdaySelect(int cpSeq) {
		return hit.selectList("com.baobab.m.dao.HitsMapper.yesterdaySelect", cpSeq);
	}

	@Override
	public List<HitsVO> allSelect(int cpSeq) {
		return hit.selectList("com.baobab.m.dao.HitsMapper.allSelect", cpSeq);
	}

}
