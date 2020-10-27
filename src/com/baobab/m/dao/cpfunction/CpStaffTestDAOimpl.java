package com.baobab.m.dao.cpfunction;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.UserAllVO;

@Repository
public class CpStaffTestDAOimpl implements CpStaffTestDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate test;

	@Override
	public List<CPUserVO> testCpUser() {
		return test.selectList("com.baobab.m.dao.CpStaffTest.testCpUser");
	}

	@Override
	public List<UserAllVO> testUserAll() {
		return test.selectList("com.baobab.m.dao.CpStaffTest.testUserAll");
	}

	//�Ի糯¥ ó�� ���� �ʿ�
	@Override
	public void merge() {
		List<CPUserVO> cpUser = testCpUser();
		List<UserAllVO> userA = testUserAll();
		
		List<CpStaffVO> staffList = new ArrayList<CpStaffVO>();
		for(int i=0;i<cpUser.size();i++) {
			CpStaffVO vo = new CpStaffVO();
			vo.setEmail(cpUser.get(i).getEmail());
			for(int j=0;j<userA.size();j++) {
				if(cpUser.get(i).getEmail().contentEquals(userA.get(j).getEmail())) {
					vo.setStaffPhone(userA.get(j).getPhon_num());
					break;
				}
			}
			vo.setStaffName(cpUser.get(i).getAccount_holder());
			vo.setDivCode("c-01-01");
			vo.setRegistDate(cpUser.get(i).getCon_date());
			staffList.add(vo);
		}
		
		for(int i=0;i<staffList.size();i++) {
			testInsert(staffList.get(i));
		}
	}

	@Override
	public void testInsert(CpStaffVO vo) {
		test.insert("com.baobab.m.dao.CpStaffTest.testInsert", vo);
	}
}
