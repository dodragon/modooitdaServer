package com.baobab.m.vo;

import java.util.Date;

public class VisitUserVO {
	private int seqNum;
	private String user;
	private Date visitDate;
	private String os;
	public VisitUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitUserVO(int seqNum, String user, Date visitDate, String os) {
		super();
		this.seqNum = seqNum;
		this.user = user;
		this.visitDate = visitDate;
		this.os = os;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
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
		VisitUserVO other = (VisitUserVO) obj;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;
		} else if (!visitDate.equals(other.visitDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VisitUserVO [seqNum=" + seqNum + ", user=" + user + ", visitDate=" + visitDate + ", os=" + os + "]";
	}
}
