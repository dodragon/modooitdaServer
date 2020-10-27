package com.baobab.m.vo;

import java.util.Date;

public class PaypleInfoVO {
	private int seqNum;
	private String email;
	private String payerId;
	private Date regDate;
	public PaypleInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaypleInfoVO(int seqNum, String email, String payerId, Date regDate) {
		super();
		this.seqNum = seqNum;
		this.email = email;
		this.payerId = payerId;
		this.regDate = regDate;
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
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((payerId == null) ? 0 : payerId.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
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
		PaypleInfoVO other = (PaypleInfoVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (payerId == null) {
			if (other.payerId != null)
				return false;
		} else if (!payerId.equals(other.payerId))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaypleInfoVO [seqNum=" + seqNum + ", email=" + email + ", payerId=" + payerId + ", regDate=" + regDate
				+ "]";
	}
}
