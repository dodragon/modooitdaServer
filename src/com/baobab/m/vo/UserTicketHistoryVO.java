package com.baobab.m.vo;

import java.util.Date;

public class UserTicketHistoryVO {
	private int seqNum;
	private String ticketTitle;
	private String email;
	private int cpSeq;
	private String orderNum;
	private String ticketSerial;
	private int amount;
	private Date curDate;
	private String ticketStatus;
	private String cpName;
	public UserTicketHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTicketHistoryVO(int seqNum, String ticketTitle, String email, int cpSeq, String orderNum,
			String ticketSerial, int amount, Date curDate, String ticketStatus, String cpName) {
		super();
		this.seqNum = seqNum;
		this.ticketTitle = ticketTitle;
		this.email = email;
		this.cpSeq = cpSeq;
		this.orderNum = orderNum;
		this.ticketSerial = ticketSerial;
		this.amount = amount;
		this.curDate = curDate;
		this.ticketStatus = ticketStatus;
		this.cpName = cpName;
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
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCurDate() {
		return curDate;
	}
	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((curDate == null) ? 0 : curDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((ticketSerial == null) ? 0 : ticketSerial.hashCode());
		result = prime * result + ((ticketStatus == null) ? 0 : ticketStatus.hashCode());
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
		UserTicketHistoryVO other = (UserTicketHistoryVO) obj;
		if (amount != other.amount)
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (curDate == null) {
			if (other.curDate != null)
				return false;
		} else if (!curDate.equals(other.curDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (ticketSerial == null) {
			if (other.ticketSerial != null)
				return false;
		} else if (!ticketSerial.equals(other.ticketSerial))
			return false;
		if (ticketStatus == null) {
			if (other.ticketStatus != null)
				return false;
		} else if (!ticketStatus.equals(other.ticketStatus))
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
		return "UserTicketHistoryVO [seqNum=" + seqNum + ", ticketTitle=" + ticketTitle + ", email=" + email
				+ ", cpSeq=" + cpSeq + ", orderNum=" + orderNum + ", ticketSerial=" + ticketSerial + ", amount="
				+ amount + ", curDate=" + curDate + ", ticketStatus=" + ticketStatus + ", cpName=" + cpName + "]";
	}
}
