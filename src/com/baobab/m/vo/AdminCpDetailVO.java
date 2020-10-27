package com.baobab.m.vo;

import java.util.List;

public class AdminCpDetailVO {
	private CPInfoVO defaultVo;
	private List<CpStaffVO> staffs;
	private int hits;
	private List<CPmainImgVO> imgs;
	private List<EventCpVO> events;
	private List<MenuVO> menus;
	private List<SalesHistoryVO> sales;
	private List<ReviewsVO> revs;
	
	public AdminCpDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminCpDetailVO(CPInfoVO defaultVo, List<CpStaffVO> staffs, int hits, List<CPmainImgVO> imgs,
			List<EventCpVO> events, List<MenuVO> menus, List<SalesHistoryVO> sales, List<ReviewsVO> revs) {
		super();
		this.defaultVo = defaultVo;
		this.staffs = staffs;
		this.hits = hits;
		this.imgs = imgs;
		this.events = events;
		this.menus = menus;
		this.sales = sales;
		this.revs = revs;
	}
	public CPInfoVO getDefaultVo() {
		return defaultVo;
	}
	public void setDefaultVo(CPInfoVO defaultVo) {
		this.defaultVo = defaultVo;
	}
	public List<CpStaffVO> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<CpStaffVO> staffs) {
		this.staffs = staffs;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public List<CPmainImgVO> getImgs() {
		return imgs;
	}
	public void setImgs(List<CPmainImgVO> imgs) {
		this.imgs = imgs;
	}
	public List<EventCpVO> getEvents() {
		return events;
	}
	public void setEvents(List<EventCpVO> events) {
		this.events = events;
	}
	public List<MenuVO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}
	public List<SalesHistoryVO> getSales() {
		return sales;
	}
	public void setSales(List<SalesHistoryVO> sales) {
		this.sales = sales;
	}
	public List<ReviewsVO> getRevs() {
		return revs;
	}
	public void setRevs(List<ReviewsVO> revs) {
		this.revs = revs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultVo == null) ? 0 : defaultVo.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + hits;
		result = prime * result + ((imgs == null) ? 0 : imgs.hashCode());
		result = prime * result + ((menus == null) ? 0 : menus.hashCode());
		result = prime * result + ((revs == null) ? 0 : revs.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((staffs == null) ? 0 : staffs.hashCode());
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
		AdminCpDetailVO other = (AdminCpDetailVO) obj;
		if (defaultVo == null) {
			if (other.defaultVo != null)
				return false;
		} else if (!defaultVo.equals(other.defaultVo))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (hits != other.hits)
			return false;
		if (imgs == null) {
			if (other.imgs != null)
				return false;
		} else if (!imgs.equals(other.imgs))
			return false;
		if (menus == null) {
			if (other.menus != null)
				return false;
		} else if (!menus.equals(other.menus))
			return false;
		if (revs == null) {
			if (other.revs != null)
				return false;
		} else if (!revs.equals(other.revs))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (staffs == null) {
			if (other.staffs != null)
				return false;
		} else if (!staffs.equals(other.staffs))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminCpDetailVO [defaultVo=" + defaultVo + ", staffs=" + staffs + ", hits=" + hits + ", imgs=" + imgs
				+ ", events=" + events + ", menus=" + menus + ", sales=" + sales + ", revs=" + revs + "]";
	}
}
