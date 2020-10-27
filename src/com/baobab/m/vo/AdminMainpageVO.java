package com.baobab.m.vo;

import java.util.Arrays;
import java.util.List;

public class AdminMainpageVO {
	private int userEa;
	private int cpEa;
	private int payEa;
	private int visits;
	private int[] salesList;
	private String[] monthList;
	private List<UserTicketHistoryVO> ticketHistorys;
	public AdminMainpageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminMainpageVO(int userEa, int cpEa, int payEa, int visits, int[] salesList, String[] monthList,
			List<UserTicketHistoryVO> ticketHistorys) {
		super();
		this.userEa = userEa;
		this.cpEa = cpEa;
		this.payEa = payEa;
		this.visits = visits;
		this.salesList = salesList;
		this.monthList = monthList;
		this.ticketHistorys = ticketHistorys;
	}
	public int getUserEa() {
		return userEa;
	}
	public void setUserEa(int userEa) {
		this.userEa = userEa;
	}
	public int getCpEa() {
		return cpEa;
	}
	public void setCpEa(int cpEa) {
		this.cpEa = cpEa;
	}
	public int getPayEa() {
		return payEa;
	}
	public void setPayEa(int payEa) {
		this.payEa = payEa;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int[] getSalesList() {
		return salesList;
	}
	public void setSalesList(int[] salesList) {
		this.salesList = salesList;
	}
	public String[] getMonthList() {
		return monthList;
	}
	public void setMonthList(String[] monthList) {
		this.monthList = monthList;
	}
	public List<UserTicketHistoryVO> getTicketHistorys() {
		return ticketHistorys;
	}
	public void setTicketHistorys(List<UserTicketHistoryVO> ticketHistorys) {
		this.ticketHistorys = ticketHistorys;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpEa;
		result = prime * result + Arrays.hashCode(monthList);
		result = prime * result + payEa;
		result = prime * result + Arrays.hashCode(salesList);
		result = prime * result + ((ticketHistorys == null) ? 0 : ticketHistorys.hashCode());
		result = prime * result + userEa;
		result = prime * result + visits;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminMainpageVO other = (AdminMainpageVO) obj;
		if (cpEa != other.cpEa)
			return false;
		if (!Arrays.equals(monthList, other.monthList))
			return false;
		if (payEa != other.payEa)
			return false;
		if (!Arrays.equals(salesList, other.salesList))
			return false;
		if (ticketHistorys == null) {
			if (other.ticketHistorys != null)
				return false;
		} else if (!ticketHistorys.equals(other.ticketHistorys))
			return false;
		if (userEa != other.userEa)
			return false;
		if (visits != other.visits)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminMainpageVO [userEa=" + userEa + ", cpEa=" + cpEa + ", payEa=" + payEa + ", visits=" + visits
				+ ", salesList=" + Arrays.toString(salesList) + ", monthList=" + Arrays.toString(monthList)
				+ ", ticketHistorys=" + ticketHistorys + "]";
	}
}
