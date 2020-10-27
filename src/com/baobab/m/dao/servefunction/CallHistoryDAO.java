package com.baobab.m.dao.servefunction;

import java.util.List;

import com.baobab.m.vo.CallHistoryVO;

public interface CallHistoryDAO {
	void getHistory(String userPhone, String cpPhone, String cpName, String cpAddress, String cpDiv);
	List<CallHistoryVO> showHistory(String userPhone);
	void delHistory(int seqNum);
}
