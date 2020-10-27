package com.baobab.m.dao.selectcp;

import java.util.List;

import com.baobab.m.vo.MenuVO;

public interface StoreMenuDAO {
	List<MenuVO> getMenus(int cpSeq);
	List<MenuVO> getOneMenu(String cpName, String menuName, int cpSeq);
	List<MenuVO> getAllMenus(int cpSeq, String menuName);
}
