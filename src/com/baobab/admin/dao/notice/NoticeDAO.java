package com.baobab.admin.dao.notice;

import java.util.List;

import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

public interface NoticeDAO {
	List<NoticeVO> selectNotice();
	NoticeVO detail(int seq);
	int insertNotice(NoticeVO vo);
	List<UserLocationVO> selectUsers(String div);
}
