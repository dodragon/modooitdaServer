package com.baobab.m.vo;

import java.util.Date;

public class UserTicketVO {
	private int seqNum;
	private String ticketTitle;
	private String email;
	private String orderNum;
	private String ticketSerial;
	private int cpSeq;
	private String cpName;
	private int amount;
	private Date payDate;
	private Date periodDate;
	private String imgUrl;
	
	public UserTicketVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTicketVO(int seqNum, String ticketTitle, String email, String orderNum, String ticketSerial, int cpSeq,
			String cpName, int amount, Date payDate, Date periodDate, String imgUrl) {
		super();
		this.seqNum = seqNum;
		this.ticketTitle = ticketTitle;
		this.email = email;
		this.orderNum = orderNum;
		this.ticketSerial = ticketSerial;
		this.cpSeq = cpSeq;
		this.cpName = cpName;
		this.amount = amount;
		this.payDate = payDate;
		this.periodDate = periodDate;
		this.imgUrl = imgUrl;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getTicketSerial() {
		return ticketSerial;
	}
	public void setTicketSerial(String ticketSerial) {
		this.ticketSerial = ticketSerial;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getPeriodDate() {
		return periodDate;
	}
	public void setPeriodDate(Date periodDate) {
		this.periodDate = periodDate;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((periodDate == null) ? 0 : periodDate.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((ticketSerial == null) ? 0 : ticketSerial.hashCode());
		result = prime * result + ((ticketTitle == null) ? 0 : ticketTitle.hashCode());
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
		UserTicketVO other = (UserTicketVO) obj;
		if (amount != other.amount)
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (periodDate == null) {
			if (other.periodDate != null)
				return false;
		} else if (!periodDate.equals(other.periodDate))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (ticketSerial == null) {
			if (other.ticketSerial != null)
				return false;
		} else if (!ticketSerial.equals(other.ticketSerial))
			return false;
		if (ticketTitle == null) {
			if (other.ticketTitle != null)
				return false;
		} else if (!ticketTitle.equals(other.ticketTitle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserTicketVO [seqNum=" + seqNum + ", ticketTitle=" + ticketTitle + ", email=" + email + ", orderNum="
				+ orderNum + ", ticketSerial=" + ticketSerial + ", cpSeq=" + cpSeq + ", cpName=" + cpName + ", amount="
				+ amount + ", payDate=" + payDate + ", periodDate=" + periodDate + ", imgUrl=" + imgUrl + "]";
	}
}
