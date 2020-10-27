package com.baobab.m.vo;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EventCpOptionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @SerializedName("seqNum")
	private int seqNum;
    @SerializedName("optionName")
	private String optionName;
    @SerializedName("eventSeq")
	private int eventSeq;
    @SerializedName("salesRate")
	private int salesRate;
    @SerializedName("menuList")
	private List<EventCpMenuVO> menuList;
    @SerializedName("eventSerial")
    private String eventSerial;
    @SerializedName("optionSerial")
    private String optionSerial;
	public EventCpOptionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventCpOptionVO(int seqNum, String optionName, int eventSeq, int salesRate, List<EventCpMenuVO> menuList,
			String eventSerial, String optionSerial) {
		super();
		this.seqNum = seqNum;
		this.optionName = optionName;
		this.eventSeq = eventSeq;
		this.salesRate = salesRate;
		this.menuList = menuList;
		this.eventSerial = eventSerial;
		this.optionSerial = optionSerial;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getEventSeq() {
		return eventSeq;
	}
	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}
	public int getSalesRate() {
		return salesRate;
	}
	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}
	public List<EventCpMenuVO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<EventCpMenuVO> menuList) {
		this.menuList = menuList;
	}
	public String getEventSerial() {
		return eventSerial;
	}
	public void setEventSerial(String eventSerial) {
		this.eventSerial = eventSerial;
	}
	public String getOptionSerial() {
		return optionSerial;
	}
	public void setOptionSerial(String optionSerial) {
		this.optionSerial = optionSerial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventSeq;
		result = prime * result + ((eventSerial == null) ? 0 : eventSerial.hashCode());
		result = prime * result + ((menuList == null) ? 0 : menuList.hashCode());
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
		result = prime * result + ((optionSerial == null) ? 0 : optionSerial.hashCode());
		result = prime * result + salesRate;
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
		EventCpOptionVO other = (EventCpOptionVO) obj;
		if (eventSeq != other.eventSeq)
			return false;
		if (eventSerial == null) {
			if (other.eventSerial != null)
				return false;
		} else if (!eventSerial.equals(other.eventSerial))
			return false;
		if (menuList == null) {
			if (other.menuList != null)
				return false;
		} else if (!menuList.equals(other.menuList))
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
		if (salesRate != other.salesRate)
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EventCpOptionVO [seqNum=" + seqNum + ", optionName=" + optionName + ", eventSeq=" + eventSeq
				+ ", salesRate=" + salesRate + ", menuList=" + menuList + ", eventSerial=" + eventSerial
				+ ", optionSerial=" + optionSerial + "]";
	}
}
