package com.baobab.m.vo;

public class AdminAppVO {
	private int new_version;
	private String inspection;
	private String almightyID;
	private String almightyPW;
	
	public AdminAppVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminAppVO(int new_version, String inspection, String almightyID, String almightyPW) {
		super();
		this.new_version = new_version;
		this.inspection = inspection;
		this.almightyID = almightyID;
		this.almightyPW = almightyPW;
	}
	public int getNew_version() {
		return new_version;
	}
	public void setNew_version(int new_version) {
		this.new_version = new_version;
	}
	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	public String getAlmightyID() {
		return almightyID;
	}
	public void setAlmightyID(String almightyID) {
		this.almightyID = almightyID;
	}
	public String getAlmightyPW() {
		return almightyPW;
	}
	public void setAlmightyPW(String almightyPW) {
		this.almightyPW = almightyPW;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((almightyID == null) ? 0 : almightyID.hashCode());
		result = prime * result + ((almightyPW == null) ? 0 : almightyPW.hashCode());
		result = prime * result + ((inspection == null) ? 0 : inspection.hashCode());
		result = prime * result + new_version;
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
		AdminAppVO other = (AdminAppVO) obj;
		if (almightyID == null) {
			if (other.almightyID != null)
				return false;
		} else if (!almightyID.equals(other.almightyID))
			return false;
		if (almightyPW == null) {
			if (other.almightyPW != null)
				return false;
		} else if (!almightyPW.equals(other.almightyPW))
			return false;
		if (inspection == null) {
			if (other.inspection != null)
				return false;
		} else if (!inspection.equals(other.inspection))
			return false;
		if (new_version != other.new_version)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminAppVO [new_version=" + new_version + ", inspection=" + inspection + ", almightyID=" + almightyID
				+ ", almightyPW=" + almightyPW + "]";
	}
}
