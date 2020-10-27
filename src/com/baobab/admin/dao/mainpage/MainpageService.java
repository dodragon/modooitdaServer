package com.baobab.admin.dao.mainpage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.vo.AdminMainpageVO;

@Service
public class MainpageService {
	
	@Autowired
	MainpageDAO dao;
	
	public AdminMainpageVO getMainPageVO() {
		AdminMainpageVO vo = new AdminMainpageVO();
		
		vo.setUserEa(dao.getUsers());
		vo.setCpEa(dao.getCp());
		vo.setPayEa(dao.getPaid());
		vo.setVisits(dao.getVisit(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "%"));
		vo.setMonthList(getMonthList());

		int[] salesArr = new int[12];
		String[] queryMonthArr = getQueryMonthList();
		for(int i=0;i<queryMonthArr.length;i++) {
			salesArr[i] = dao.getSales(queryMonthArr[i]);
		}
		
		vo.setSalesList(salesArr);
		vo.setTicketHistorys(dao.ticketHistory());
		
		return vo;
	}
	
	private String[] getMonthList() {
		String[] monthArr = new String[12];
		
		for(int i=11;i>=0;i--) {
			monthArr[i] = getMonth(i);
		}
		
		return monthArr;
	}
	
	private String[] getQueryMonthList() {
		String[] monthArr = new String[12];
		
		for(int i=11;i>=0;i--) {
			monthArr[i] = getMonth(i) + "%";
		}
		
		return monthArr;
	}
	
	private String getMonth(int num) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance( );
		cal.add ( cal.MONTH, -num ); 
		String date = df.format(cal.getTime());
		String monthDate = date.substring(0, 7);
		return monthDate;
	}
}
