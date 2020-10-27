package com.baobab.m.vo;

import java.util.List;

public class AdminUserDetailVO {
	private UserAllVO defaultInfo;
	private String userLocation;
	private List<PaymentVO> payList;
	private List<List<PayMenusVO>> paymenuInfo;
	private List<UserTicketHistoryVO> ticketList;
	private List<ReviewsVO> revList;
	private List<PokeVO> pokeList;
	public AdminUserDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminUserDetailVO(UserAllVO defaultInfo, String userLocation, List<PaymentVO> payList,
			List<List<PayMenusVO>> paymenuInfo, List<UserTicketHistoryVO> ticketList, List<ReviewsVO> revList,
			List<PokeVO> pokeList) {
		super();
		this.defaultInfo = defaultInfo;
		this.userLocation = userLocation;
		this.payList = payList;
		this.paymenuInfo = paymenuInfo;
		this.ticketList = ticketList;
		this.revList = revList;
		this.pokeList = pokeList;
	}
	public UserAllVO getDefaultInfo() {
		return defaultInfo;
	}
	public void setDefaultInfo(UserAllVO defaultInfo) {
		this.defaultInfo = defaultInfo;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	public List<PaymentVO> getPayList() {
		return payList;
	}
	public void setPayList(List<PaymentVO> payList) {
		this.payList = payList;
	}
	public List<List<PayMenusVO>> getPaymenuInfo() {
		return paymenuInfo;
	}
	public void setPaymenuInfo(List<List<PayMenusVO>> paymenuInfo) {
		this.paymenuInfo = paymenuInfo;
	}
	public List<UserTicketHistoryVO> getTicketList() {
		return ticketList;
	}
	public void setTicketList(List<UserTicketHistoryVO> ticketList) {
		this.ticketList = ticketList;
	}
	public List<ReviewsVO> getRevList() {
		return revList;
	}
	public void setRevList(List<ReviewsVO> revList) {
		this.revList = revList;
	}
	public List<PokeVO> getPokeList() {
		return pokeList;
	}
	public void setPokeList(List<PokeVO> pokeList) {
		this.pokeList = pokeList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultInfo == null) ? 0 : defaultInfo.hashCode());
		result = prime * result + ((payList == null) ? 0 : payList.hashCode());
		result = prime * result + ((paymenuInfo == null) ? 0 : paymenuInfo.hashCode());
		result = prime * result + ((pokeList == null) ? 0 : pokeList.hashCode());
		result = prime * result + ((revList == null) ? 0 : revList.hashCode());
		result = prime * result + ((ticketList == null) ? 0 : ticketList.hashCode());
		result = prime * result + ((userLocation == null) ? 0 : userLocation.hashCode());
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
		AdminUserDetailVO other = (AdminUserDetailVO) obj;
		if (defaultInfo == null) {
			if (other.defaultInfo != null)
				return false;
		} else if (!defaultInfo.equals(other.defaultInfo))
			return false;
		if (payList == null) {
			if (other.payList != null)
				return false;
		} else if (!payList.equals(other.payList))
			return false;
		if (paymenuInfo == null) {
			if (other.paymenuInfo != null)
				return false;
		} else if (!paymenuInfo.equals(other.paymenuInfo))
			return false;
		if (pokeList == null) {
			if (other.pokeList != null)
				return false;
		} else if (!pokeList.equals(other.pokeList))
			return false;
		if (revList == null) {
			if (other.revList != null)
				return false;
		} else if (!revList.equals(other.revList))
			return false;
		if (ticketList == null) {
			if (other.ticketList != null)
				return false;
		} else if (!ticketList.equals(other.ticketList))
			return false;
		if (userLocation == null) {
			if (other.userLocation != null)
				return false;
		} else if (!userLocation.equals(other.userLocation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminUserDetailVO [defaultInfo=" + defaultInfo + ", userLocation=" + userLocation + ", payList="
				+ payList + ", paymenuInfo=" + paymenuInfo + ", ticketList=" + ticketList + ", revList=" + revList
				+ ", pokeList=" + pokeList + "]";
	}
}
