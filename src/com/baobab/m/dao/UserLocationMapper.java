package com.baobab.m.dao;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.LocationLogVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface UserLocationMapper {
	void firstLocation(UserLocationVO vo);
	UserLocationVO selectLocation(UserLocationVO vo);
	void updateLocation(UserLocationVO vo);
	CPInfoVO pokeSelect(PokeVO vo);
	void locationLog(LocationLogVO vo);
}
