package com.baobab.m.dao.adminfunction;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.VisitUserVO;

@Repository
public class VisitantDAOimpl implements VisitantDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate visit;

	@Override
	public int visit(String user, String os) {
		VisitUserVO vo = new VisitUserVO();
		vo.setUser(user);
		vo.setOs(os);
		return visit.insert("com.baobab.m.dao.VisitantMapper.visit", vo);
	}
}
