package com.baobab.m.dao.servefunction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ShowPokeVO;

public interface PokeDAO {
	void getPoke(String email, String cpName, String cpAddr, int score, int revNum, String divCode, int cpSeq);
	void delPoke(String email, String cpName, String divCode, int cpSeq);
	List<ShowPokeVO> showPoke(HttpServletRequest request);
	int pokeConfirm(String email, String cpName, String divCode, int cpSeq);
	List<PokeVO> showMetheFan(String email);
}
