package com.baobab.m.vo;

public class CouponTypeVO {

	private String couSpecial;

	public CouponTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CouponTypeVO [couSpecial=" + couSpecial + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couSpecial == null) ? 0 : couSpecial.hashCode());
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
		CouponTypeVO other = (CouponTypeVO) obj;
		if (couSpecial == null) {
			if (other.couSpecial != null)
				return false;
		} else if (!couSpecial.equals(other.couSpecial))
			return false;
		return true;
	}

	public String getCouSpecial() {
		return couSpecial;
	}

	public void setCouSpecial(String couSpecial) {
		this.couSpecial = couSpecial;
	}
	
}
