package com.baobab.m.vo;

import java.util.Date;

public class MainCpListTitleVO {
	private int seqNum;
	private String writer;
	private String mainText;
	private String subText;
	private String titleDiv;
	private String pageDiv;
	private String titleStatus;
	private Date writeDate;
	public MainCpListTitleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainCpListTitleVO(int seqNum, String writer, String mainText, String subText, String titleDiv,
			String pageDiv, String titleStatus, Date writeDate) {
		super();
		this.seqNum = seqNum;
		this.writer = writer;
		this.mainText = mainText;
		this.subText = subText;
		this.titleDiv = titleDiv;
		this.pageDiv = pageDiv;
		this.titleStatus = titleStatus;
		this.writeDate = writeDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public String getSubText() {
		return subText;
	}
	public void setSubText(String subText) {
		this.subText = subText;
	}
	public String getTitleDiv() {
		return titleDiv;
	}
	public void setTitleDiv(String titleDiv) {
		this.titleDiv = titleDiv;
	}
	public String getPageDiv() {
		return pageDiv;
	}
	public void setPageDiv(String pageDiv) {
		this.pageDiv = pageDiv;
	}
	public String getTitleStatus() {
		return titleStatus;
	}
	public void setTitleStatus(String titleStatus) {
		this.titleStatus = titleStatus;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mainText == null) ? 0 : mainText.hashCode());
		result = prime * result + ((pageDiv == null) ? 0 : pageDiv.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((subText == null) ? 0 : subText.hashCode());
		result = prime * result + ((titleDiv == null) ? 0 : titleDiv.hashCode());
		result = prime * result + ((titleStatus == null) ? 0 : titleStatus.hashCode());
		result = prime * result + ((writeDate == null) ? 0 : writeDate.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		MainCpListTitleVO other = (MainCpListTitleVO) obj;
		if (mainText == null) {
			if (other.mainText != null)
				return false;
		} else if (!mainText.equals(other.mainText))
			return false;
		if (pageDiv == null) {
			if (other.pageDiv != null)
				return false;
		} else if (!pageDiv.equals(other.pageDiv))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (subText == null) {
			if (other.subText != null)
				return false;
		} else if (!subText.equals(other.subText))
			return false;
		if (titleDiv == null) {
			if (other.titleDiv != null)
				return false;
		} else if (!titleDiv.equals(other.titleDiv))
			return false;
		if (titleStatus == null) {
			if (other.titleStatus != null)
				return false;
		} else if (!titleStatus.equals(other.titleStatus))
			return false;
		if (writeDate == null) {
			if (other.writeDate != null)
				return false;
		} else if (!writeDate.equals(other.writeDate))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MainCpListTitleVO [seqNum=" + seqNum + ", writer=" + writer + ", mainText=" + mainText + ", subText="
				+ subText + ", titleDiv=" + titleDiv + ", pageDiv=" + pageDiv + ", titleStatus=" + titleStatus
				+ ", writeDate=" + writeDate + "]";
	}
}
