package com.baobab.m.dao.selectcp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PageBottomListVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.SafeCpVO;

@Repository
public class GetOurCPDAOimpl implements GetOurCPDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate getCp;
	
	@Override
	public EventCpMenuVO selectMainEvent(int cpSeq) {
		return getCp.selectOne("com.baobab.m.dao.GetOurCPMapper.selectMainEvent", cpSeq);
	}

	@Override
	public List<CPInfoVO> selectAllCp() {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.selectAllCp");
	}

	@Override
	public EventCpMenuVO selectEventOne(int cpSeq) {
		return getCp.selectOne("com.baobab.m.dao.GetOurCPMapper.selectEventOne", cpSeq);
	}

	@Override
	public List<String> selectAddrGroup() {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.selectAddrGroup");
	}

	@Override
	public List<CPInfoVO> distanceAll(PageSearchVO vo) {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.distanceAll", vo);
	}

	@Override
	public List<CPInfoVO> distanceSafe(PageSearchVO vo) {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.distanceSafe", vo);
	}

	@Override
	public List<CPInfoVO> populateAll(PageSearchVO vo) {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.populateAll", vo);
	}

	@Override
	public List<CPInfoVO> populateSafe(PageSearchVO vo) {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.populateSafe", vo);
	}

	@Override
	public List<PageBottomListVO> bottomAll(PageSearchVO vo) {
		if(vo.getDiv().equals("음식점")) {
			vo.setDiv("");
		}
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.bottomAll", vo);
	}

	@Override
	public List<PageBottomListVO> bottomSafe(PageSearchVO vo) {
		if(vo.getDiv().equals("음식점")) {
			vo.setDiv("");
		}
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.bottomSafe", vo);
	}

	@Override
	public List<PageBottomListVO> bottomPD(PageSearchVO vo) {
		if(vo.getDiv().equals("음식점")) {
			vo.setDiv("");
		}
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.bottomPD", vo);
	}

	@Override
	public List<PageBottomListVO> bottomPP(PageSearchVO vo) {
		if(vo.getDiv().equals("음식점")) {
			vo.setDiv("");
		}
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.bottomPP", vo);
	}

	@Override
	public SafeCpVO bottomSafeDetail(int safeNo) {
		return getCp.selectOne("com.baobab.m.dao.GetOurCPMapper.bottomSafeDetail", safeNo);
	}

	@Override
	public CPInfoVO bottomCpDetail(int seq) {
		return getCp.selectOne("com.baobab.m.dao.GetOurCPMapper.bottomCpDetail", seq);
	}
}