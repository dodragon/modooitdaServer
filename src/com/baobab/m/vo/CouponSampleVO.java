package com.baobab.m.vo;

public class CouponSampleVO {

	private String couponEx;

	public String getCouponEx() {
		return couponEx;
	}

	public void setCouponEx(String couponEx) {
		this.couponEx = couponEx;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couponEx == null) ? 0 : couponEx.hashCode());
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
		CouponSampleVO other = (CouponSampleVO) obj;
		if (couponEx == null) {
			if (other.couponEx != null)
				return false;
		} else if (!couponEx.equals(other.couponEx))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CouponExampleVO [couponEx=" + couponEx + "]";
	}

	public CouponSampleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
