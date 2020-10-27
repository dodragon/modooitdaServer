package com.baobab.m.vo;

public class PayCancelVO {
	private String resultCode;
	private String resultMsg;
	private String cancelDate;
	private String cancelTime;
	
	public PayCancelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayCancelVO(String resultCode, String resultMsg, String cancelDate, String cancelTime) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.cancelDate = cancelDate;
		this.cancelTime = cancelTime;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancelDate == null) ? 0 : cancelDate.hashCode());
		result = prime * result + ((cancelTime == null) ? 0 : cancelTime.hashCode());
		result = prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
		result = prime * result + ((resultMsg == null) ? 0 : resultMsg.hashCode());
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
		PayCancelVO other = (PayCancelVO) obj;
		if (cancelDate == null) {
			if (other.cancelDate != null)
				return false;
		} else if (!cancelDate.equals(other.cancelDate))
			return false;
		if (cancelTime == null) {
			if (other.cancelTime != null)
				return false;
		} else if (!cancelTime.equals(other.cancelTime))
			return false;
		if (resultCode == null) {
			if (other.resultCode != null)
				return false;
		} else if (!resultCode.equals(other.resultCode))
			return false;
		if (resultMsg == null) {
			if (other.resultMsg != null)
				return false;
		} else if (!resultMsg.equals(other.resultMsg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PayCancelVO [resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", cancelDate=" + cancelDate
				+ ", cancelTime=" + cancelTime + "]";
	}
}
