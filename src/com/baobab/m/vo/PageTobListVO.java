package com.baobab.m.vo;

public class PageTobListVO {
	private CPInfoVO infoVO;
	private EventCpMenuVO menuVO;
	
	public PageTobListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageTobListVO(CPInfoVO infoVO, EventCpMenuVO menuVO) {
		super();
		this.infoVO = infoVO;
		this.menuVO = menuVO;
	}
	public CPInfoVO getInfoVO() {
		return infoVO;
	}
	public void setInfoVO(CPInfoVO infoVO) {
		this.infoVO = infoVO;
	}
	public EventCpMenuVO getMenuVO() {
		return menuVO;
	}
	public void setMenuVO(EventCpMenuVO menuVO) {
		this.menuVO = menuVO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infoVO == null) ? 0 : infoVO.hashCode());
		result = prime * result + ((menuVO == null) ? 0 : menuVO.hashCode());
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
		PageTobListVO other = (PageTobListVO) obj;
		if (infoVO == null) {
			if (other.infoVO != null)
				return false;
		} else if (!infoVO.equals(other.infoVO))
			return false;
		if (menuVO == null) {
			if (other.menuVO != null)
				return false;
		} else if (!menuVO.equals(other.menuVO))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageTobListVO [infoVO=" + infoVO + ", menuVO=" + menuVO + "]";
	}
}
