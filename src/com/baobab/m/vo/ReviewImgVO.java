package com.baobab.m.vo;

public class ReviewImgVO {
	private int seqNum;
	private String revCode;
	private String imgUrl;
	
	public ReviewImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewImgVO(int seqNum, String revCode, String imgUrl) {
		super();
		this.seqNum = seqNum;
		this.revCode = revCode;
		this.imgUrl = imgUrl;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getRevCode() {
		return revCode;
	}
	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((revCode == null) ? 0 : revCode.hashCode());
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
		ReviewImgVO other = (ReviewImgVO) obj;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (revCode == null) {
			if (other.revCode != null)
				return false;
		} else if (!revCode.equals(other.revCode))
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReviewImgVO [seqNum=" + seqNum + ", revCode=" + revCode + ", imgUrl=" + imgUrl + "]";
	}
}
