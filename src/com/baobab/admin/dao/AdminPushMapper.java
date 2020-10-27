package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface AdminPushMapper {
	List<AdminPushVO> selectList();
	AdminPushVO detail(int seq);
	void insert(AdminPushVO vo);
	List<UserLocationVO> selectOurUsers();
	List<UserLocationVO> selectVisitUsers();
}
