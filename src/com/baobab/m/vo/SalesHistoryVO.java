package com.baobab.m.vo;

import java.util.Date;

public class SalesHistoryVO {
	private int seqNum;
	private int cpSeq;
	private int salesPrice;
	private String menuName;
	private String optionName;
	private String optionSerial;
	private String eventName;
	private String eventSerial;
	private String salesStatus;
	private int ea;
	private String orderNum;
	private Date curDate;
	
	public SalesHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesHistoryVO(int seqNum, int cpSeq, int salesPrice, String menuName, String optionName,
			String optionSerial, String eventName, String eventSerial, String salesStatus, int ea, String orderNum,
			Date curDate) {
		super();
		this.seqNum = seqNum;
		this.cpSeq = cpSeq;
		this.salesPrice = salesPrice;
		this.menuName = menuName;
		this.optionName = optionName;
		this.optionSerial = optionSerial;
		this.eventName = eventName;
		this.eventSerial = eventSerial;
		this.salesStatus = salesStatus;
		this.ea = ea;
		this.orderNum = orderNum;
		this.curDate = curDate;
	}
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
	public int getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionSerial() {
		return optionSerial;
	}
	public void setOptionSerial(String optionSerial) {
		this.optionSerial = optionSerial;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventSerial() {
		return eventSerial;
	}
	public void setEventSerial(String eventSerial) {
		this.eventSerial = eventSerial;
	}
	public String getSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getCurDate() {
		return curDate;
	}
	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpSeq;
		result = prime * result + ((curDate == null) ? 0 : curDate.hashCode());
		result = prime * result + ea;
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventSerial == null) ? 0 : eventSerial.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
		result = prime * result + ((optionSerial == null) ? 0 : optionSerial.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + salesPrice;
		result = prime * result + ((salesStatus == null) ? 0 : salesStatus.hashCode());
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
		SalesHistoryVO other = (SalesHistoryVO) obj;
		if (cpSeq != other.cpSeq)
			return false;
		if (curDate == null) {
			if (other.curDate != null)
				return false;
		} else if (!curDate.equals(other.curDate))
			return false;
		if (ea != other.ea)
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (eventSerial == null) {
			if (other.eventSerial != null)
				return false;
		} else if (!eventSerial.equals(other.eventSerial))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		if (optionSerial == null) {
			if (other.optionSerial != null)
				return false;
		} else if (!optionSerial.equals(other.optionSerial))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (salesPrice != other.salesPrice)
			return false;
		if (salesStatus == null) {
			if (other.salesStatus != null)
				return false;
		} else if (!salesStatus.equals(other.salesStatus))
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SalesHistoryVO [seqNum=" + seqNum + ", cpSeq=" + cpSeq + ", salesPrice=" + salesPrice + ", menuName="
				+ menuName + ", optionName=" + optionName + ", optionSerial=" + optionSerial + ", eventName="
				+ eventName + ", eventSerial=" + eventSerial + ", salesStatus=" + salesStatus + ", ea=" + ea
				+ ", orderNum=" + orderNum + ", curDate=" + curDate + "]";
	}
}
