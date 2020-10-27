package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.MenuVO;

@Mapper
public interface StoreMenuMapper {
	List<MenuVO> getMenus(String cpName, String menuDiv);
	List<MenuVO> getOneMenu(MenuVO vo);
	List<MenuVO> getAllMenus(MenuVO vo);
}
