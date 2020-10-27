package com.baobab.m.vo;

public class MainListSearchVO {
	private int cpSeq;
	private double longitude;
	private double latitude;
	
	public MainListSearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainListSearchVO(int cpSeq, double longitude, double latitude) {
		super();
		this.cpSeq = cpSeq;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpSeq;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MainListSearchVO other = (MainListSearchVO) obj;
		if (cpSeq != other.cpSeq)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MainListSearchVO [cpSeq=" + cpSeq + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
}
