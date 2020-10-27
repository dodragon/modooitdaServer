package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.UserAllVO;

@Mapper
public interface AdminOwnerMapper {
	List<CPUseVO> cpUserListSelect();
	CPUseVO cpUserSelect(String email);
	UserAllVO userSelect(String email);
}