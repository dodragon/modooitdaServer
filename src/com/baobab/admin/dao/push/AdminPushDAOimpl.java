package com.baobab.admin.dao.push;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class AdminPushDAOimpl implements AdminPushDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate pu;

	@Override
	public List<AdminPushVO> selectList() {
		return pu.selectList("com.baobab.admin.dao.AdminPushMapper.selectList");
	}

	@Override
	public AdminPushVO detail(int seq) {
		return pu.selectOne("com.baobab.admin.dao.AdminPushMapper.detail", seq);
	}

	@Override
	public int insert(AdminPushVO vo) {
		return pu.insert("com.baobab.admin.dao.AdminPushMapper.insert", vo);
	}

	@Override
	public List<UserLocationVO> selectOurUsers() {
		return pu.selectList("com.baobab.admin.dao.AdminPushMapper.selectOurUsers");
	}

	@Override
	public List<UserLocationVO> selectVisitUsers() {
		return pu.selectList("com.baobab.admin.dao.AdminPushMapper.selectVisitUsers");
	}

}
