package com.baobab.admin.dao.meetinglog;

import java.util.List;

import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.MeetingLogVO;

public interface MeetingLogDAO {
	List<MeetingLogVO> selectAll();
	MeetingLogVO selectDetail(int seqNum);
	int insert(MeetingLogVO vo);
	int update(MeetingLogVO vo);
	List<AdminAccountVO> selectAdminInfo();
}
