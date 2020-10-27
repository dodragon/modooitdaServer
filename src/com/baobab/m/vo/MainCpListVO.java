package com.baobab.m.vo;

import java.util.Date;

public class MainCpListVO {
	private int seqNum;
	private int cpSeq;
	private String cpName;
	private int menuSeq;
	private String imgUrl;
	private String listDiv;
	private Date selectDate;
	
	private String menuName;

	public MainCpListVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainCpListVO(int seqNum, int cpSeq, String cpName, int menuSeq, String imgUrl, String listDiv,
			Date selectDate, String menuName) {
		super();
		this.seqNum = seqNum;
		this.cpSeq = cpSeq;
		this.cpName = cpName;
		this.menuSeq = menuSeq;
		this.imgUrl = imgUrl;
		this.listDiv = listDiv;
		this.selectDate = selectDate;
		this.menuName = menuName;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public int getCpSeq() {
		return cpSeq;
	}

	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getListDiv() {
		return listDiv;
	}

	public void setListDiv(String listDiv) {
		this.listDiv = listDiv;
	}

	public Date getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((listDiv == null) ? 0 : listDiv.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + menuSeq;
		result = prime * result + ((selectDate == null) ? 0 : selectDate.hashCode());
		result = prime * result + seqNum;
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
		MainCpListVO other = (MainCpListVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (listDiv == null) {
			if (other.listDiv != null)
				return false;
		} else if (!listDiv.equals(other.listDiv))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuSeq != other.menuSeq)
			return false;
		if (selectDate == null) {
			if (other.selectDate != null)
				return false;
		} else if (!selectDate.equals(other.selectDate))
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MainCpListVO [seqNum=" + seqNum + ", cpSeq=" + cpSeq + ", cpName=" + cpName + ", menuSeq=" + menuSeq
				+ ", imgUrl=" + imgUrl + ", listDiv=" + listDiv + ", selectDate=" + selectDate + ", menuName="
				+ menuName + "]";
	}
}
