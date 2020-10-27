package com.baobab.admin.dao.cp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.ReviewImgVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.SalesHistoryVO;

@Repository
public class CpDAOimpl implements CpDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cp;

	@Override
	public List<CPInfoVO> cpList() {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.cpList");
	}

	@Override
	public CPInfoVO defaultInfo(int cpSeq) {
		return cp.selectOne("com.baobab.admin.dao.AdminCPMapper.defaultInfo", cpSeq);
	}

	@Override
	public List<CpStaffVO> staffInfo(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.staffInfo", cpSeq);
	}

	@Override
	public int hits(int cpSeq) {
		return cp.selectOne("com.baobab.admin.dao.AdminCPMapper.hits", cpSeq);
	}

	@Override
	public List<EventCpVO> events(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.events", cpSeq);
	}

	@Override
	public List<EventCpOptionVO> options(String serial) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.options", serial);
	}

	@Override
	public List<EventCpMenuVO> menus(String serial) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.menus", serial);
	}

	@Override
	public List<MenuVO> defaultMenu(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.defaultMenu", cpSeq);
	}

	@Override
	public List<SalesHistoryVO> sales(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.sales", cpSeq);
	}

	@Override
	public List<ReviewsVO> reivews(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.reivews", cpSeq);
	}

	@Override
	public List<ReviewImgVO> revImages(String code) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.revImages", code);
	}

	@Override
	public List<CPmainImgVO> mainImage(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.mainImage", cpSeq);
	}

	@Override
	public int infoUpdate(CPInfoVO vo) {
		return cp.update("com.baobab.admin.dao.AdminCPMapper.infoUpdate", vo);
	}

	@Override
	public EventCpVO oneEvent(String serial) {
		return cp.selectOne("com.baobab.admin.dao.AdminCPMapper.oneEvent", serial);
	}

	@Override
	public EventCpOptionVO oneOption(String serial) {
		return cp.selectOne("com.baobab.admin.dao.AdminCPMapper.oneOption", serial);
	}

	@Override
	public EventCpMenuVO oneMenu(int seq) {
		return cp.selectOne("com.baobab.admin.dao.AdminCPMapper.oneMenu", seq);
	}

	@Override
	public List<EventCpVO> selectEventSerials(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.selectEventSerials", cpSeq);
	}

	@Override
	public List<EventCpOptionVO> selectOptionSerials(int cpSeq) {
		return cp.selectList("com.baobab.admin.dao.AdminCPMapper.selectOptionSerials", cpSeq);
	}

}
