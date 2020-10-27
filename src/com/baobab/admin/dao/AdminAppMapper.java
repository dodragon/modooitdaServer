package com.baobab.admin.dao;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminAppVO;

@Mapper
public interface AdminAppMapper {
	AdminAppVO dataSelect();
	void updateData(AdminAppVO vo);
}
