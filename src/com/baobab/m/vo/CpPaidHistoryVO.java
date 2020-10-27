package com.baobab.m.vo;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CpPaidHistoryVO implements Serializable {
    private static final long serialVersionUID = 1L;
	
    @SerializedName("payMenusVOS")
    List<PayMenusVO> payMenusVOS;
    @SerializedName("ticketSerial")
    String ticketSerial;
	public CpPaidHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpPaidHistoryVO(List<PayMenusVO> payMenusVOS, String ticketSerial) {
		super();
		this.payMenusVOS = payMenusVOS;
		this.ticketSerial = ticketSerial;
	}
	public List<PayMenusVO> getPayMenusVOS() {
		return payMenusVOS;
	}
	public void setPayMenusVOS(List<PayMenusVO> payMenusVOS) {
		this.payMenusVOS = payMenusVOS;
	}
	public String getTicketSerial() {
		return ticketSerial;
	}
	public void setTicketSerial(String ticketSerial) {
		this.ticketSerial = ticketSerial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payMenusVOS == null) ? 0 : payMenusVOS.hashCode());
		result = prime * result + ((ticketSerial == null) ? 0 : ticketSerial.hashCode());
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
		CpPaidHistoryVO other = (CpPaidHistoryVO) obj;
		if (payMenusVOS == null) {
			if (other.payMenusVOS != null)
				return false;
		} else if (!payMenusVOS.equals(other.payMenusVOS))
			return false;
		if (ticketSerial == null) {
			if (other.ticketSerial != null)
				return false;
		} else if (!ticketSerial.equals(other.ticketSerial))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CpPaidHistoryVO [payMenusVOS=" + payMenusVOS + ", ticketSerial=" + ticketSerial + "]";
	}
    
    
}
