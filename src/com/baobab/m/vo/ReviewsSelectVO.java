package com.baobab.m.vo;

import java.util.Date;
import java.util.List;

public class ReviewsSelectVO {
	private String nickName;
	private int score;
	private String profileImg;
	private String payMenus;
	private String content;
	private Date insertDate;
	private int cpSeq;
	private String cpName;
	private List<String> imgUrls;
	private String orderNum;
	private String revCode;
	
	public ReviewsSelectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewsSelectVO(String nickName, int score, String profileImg, String payMenus, String content,
			Date insertDate, int cpSeq, String cpName, List<String> imgUrls, String orderNum, String revCode) {
		super();
		this.nickName = nickName;
		this.score = score;
		this.profileImg = profileImg;
		this.payMenus = payMenus;
		this.content = content;
		this.insertDate = insertDate;
		this.cpSeq = cpSeq;
		this.cpName = cpName;
		this.imgUrls = imgUrls;
		this.orderNum = orderNum;
		this.revCode = revCode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getPayMenus() {
		return payMenus;
	}
	public void setPayMenus(String payMenus) {
		this.payMenus = payMenus;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
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
	public List<String> getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getRevCode() {
		return revCode;
	}
	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((imgUrls == null) ? 0 : imgUrls.hashCode());
		result = prime * result + ((insertDate == null) ? 0 : insertDate.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((payMenus == null) ? 0 : payMenus.hashCode());
		result = prime * result + ((profileImg == null) ? 0 : profileImg.hashCode());
		result = prime * result + ((revCode == null) ? 0 : revCode.hashCode());
		result = prime * result + score;
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
		ReviewsSelectVO other = (ReviewsSelectVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (imgUrls == null) {
			if (other.imgUrls != null)
				return false;
		} else if (!imgUrls.equals(other.imgUrls))
			return false;
		if (insertDate == null) {
			if (other.insertDate != null)
				return false;
		} else if (!insertDate.equals(other.insertDate))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (payMenus == null) {
			if (other.payMenus != null)
				return false;
		} else if (!payMenus.equals(other.payMenus))
			return false;
		if (profileImg == null) {
			if (other.profileImg != null)
				return false;
		} else if (!profileImg.equals(other.profileImg))
			return false;
		if (revCode == null) {
			if (other.revCode != null)
				return false;
		} else if (!revCode.equals(other.revCode))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReviewsSelectVO [nickName=" + nickName + ", score=" + score + ", profileImg=" + profileImg
				+ ", payMenus=" + payMenus + ", content=" + content + ", insertDate=" + insertDate + ", cpSeq=" + cpSeq
				+ ", cpName=" + cpName + ", imgUrls=" + imgUrls + ", orderNum=" + orderNum + ", revCode=" + revCode
				+ "]";
	}
}
