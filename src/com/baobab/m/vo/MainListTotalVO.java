package com.baobab.m.vo;

public class MainListTotalVO {
	private MainCpListVO mainListVO;
	private CPInfoVO cpInfoVO;
	private EventCpMenuVO menuVO;
	private int totalSales;
	
	public MainListTotalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainListTotalVO(MainCpListVO mainListVO, CPInfoVO cpInfoVO, EventCpMenuVO menuVO, int totalSales) {
		super();
		this.mainListVO = mainListVO;
		this.cpInfoVO = cpInfoVO;
		this.menuVO = menuVO;
		this.totalSales = totalSales;
	}
	public MainCpListVO getMainListVO() {
		return mainListVO;
	}
	public void setMainListVO(MainCpListVO mainListVO) {
		this.mainListVO = mainListVO;
	}
	public CPInfoVO getCpInfoVO() {
		return cpInfoVO;
	}
	public void setCpInfoVO(CPInfoVO cpInfoVO) {
		this.cpInfoVO = cpInfoVO;
	}
	public EventCpMenuVO getMenuVO() {
		return menuVO;
	}
	public void setMenuVO(EventCpMenuVO menuVO) {
		this.menuVO = menuVO;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpInfoVO == null) ? 0 : cpInfoVO.hashCode());
		result = prime * result + ((mainListVO == null) ? 0 : mainListVO.hashCode());
		result = prime * result + ((menuVO == null) ? 0 : menuVO.hashCode());
		result = prime * result + totalSales;
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
		MainListTotalVO other = (MainListTotalVO) obj;
		if (cpInfoVO == null) {
			if (other.cpInfoVO != null)
				return false;
		} else if (!cpInfoVO.equals(other.cpInfoVO))
			return false;
		if (mainListVO == null) {
			if (other.mainListVO != null)
				return false;
		} else if (!mainListVO.equals(other.mainListVO))
			return false;
		if (menuVO == null) {
			if (other.menuVO != null)
				return false;
		} else if (!menuVO.equals(other.menuVO))
			return false;
		if (totalSales != other.totalSales)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MainListTotalVO [mainListVO=" + mainListVO + ", cpInfoVO=" + cpInfoVO + ", menuVO=" + menuVO
				+ ", totalSales=" + totalSales + "]";
	}
}
