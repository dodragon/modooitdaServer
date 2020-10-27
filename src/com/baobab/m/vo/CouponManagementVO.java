package com.baobab.m.vo;

import java.util.List;

public class CouponManagementVO {
	private List<CouponListVO> couponListVOList;
	private List<CouponCpVO> couponCpVOList;
	private List<CouponSampleVO> couponSampleVOList;
	public CouponManagementVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponManagementVO(List<CouponListVO> couponListVOList, List<CouponCpVO> couponCpVOList,
			List<CouponSampleVO> couponSampleVOList) {
		super();
		this.couponListVOList = couponListVOList;
		this.couponCpVOList = couponCpVOList;
		this.couponSampleVOList = couponSampleVOList;
	}
	public List<CouponListVO> getCouponListVOList() {
		return couponListVOList;
	}
	public void setCouponListVOList(List<CouponListVO> couponListVOList) {
		this.couponListVOList = couponListVOList;
	}
	public List<CouponCpVO> getCouponCpVOList() {
		return couponCpVOList;
	}
	public void setCouponCpVOList(List<CouponCpVO> couponCpVOList) {
		this.couponCpVOList = couponCpVOList;
	}
	public List<CouponSampleVO> getCouponSampleVOList() {
		return couponSampleVOList;
	}
	public void setCouponSampleVOList(List<CouponSampleVO> couponSampleVOList) {
		this.couponSampleVOList = couponSampleVOList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couponCpVOList == null) ? 0 : couponCpVOList.hashCode());
		result = prime * result + ((couponListVOList == null) ? 0 : couponListVOList.hashCode());
		result = prime * result + ((couponSampleVOList == null) ? 0 : couponSampleVOList.hashCode());
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
		CouponManagementVO other = (CouponManagementVO) obj;
		if (couponCpVOList == null) {
			if (other.couponCpVOList != null)
				return false;
		} else if (!couponCpVOList.equals(other.couponCpVOList))
			return false;
		if (couponListVOList == null) {
			if (other.couponListVOList != null)
				return false;
		} else if (!couponListVOList.equals(other.couponListVOList))
			return false;
		if (couponSampleVOList == null) {
			if (other.couponSampleVOList != null)
				return false;
		} else if (!couponSampleVOList.equals(other.couponSampleVOList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CouponManagementVO [couponListVOList=" + couponListVOList + ", couponCpVOList=" + couponCpVOList
				+ ", couponSampleVOList=" + couponSampleVOList + "]";
	}
}
