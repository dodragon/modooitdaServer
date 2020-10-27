package com.baobab.admin.dao.owner;

import java.util.List;

import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.UserAllVO;

public interface OwnerDAO {
	List<CPUseVO> cpUserListSelect();
	CPUseVO cpUserSelect(String email);
	UserAllVO userSelect(String email);
}
