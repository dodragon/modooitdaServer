package com.baobab.m.dao.servefunction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.dao.cpfunction.MainImgUploadDAO;
import com.baobab.m.vo.PokeSearchVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ShowPokeVO;

@Repository
public class PokeDAOimpl implements PokeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate poke;
	@Autowired
	MainImgUploadDAO mainUp;

	@Override
	public void getPoke(String email, String cpName, String cpAddr, int score, int revNum, String divCode, int cpSeq) {
		if(pokeConfirm(email, cpName, divCode, cpSeq) == 0) {
			PokeVO vo = new PokeVO();
			vo.setEmail(email);
			vo.setCp_name(cpName);
			vo.setCp_address(cpAddr);
			vo.setScore(score);
			vo.setRev_num(revNum);
			vo.setDiv_code(divCode);
			vo.setCp_seq(cpSeq);
			poke.update("com.baobab.m.dao.PokeMapper.getPoke", vo);
		}
	}

	@Override
	public void delPoke(String email, String cpName, String divCode, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setEmail(email);
		vo.setCp_name(cpName);
		vo.setDiv_code(divCode);
		vo.setCp_seq(cpSeq);
		poke.delete("com.baobab.m.dao.PokeMapper.delPoke", vo);
	}

	@Override
	public List<ShowPokeVO> showPoke(HttpServletRequest request) {
		List<ShowPokeVO> list = new ArrayList<>();
		String email = request.getParameter("email");
		
		PokeSearchVO psvo = new PokeSearchVO();
		psvo.setEmail(email);
		psvo.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		psvo.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		
		List<PokeVO> pokeList = poke.selectList("com.baobab.m.dao.PokeMapper.showPoke", email);
		for(int i=0;i<pokeList.size();i++) {
			ShowPokeVO vo = new ShowPokeVO();
			int cpSeq = pokeList.get(i).getCp_seq();
			psvo.setCpSeq(cpSeq);
			vo.setPokeVO(pokeList.get(i));
			vo.setCpInfoVO(poke.selectOne("com.baobab.m.dao.PokeMapper.pokeCpInfo", psvo));
			vo.setImgVoList(mainUp.getMainImg(cpSeq));
			list.add(vo);
		}
		return list;
	}

	@Override
	public int pokeConfirm(String email, String cpName, String divCode, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setEmail(email);
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		vo.setDiv_code(divCode);
		int result = poke.selectOne("com.baobab.m.dao.PokeMapper.pokeConfirm", vo);
		System.out.println("Æ÷Å© ÄÁÆß : " + result);
		return result;
	}

	@Override
	public List<PokeVO> showMetheFan(String email) {
		System.out.println(poke.selectList("com.baobab.m.dao.PokeMapper.showMetheFan", email).toString());
		return poke.selectList("com.baobab.m.dao.PokeMapper.showMetheFan", email);
	}
}
