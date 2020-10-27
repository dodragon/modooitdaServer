package com.baobab.admin.dao.push;

import java.util.List;

import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

public interface AdminPushDAO {
	List<AdminPushVO> selectList();
	AdminPushVO detail(int seq);
	int insert(AdminPushVO vo);
	List<UserLocationVO> selectOurUsers();
	List<UserLocationVO> selectVisitUsers();
}
