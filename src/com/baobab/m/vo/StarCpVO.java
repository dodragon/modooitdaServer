package com.baobab.m.vo;

import java.util.Date;

public class StarCpVO {

	private int seqNum;
	private int cpSeq;
	private String cpName;
	private String mainSerial;
	private String mainImg;
	private Date starDate;
	
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
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
	public String getMainSerial() {
		return mainSerial;
	}
	public void setMainSerial(String mainSerial) {
		this.mainSerial = mainSerial;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	
	public Date getStarDate() {
		return starDate;
	}
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((mainImg == null) ? 0 : mainImg.hashCode());
		result = prime * result + ((mainSerial == null) ? 0 : mainSerial.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((starDate == null) ? 0 : starDate.hashCode());
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
		StarCpVO other = (StarCpVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (mainImg == null) {
			if (other.mainImg != null)
				return false;
		} else if (!mainImg.equals(other.mainImg))
			return false;
		if (mainSerial == null) {
			if (other.mainSerial != null)
				return false;
		} else if (!mainSerial.equals(other.mainSerial))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (starDate == null) {
			if (other.starDate != null)
				return false;
		} else if (!starDate.equals(other.starDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "StarCpVO [seqNum=" + seqNum + ", cpSeq=" + cpSeq + ", cpName=" + cpName + ", mainSerial=" + mainSerial
				+ ", mainImg=" + mainImg + ", starDate=" + starDate + "]";
	}
	
	public StarCpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
