package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface AdminNoticeMapper {
	List<NoticeVO> selectNotice();
	List<NoticeVO> userSelect(String div);
	NoticeVO detail(int seq);
	void insertNotice(NoticeVO vo);
	List<UserLocationVO> selectUsers(String div);
}
