package com.baobab.m.vo;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EventCpVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @SerializedName("seqNum")
	private int seqNum;
    @SerializedName("eventName")
	private String eventName;
    @SerializedName("cpSeq")
	private int cpSeq;
    @SerializedName("salesRate")
	private int salesRate;
    @SerializedName("optionList")
	private List<EventCpOptionVO> optionList;
    @SerializedName("eventSerial")
    private String eventSerial;
    @SerializedName("eventStatus")
    private String eventStatus;
    @SerializedName("turnNum")
    private int turnNum;
	public EventCpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventCpVO(int seqNum, String eventName, int cpSeq, int salesRate, List<EventCpOptionVO> optionList,
			String eventSerial, String eventStatus, int turnNum) {
		super();
		this.seqNum = seqNum;
		this.eventName = eventName;
		this.cpSeq = cpSeq;
		this.salesRate = salesRate;
		this.optionList = optionList;
		this.eventSerial = eventSerial;
		this.eventStatus = eventStatus;
		this.turnNum = turnNum;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public int getSalesRate() {
		return salesRate;
	}
	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}
	public List<EventCpOptionVO> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<EventCpOptionVO> optionList) {
		this.optionList = optionList;
	}
	public String getEventSerial() {
		return eventSerial;
	}
	public void setEventSerial(String eventSerial) {
		this.eventSerial = eventSerial;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public int getTurnNum() {
		return turnNum;
	}
	public void setTurnNum(int turnNum) {
		this.turnNum = turnNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpSeq;
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventSerial == null) ? 0 : eventSerial.hashCode());
		result = prime * result + ((eventStatus == null) ? 0 : eventStatus.hashCode());
		result = prime * result + ((optionList == null) ? 0 : optionList.hashCode());
		result = prime * result + salesRate;
		result = prime * result + seqNum;
		result = prime * result + turnNum;
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
		EventCpVO other = (EventCpVO) obj;
		if (cpSeq != other.cpSeq)
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
		if (eventStatus == null) {
			if (other.eventStatus != null)
				return false;
		} else if (!eventStatus.equals(other.eventStatus))
			return false;
		if (optionList == null) {
			if (other.optionList != null)
				return false;
		} else if (!optionList.equals(other.optionList))
			return false;
		if (salesRate != other.salesRate)
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (turnNum != other.turnNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EventCpVO [seqNum=" + seqNum + ", eventName=" + eventName + ", cpSeq=" + cpSeq + ", salesRate="
				+ salesRate + ", optionList=" + optionList + ", eventSerial=" + eventSerial + ", eventStatus="
				+ eventStatus + ", turnNum=" + turnNum + "]";
	}
}
