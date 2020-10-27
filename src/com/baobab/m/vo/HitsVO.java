package com.baobab.m.vo;

import java.util.Date;

public class HitsVO {
	private int seqNum;
	private String userInfo;
	private String cpName;
	private int cpSeq;
	private Date hitDate;
	private String hitDiv;
	
	public HitsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HitsVO(int seqNum, String userInfo, String cpName, int cpSeq, Date hitDate, String hitDiv) {
		super();
		this.seqNum = seqNum;
		this.userInfo = userInfo;
		this.cpName = cpName;
		this.cpSeq = cpSeq;
		this.hitDate = hitDate;
		this.hitDiv = hitDiv;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
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
	public Date getHitDate() {
		return hitDate;
	}
	public void setHitDate(Date hitDate) {
		this.hitDate = hitDate;
	}
	public String getHitDiv() {
		return hitDiv;
	}
	public void setHitDiv(String hitDiv) {
		this.hitDiv = hitDiv;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((hitDate == null) ? 0 : hitDate.hashCode());
		result = prime * result + ((hitDiv == null) ? 0 : hitDiv.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((userInfo == null) ? 0 : userInfo.hashCode());
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
		HitsVO other = (HitsVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (hitDate == null) {
			if (other.hitDate != null)
				return false;
		} else if (!hitDate.equals(other.hitDate))
			return false;
		if (hitDiv == null) {
			if (other.hitDiv != null)
				return false;
		} else if (!hitDiv.equals(other.hitDiv))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HitsVO [seqNum=" + seqNum + ", userInfo=" + userInfo + ", cpName=" + cpName + ", cpSeq=" + cpSeq
				+ ", hitDate=" + hitDate + ", hitDiv=" + hitDiv + "]";
	}
}
