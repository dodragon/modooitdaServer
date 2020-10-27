package com.baobab.admin.dao.mainList;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.MainCpListTitleVO;
import com.baobab.m.vo.MainCpListVO;
import com.baobab.m.vo.MainListSearchVO;

@Repository
public class MainListDAOimpl implements MainListDAO{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ml;

	@Override
	public List<MainCpListTitleVO> selectTitle() {
		return ml.selectList("com.baobab.m.dao.MainListMapper.selectTitle");
	}
	
	@Override
	public String selectOneTitle(String div) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.selectOneTitle", div);
	}

	@Override
	public int updateTitle(MainCpListTitleVO vo) {
		return ml.update("com.baobab.m.dao.MainListMapper.updateTitle", vo);
	}

	@Override
	public List<EventCpMenuVO> selectMenus(int cpSeq) {
		return ml.selectList("com.baobab.m.dao.MainListMapper.selectMenus", cpSeq);
	}

	@Override
	public List<CPmainImgVO> selectImgs(int cpSeq) {
		return ml.selectList("com.baobab.m.dao.MainListMapper.selectImgs", cpSeq);
	}

	@Override
	public int insertMenus(MainCpListVO vo) {
		return ml.insert("com.baobab.m.dao.MainListMapper.insertMenus", vo);
	}

	@Override
	public EventCpMenuVO selectOneMenu(int seqNum) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.selectOneMenu", seqNum);
	}

	@Override
	public List<MainCpListVO> selectAll() {
		return ml.selectList("com.baobab.m.dao.MainListMapper.selectAll");
	}

	@Override
	public MainCpListVO selectOneCp(int cpSeq) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.selectOneCp", cpSeq);
	}

	@Override
	public int deleteCp(int seqNum) {
		return ml.delete("com.baobab.m.dao.MainListMapper.deleteCp", seqNum);
	}

	@Override
	public int updateCp(MainCpListVO vo) {
		return ml.update("com.baobab.m.dao.MainListMapper.updateCp", vo);
	}

	@Override
	public CPInfoVO getInfo(MainListSearchVO vo) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.getInfo", vo);
	}

	@Override
	public int getSalesRate(int cpSeq) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.getSalesRate", cpSeq);
	}

	@Override
	public List<MainCpListVO> getForUsers(MainListSearchVO vo) {
		return ml.selectList("com.baobab.m.dao.MainListMapper.getForUsers", vo);
	}

	@Override
	public double getRevRate(int cpSeq) {
		try {
			return ml.selectOne("com.baobab.m.dao.MainListMapper.getRevRate", cpSeq);
		}catch(NullPointerException e) {
			return 0.0;
		}
	}

	@Override
	public EventCpMenuVO ifNullRandomMenu(int cpSeq) {
		return ml.selectOne("com.baobab.m.dao.MainListMapper.ifNullRandomMenu", cpSeq);
	}
}
