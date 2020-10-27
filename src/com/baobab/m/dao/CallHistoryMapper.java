package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CallHistoryVO;

public interface CallHistoryMapper {
	void getHistory(CallHistoryVO vo);
	List<CallHistoryVO> showHistory(String userPhone);
	void delHistory(int seqNum);
}
