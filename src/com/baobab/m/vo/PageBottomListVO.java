package com.baobab.m.vo;

public class PageBottomListVO {
	private int cpSeq;
	private String cpName;
	private double distance;
	private String safeDiv;
	
	public PageBottomListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBottomListVO(int cpSeq, String cpName, double distance, String safeDiv) {
		super();
		this.cpSeq = cpSeq;
		this.cpName = cpName;
		this.distance = distance;
		this.safeDiv = safeDiv;
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getSafeDiv() {
		return safeDiv;
	}
	public void setSafeDiv(String safeDiv) {
		this.safeDiv = safeDiv;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((safeDiv == null) ? 0 : safeDiv.hashCode());
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
		PageBottomListVO other = (PageBottomListVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (safeDiv == null) {
			if (other.safeDiv != null)
				return false;
		} else if (!safeDiv.equals(other.safeDiv))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageBottomListVO [cpSeq=" + cpSeq + ", cpName=" + cpName + ", distance=" + distance + ", safeDiv="
				+ safeDiv + "]";
	}
}
