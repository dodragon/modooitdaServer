package com.baobab.m.vo;

import java.util.List;

public class CPMenuActivityVO {
	private  CPInfoVO cpInfoVO;
	private List<MenuVO> menuVOList;
	private List<CPEnterMenuVO> enterMenuVOList;
	public CPMenuActivityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPMenuActivityVO(CPInfoVO cpInfoVO, List<MenuVO> menuVOList, List<CPEnterMenuVO> enterMenuVOList) {
		super();
		this.cpInfoVO = cpInfoVO;
		this.menuVOList = menuVOList;
		this.enterMenuVOList = enterMenuVOList;
	}
	public CPInfoVO getCpInfoVO() {
		return cpInfoVO;
	}
	public void setCpInfoVO(CPInfoVO cpInfoVO) {
		this.cpInfoVO = cpInfoVO;
	}
	public List<MenuVO> getMenuVOList() {
		return menuVOList;
	}
	public void setMenuVOList(List<MenuVO> menuVOList) {
		this.menuVOList = menuVOList;
	}
	public List<CPEnterMenuVO> getEnterMenuVOList() {
		return enterMenuVOList;
	}
	public void setEnterMenuVOList(List<CPEnterMenuVO> enterMenuVOList) {
		this.enterMenuVOList = enterMenuVOList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpInfoVO == null) ? 0 : cpInfoVO.hashCode());
		result = prime * result + ((enterMenuVOList == null) ? 0 : enterMenuVOList.hashCode());
		result = prime * result + ((menuVOList == null) ? 0 : menuVOList.hashCode());
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
		CPMenuActivityVO other = (CPMenuActivityVO) obj;
		if (cpInfoVO == null) {
			if (other.cpInfoVO != null)
				return false;
		} else if (!cpInfoVO.equals(other.cpInfoVO))
			return false;
		if (enterMenuVOList == null) {
			if (other.enterMenuVOList != null)
				return false;
		} else if (!enterMenuVOList.equals(other.enterMenuVOList))
			return false;
		if (menuVOList == null) {
			if (other.menuVOList != null)
				return false;
		} else if (!menuVOList.equals(other.menuVOList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPMenuActivityVO [cpInfoVO=" + cpInfoVO + ", menuVOList=" + menuVOList + ", enterMenuVOList="
				+ enterMenuVOList + "]";
	}
}
