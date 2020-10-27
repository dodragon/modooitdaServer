package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.UserTicketHistoryVO;

@Mapper
public interface AdminMainpageMapper {
	int getUsers();
	int getCp();
	int getPaid();
	int getVisit(String date);
	int getSales(String month);
	List<UserTicketHistoryVO> ticketHistory();
}
