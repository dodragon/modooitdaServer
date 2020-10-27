package com.baobab.m.vo;

import java.util.Date;

public class StatChartDataVO {
	private Date dt;
	private int value;
	//
	private String date;
	private int cpSeq;
	public StatChartDataVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatChartDataVO(Date dt, int value, String date, int cpSeq) {
		super();
		this.dt = dt;
		this.value = value;
		this.date = date;
		this.cpSeq = cpSeq;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpSeq;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
		result = prime * result + value;
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
		StatChartDataVO other = (StatChartDataVO) obj;
		if (cpSeq != other.cpSeq)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dt == null) {
			if (other.dt != null)
				return false;
		} else if (!dt.equals(other.dt))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatChartDataVO [dt=" + dt + ", value=" + value + ", date=" + date + ", cpSeq=" + cpSeq + "]";
	}
}
