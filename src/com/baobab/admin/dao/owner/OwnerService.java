package com.baobab.admin.dao.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.vo.OwnerInfoVO;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDAO dao;
	
	public OwnerInfoVO getVo(String email) {
		OwnerInfoVO vo = new OwnerInfoVO();
		
		vo.setCpUser(dao.cpUserSelect(email));
		vo.setUser(dao.userSelect(email));
		
		return vo;
	}
}
