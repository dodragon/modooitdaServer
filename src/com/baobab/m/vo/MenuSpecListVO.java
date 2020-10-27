package com.baobab.m.vo;

public class MenuSpecListVO {
	String menuName;
	int paidEa = 0;
	int scanEa = 0;
	int cancelEa = 0;
	int allPaid = 0;
	
	public MenuSpecListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuSpecListVO(String menuName, int paidEa, int scanEa, int cancelEa, int allPaid) {
		super();
		this.menuName = menuName;
		this.paidEa = paidEa;
		this.scanEa = scanEa;
		this.cancelEa = cancelEa;
		this.allPaid = allPaid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPaidEa() {
		return paidEa;
	}
	public void setPaidEa(int paidEa) {
		this.paidEa = paidEa;
	}
	public int getScanEa() {
		return scanEa;
	}
	public void setScanEa(int scanEa) {
		this.scanEa = scanEa;
	}
	public int getCancelEa() {
		return cancelEa;
	}
	public void setCancelEa(int cancelEa) {
		this.cancelEa = cancelEa;
	}
	public int getAllPaid() {
		return allPaid;
	}
	public void setAllPaid(int allPaid) {
		this.allPaid = allPaid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allPaid;
		result = prime * result + cancelEa;
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + paidEa;
		result = prime * result + scanEa;
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
		MenuSpecListVO other = (MenuSpecListVO) obj;
		if (allPaid != other.allPaid)
			return false;
		if (cancelEa != other.cancelEa)
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (paidEa != other.paidEa)
			return false;
		if (scanEa != other.scanEa)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MenuSpecListVO [menuName=" + menuName + ", paidEa=" + paidEa + ", scanEa=" + scanEa + ", cancelEa="
				+ cancelEa + ", allPaid=" + allPaid + "]";
	}
}
