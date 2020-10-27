package com.baobab.admin.dao.app;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AdminAppVO;

@Repository
public class AppDAOimpl implements AppDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate app;

	@Override
	public AdminAppVO dataSelect() {
		return app.selectOne("com.baobab.admin.dao.AdminAppMapper.dataSelect");
	}

	@Override
	public void updateData(HttpServletRequest request) {
		AdminAppVO vo = new AdminAppVO();
		vo.setNew_version(Integer.parseInt(request.getParameter("version")));
		vo.setInspection(request.getParameter("status"));
		vo.setAlmightyPW(request.getParameter("pw"));
		app.update("com.baobab.admin.dao.AdminAppMapper.updateData", vo);
	}

}
