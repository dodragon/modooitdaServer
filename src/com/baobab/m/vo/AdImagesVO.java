package com.baobab.m.vo;

public class AdImagesVO {

	private int seqNum;
	private String sm_img;
	private String big_img;
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getSm_img() {
		return sm_img;
	}
	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}
	public String getBig_img() {
		return big_img;
	}
	public void setBig_img(String big_img) {
		this.big_img = big_img;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((big_img == null) ? 0 : big_img.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((sm_img == null) ? 0 : sm_img.hashCode());
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
		AdImagesVO other = (AdImagesVO) obj;
		if (big_img == null) {
			if (other.big_img != null)
				return false;
		} else if (!big_img.equals(other.big_img))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (sm_img == null) {
			if (other.sm_img != null)
				return false;
		} else if (!sm_img.equals(other.sm_img))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdImagesVO [seqNum=" + seqNum + ", sm_img=" + sm_img + ", big_img=" + big_img + "]";
	}
	public AdImagesVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
