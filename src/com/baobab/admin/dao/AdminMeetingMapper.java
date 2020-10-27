package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.MeetingLogVO;

@Mapper
public interface AdminMeetingMapper {
	List<MeetingLogVO> selectAll();
	MeetingLogVO selectDetail(int seqNum);
	void insert(MeetingLogVO vo);
	void update(MeetingLogVO vo);
	List<AdminAccountVO> selectAdminInfo();
}
