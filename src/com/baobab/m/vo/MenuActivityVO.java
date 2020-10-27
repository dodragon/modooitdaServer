package com.baobab.m.vo;

import java.util.List;

public class MenuActivityVO {
	private List<MenuVO> menuVOList;
	private List<CPmainImgVO> cPmainImgVOList;
	private List<CPInfoVO> recommendCPVO;
	private List<EventCpVO> eventCpVOList;
	private List<ReviewsSelectVO> reviewsListVO;
	public MenuActivityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuActivityVO(List<MenuVO> menuVOList, List<CPmainImgVO> cPmainImgVOList, List<CPInfoVO> recommendCPVO,
			List<EventCpVO> eventCpVOList, List<ReviewsSelectVO> reviewsListVO) {
		super();
		this.menuVOList = menuVOList;
		this.cPmainImgVOList = cPmainImgVOList;
		this.recommendCPVO = recommendCPVO;
		this.eventCpVOList = eventCpVOList;
		this.reviewsListVO = reviewsListVO;
	}
	public List<MenuVO> getMenuVOList() {
		return menuVOList;
	}
	public void setMenuVOList(List<MenuVO> menuVOList) {
		this.menuVOList = menuVOList;
	}
	public List<CPmainImgVO> getcPmainImgVOList() {
		return cPmainImgVOList;
	}
	public void setcPmainImgVOList(List<CPmainImgVO> cPmainImgVOList) {
		this.cPmainImgVOList = cPmainImgVOList;
	}
	public List<CPInfoVO> getRecommendCPVO() {
		return recommendCPVO;
	}
	public void setRecommendCPVO(List<CPInfoVO> recommendCPVO) {
		this.recommendCPVO = recommendCPVO;
	}
	public List<EventCpVO> getEventCpVOList() {
		return eventCpVOList;
	}
	public void setEventCpVOList(List<EventCpVO> eventCpVOList) {
		this.eventCpVOList = eventCpVOList;
	}
	public List<ReviewsSelectVO> getReviewsListVO() {
		return reviewsListVO;
	}
	public void setReviewsListVO(List<ReviewsSelectVO> reviewsListVO) {
		this.reviewsListVO = reviewsListVO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cPmainImgVOList == null) ? 0 : cPmainImgVOList.hashCode());
		result = prime * result + ((eventCpVOList == null) ? 0 : eventCpVOList.hashCode());
		result = prime * result + ((menuVOList == null) ? 0 : menuVOList.hashCode());
		result = prime * result + ((recommendCPVO == null) ? 0 : recommendCPVO.hashCode());
		result = prime * result + ((reviewsListVO == null) ? 0 : reviewsListVO.hashCode());
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
		MenuActivityVO other = (MenuActivityVO) obj;
		if (cPmainImgVOList == null) {
			if (other.cPmainImgVOList != null)
				return false;
		} else if (!cPmainImgVOList.equals(other.cPmainImgVOList))
			return false;
		if (eventCpVOList == null) {
			if (other.eventCpVOList != null)
				return false;
		} else if (!eventCpVOList.equals(other.eventCpVOList))
			return false;
		if (menuVOList == null) {
			if (other.menuVOList != null)
				return false;
		} else if (!menuVOList.equals(other.menuVOList))
			return false;
		if (recommendCPVO == null) {
			if (other.recommendCPVO != null)
				return false;
		} else if (!recommendCPVO.equals(other.recommendCPVO))
			return false;
		if (reviewsListVO == null) {
			if (other.reviewsListVO != null)
				return false;
		} else if (!reviewsListVO.equals(other.reviewsListVO))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MenuActivityVO [menuVOList=" + menuVOList + ", cPmainImgVOList=" + cPmainImgVOList + ", recommendCPVO="
				+ recommendCPVO + ", eventCpVOList=" + eventCpVOList + ", reviewsListVO=" + reviewsListVO + "]";
	}
}
