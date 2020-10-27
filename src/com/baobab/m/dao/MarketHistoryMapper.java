package com.baobab.m.dao;

import com.baobab.m.vo.MarketHistoryVO;

@Mapper
public interface MarketHistoryMapper {

	void insertMarket(MarketHistoryVO vo);
}
