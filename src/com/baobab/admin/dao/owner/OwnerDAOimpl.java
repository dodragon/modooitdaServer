package com.baobab.admin.dao.owner;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.UserAllVO;

@Repository
public class OwnerDAOimpl implements OwnerDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ow;

	@Override
	public List<CPUseVO> cpUserListSelect() {
		List<CPUseVO> list = ow.selectList("com.baobab.admin.dao.AdminOwnerMapper.cpUserListSelect");
		for(int i=0;i<list.size();i++) {
			list.get(i).setUserPhone(new StringBuffer(list.get(i).getUserPhone()).insert(3, "-").insert(
					new StringBuffer(list.get(i).getUserPhone()).insert(3, "-").length() - 4, "-").toString());
		}
		return list;
	}

	@Override
	public CPUseVO cpUserSelect(String email) {
		CPUseVO vo = ow.selectOne("com.baobab.admin.dao.AdminOwnerMapper.cpUserSelect", email);
		
		StringBuffer licenseSb = new StringBuffer(vo.getCP_license_num());
		licenseSb = licenseSb.insert(3, "-");
		licenseSb = licenseSb.insert(licenseSb.length() - 5, "-");
		vo.setCP_license_num(licenseSb.toString());
		
		return vo;
	}

	@Override
	public UserAllVO userSelect(String email) {
		UserAllVO vo = ow.selectOne("com.baobab.admin.dao.AdminOwnerMapper.userSelect", email);
		
		StringBuffer phoneSb = new StringBuffer(vo.getPhon_num());
		phoneSb.insert(3, "-");
		phoneSb.insert(phoneSb.length() - 4, "-");
		vo.setPhon_num(phoneSb.toString());
		StringBuffer birthSb = new StringBuffer(vo.getBirth());
		birthSb.insert(4, "³â ");
		birthSb.insert(8, "¿ù ");
		vo.setBirth(birthSb.toString() + "ÀÏ");
		
		return vo;
	}

}
