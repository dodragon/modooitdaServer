package com.baobab.admin.dao.meetinglog;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.MeetingLogVO;

@Repository
public class MeetingLogDAOimpl implements MeetingLogDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ml;

	@Override
	public List<MeetingLogVO> selectAll() {
		return ml.selectList("com.baobab.admin.dao.AdminMeetingMapper.selectAll");
	}

	@Override
	public MeetingLogVO selectDetail(int seqNum) {
		return replaceEnter(ml.selectOne("com.baobab.admin.dao.AdminMeetingMapper.selectDetail", seqNum));
	}

	@Override
	public int insert(MeetingLogVO vo) {
		return ml.insert("com.baobab.admin.dao.AdminMeetingMapper.insert", vo);
	}

	@Override
	public int update(MeetingLogVO vo) {
		return ml.update("com.baobab.admin.dao.AdminMeetingMapper.update", vo);
	}

	@Override
	public List<AdminAccountVO> selectAdminInfo() {
		return ml.selectList("com.baobab.admin.dao.AdminMeetingMapper.selectAdminInfo");
	}

	private MeetingLogVO replaceEnter(MeetingLogVO vo) {
		vo.setMeetingContents(vo.getMeetingContents().replaceAll("\r\n", "<br>"));
		vo.setMeetingResult(vo.getMeetingResult().replaceAll("\r\n", "<br>"));
		return vo;
	}
}
