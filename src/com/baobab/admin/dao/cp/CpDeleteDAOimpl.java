package com.baobab.admin.dao.cp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CpDeleteDAOimpl implements CpDeleteDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cd;

	@Override
	public int delStaff(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delStaff", cpSeq);
	}

	@Override
	public int delHits(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delHits", cpSeq);
	}

	@Override
	public int delMainImg(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delMainImg", cpSeq);
	}

	@Override
	public int delInfo(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delInfo", cpSeq);
	}

	@Override
	public int delCpUser(String email) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delCpUser", email);
	}

	@Override
	public int delMenu(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delMenu", cpSeq);
	}

	@Override
	public int upUserCode(String email) {
		return cd.update("com.baobab.admin.dao.AdminCPDetailMapper.upUserCode", email);
	}

	@Override
	public int delReview(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delReview", cpSeq);
	}

	@Override
	public int delReviewImgs(String revCode) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delReviewImgs", revCode);
	}

	@Override
	public List<String> selRevCode(int cpSeq) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selRevCode", cpSeq);
	}

	@Override
	public int delEventMenu(String optionSerial) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delEventMenu", optionSerial);
	}

	@Override
	public int delEventOption(String eventSerial) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delEventOption", eventSerial);
	}

	@Override
	public int delEvent(int cpSeq) {
		return cd.delete("com.baobab.admin.dao.AdminCPDetailMapper.delEvent", cpSeq);
	}

	@Override
	public List<String> selEventSerial(int cpSeq) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selEventSerial", cpSeq);
	}

	@Override
	public List<String> selOptionSerial(String eventSerial) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selOptionSerial", eventSerial);
	}

	@Override
	public List<String> selMainImgUrl(int cpSeq) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selMainImgUrl", cpSeq);
	}

	@Override
	public List<String> selMenuImg(int cpSeq) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selMenuImg", cpSeq);
	}

	@Override
	public List<String> selRevImgUrl(String revCode) {
		return cd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.selRevImgUrl", revCode);
	}
}
