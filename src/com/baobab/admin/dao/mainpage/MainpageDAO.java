package com.baobab.admin.dao.mainpage;

import java.util.List;

import com.baobab.m.vo.UserTicketHistoryVO;

public interface MainpageDAO {
	int getUsers();
	int getCp();
	int getPaid();
	int getVisit(String date);
	int getSales(String month);
	List<UserTicketHistoryVO> ticketHistory();
}
