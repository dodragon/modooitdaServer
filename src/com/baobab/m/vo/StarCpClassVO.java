package com.baobab.m.vo;

import java.util.List;

public class StarCpClassVO {
	private List<CPInfoVO> CPInfoVO;
	private List<CouponCpVO> CouponCpVO;
	private List<StarCpVO> mainImg;
	
	public StarCpClassVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<CPInfoVO> getCPInfoVO() {
		return CPInfoVO;
	}
	public void setCPInfoVO(List<CPInfoVO> cPInfoVO) {
		CPInfoVO = cPInfoVO;
	}
	public List<CouponCpVO> getCouponCpVO() {
		return CouponCpVO;
	}
	public void setCouponCpVO(List<CouponCpVO> couponCpVO) {
		CouponCpVO = couponCpVO;
	}
	
	public List<StarCpVO> getMainImg() {
		return mainImg;
	}
	public void setMainImg(List<StarCpVO> mainImg) {
		this.mainImg = mainImg;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPInfoVO == null) ? 0 : CPInfoVO.hashCode());
		result = prime * result + ((CouponCpVO == null) ? 0 : CouponCpVO.hashCode());
		result = prime * result + ((mainImg == null) ? 0 : mainImg.hashCode());
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
		StarCpClassVO other = (StarCpClassVO) obj;
		if (CPInfoVO == null) {
			if (other.CPInfoVO != null)
				return false;
		} else if (!CPInfoVO.equals(other.CPInfoVO))
			return false;
		if (CouponCpVO == null) {
			if (other.CouponCpVO != null)
				return false;
		} else if (!CouponCpVO.equals(other.CouponCpVO))
			return false;
		if (mainImg == null) {
			if (other.mainImg != null)
				return false;
		} else if (!mainImg.equals(other.mainImg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StarCpClassVO [CPInfoVO=" + CPInfoVO + ", CouponCpVO=" + CouponCpVO + ", mainImg=" + mainImg + "]";
	}
	
}
