package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PokeSearchVO;
import com.baobab.m.vo.PokeVO;

@Mapper
public interface PokeMapper {
	void getPoke(PokeVO vo);
	void delPoke(PokeVO vo);
	List<PokeVO> showPoke(String email);
	int pokeConfirm(PokeVO vo);
	List<PokeVO> showMetheFan(String email);
	CPInfoVO pokeCpInfo(PokeSearchVO vo);
}
