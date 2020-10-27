package com.baobab.admin.dao.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class NoticeDAOimpl implements NoticeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate no;

	@Override
	public List<NoticeVO> selectNotice() {
		return no.selectList("com.baobab.admin.dao.AdminNoticeMapper.selectNotice");
	}

	@Override
	public NoticeVO detail(int seq) {
		return no.selectOne("com.baobab.admin.dao.AdminNoticeMapper.detail", seq);
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return no.insert("com.baobab.admin.dao.AdminNoticeMapper.insertNotice", vo);
	}

	@Override
	public List<UserLocationVO> selectUsers(String div) {
		return no.selectList("com.baobab.admin.dao.AdminNoticeMapper.selectUsers", div);
	}

}
