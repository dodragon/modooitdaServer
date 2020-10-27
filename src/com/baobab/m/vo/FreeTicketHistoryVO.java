package com.baobab.m.vo;

import java.util.Date;

public class FreeTicketHistoryVO {
	private int seqNum;
	private String email;
	private int price;
	private int disprice;
	private String cpName;
	private int cpSeq;
	private Date payDate;
	
	public FreeTicketHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FreeTicketHistoryVO(int seqNum, String email, int price, int disprice, String cpName, int cpSeq,
			Date payDate) {
		super();
		this.seqNum = seqNum;
		this.email = email;
		this.price = price;
		this.disprice = disprice;
		this.cpName = cpName;
		this.cpSeq = cpSeq;
		this.payDate = payDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDisprice() {
		return disprice;
	}
	public void setDisprice(int disprice) {
		this.disprice = disprice;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + disprice;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + price;
		result = prime * result + seqNum;
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
		FreeTicketHistoryVO other = (FreeTicketHistoryVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (disprice != other.disprice)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (price != other.price)
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FreeTicketHistoryVO [seqNum=" + seqNum + ", email=" + email + ", price=" + price + ", disprice="
				+ disprice + ", cpName=" + cpName + ", cpSeq=" + cpSeq + ", payDate=" + payDate + "]";
	}
}
