package com.baobab.m.vo;

import java.util.Date;
import java.util.List;

public class ReviewsVO {
	private int seqNum;
	private String revCode;
	private String userEmail;
	private String nickName;
	private int score;
	private String content;
	private int cpSeq;
	private String orderNum;
	private Date insertDate;
	private String cpName;
	private String usedTicket;
	private List<ReviewImgVO> imgList;
	
	public ReviewsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewsVO(int seqNum, String revCode, String userEmail, String nickName, int score, String content,
			int cpSeq, String orderNum, Date insertDate, String cpName, String usedTicket, List<ReviewImgVO> imgList) {
		super();
		this.seqNum = seqNum;
		this.revCode = revCode;
		this.userEmail = userEmail;
		this.nickName = nickName;
		this.score = score;
		this.content = content;
		this.cpSeq = cpSeq;
		this.orderNum = orderNum;
		this.insertDate = insertDate;
		this.cpName = cpName;
		this.usedTicket = usedTicket;
		this.imgList = imgList;
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getUsedTicket() {
		return usedTicket;
	}
	public void setUsedTicket(String usedTicket) {
		this.usedTicket = usedTicket;
	}
	public List<ReviewImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ReviewImgVO> imgList) {
		this.imgList = imgList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((imgList == null) ? 0 : imgList.hashCode());
		result = prime * result + ((insertDate == null) ? 0 : insertDate.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((revCode == null) ? 0 : revCode.hashCode());
		result = prime * result + score;
		result = prime * result + seqNum;
		result = prime * result + ((usedTicket == null) ? 0 : usedTicket.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
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
		ReviewsVO other = (ReviewsVO) obj;
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
		if (imgList == null) {
			if (other.imgList != null)
				return false;
		} else if (!imgList.equals(other.imgList))
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
		if (revCode == null) {
			if (other.revCode != null)
				return false;
		} else if (!revCode.equals(other.revCode))
			return false;
		if (score != other.score)
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (usedTicket == null) {
			if (other.usedTicket != null)
				return false;
		} else if (!usedTicket.equals(other.usedTicket))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReviewsVO [seqNum=" + seqNum + ", revCode=" + revCode + ", userEmail=" + userEmail + ", nickName="
				+ nickName + ", score=" + score + ", content=" + content + ", cpSeq=" + cpSeq + ", orderNum=" + orderNum
				+ ", insertDate=" + insertDate + ", cpName=" + cpName + ", usedTicket=" + usedTicket + ", imgList="
				+ imgList + "]";
	}
}
