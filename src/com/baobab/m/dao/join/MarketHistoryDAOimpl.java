package com.baobab.m.dao.join;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.MarketHistoryVO;

@Repository
public class MarketHistoryDAOimpl implements MarketHistoryDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate mark;
	
	@Override
	public void insertMarket(String cp, String root) {
		MarketHistoryVO vo = new MarketHistoryVO();
		vo.setCp(cp);
		vo.setRoot(root);
		mark.insert("com.baobab.m.dao.MarketHistoryMapper.insertMarket", vo);
		
	}

}
