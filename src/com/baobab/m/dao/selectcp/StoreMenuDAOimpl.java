package com.baobab.m.dao.selectcp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.MenuVO;

@Repository
public class StoreMenuDAOimpl implements StoreMenuDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate getMenu;
	
	@Override
	public List<MenuVO> getMenus(int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		return getMenu.selectList("com.baobab.m.dao.StoreMenuMapper.getMenus", vo);
	}

	@Override
	public List<MenuVO> getOneMenu(String cpName, String menuName, int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		return getMenu.selectList("com.baobab.m.dao.StoreMenuMapper.getOneMenu", vo);
	}

	@Override
	public List<MenuVO> getAllMenus(int cpSeq, String menuName) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		vo.setMenu_name(menuName);
		return getMenu.selectList("com.baobab.m.dao.StoreMenuMapper.getAllMenus", vo);
	}

}
