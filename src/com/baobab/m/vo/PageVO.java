package com.baobab.m.vo;

import java.util.List;

public class PageVO {
	private int loclog;
	private List<PageTobListVO> tobList;
	private List<PageBottomListVO> botList;
	public PageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageVO(int loclog, List<PageTobListVO> tobList, List<PageBottomListVO> botList) {
		super();
		this.loclog = loclog;
		this.tobList = tobList;
		this.botList = botList;
	}
	public int getLoclog() {
		return loclog;
	}
	public void setLoclog(int loclog) {
		this.loclog = loclog;
	}
	public List<PageTobListVO> getTobList() {
		return tobList;
	}
	public void setTobList(List<PageTobListVO> tobList) {
		this.tobList = tobList;
	}
	public List<PageBottomListVO> getBotList() {
		return botList;
	}
	public void setBotList(List<PageBottomListVO> botList) {
		this.botList = botList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((botList == null) ? 0 : botList.hashCode());
		result = prime * result + loclog;
		result = prime * result + ((tobList == null) ? 0 : tobList.hashCode());
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
		PageVO other = (PageVO) obj;
		if (botList == null) {
			if (other.botList != null)
				return false;
		} else if (!botList.equals(other.botList))
			return false;
		if (loclog != other.loclog)
			return false;
		if (tobList == null) {
			if (other.tobList != null)
				return false;
		} else if (!tobList.equals(other.tobList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageVO [loclog=" + loclog + ", tobList=" + tobList + ", botList=" + botList + "]";
	}
}
