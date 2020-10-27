package com.baobab.m.vo;

import java.util.Date;

public class PaymentVO {
	private int seqNum;
	private String email;
	private String userPhone;
	private String orderNum;
	private String cpName;
	private int cpSeq;
	private String goods;
	private int totalPrice;
	private int totalDisPrice;
	private String payStatus;
	private String tid;
	private String used;
	private Date payDate;
	private Date useDate;
	private Date cancelDate;
	private Date curDate;
	private String pg;
	private int revFlag;
	public PaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentVO(int seqNum, String email, String userPhone, String orderNum, String cpName, int cpSeq,
			String goods, int totalPrice, int totalDisPrice, String payStatus, String tid, String used, Date payDate,
			Date useDate, Date cancelDate, Date curDate, String pg, int revFlag) {
		super();
		this.seqNum = seqNum;
		this.email = email;
		this.userPhone = userPhone;
		this.orderNum = orderNum;
		this.cpName = cpName;
		this.cpSeq = cpSeq;
		this.goods = goods;
		this.totalPrice = totalPrice;
		this.totalDisPrice = totalDisPrice;
		this.payStatus = payStatus;
		this.tid = tid;
		this.used = used;
		this.payDate = payDate;
		this.useDate = useDate;
		this.cancelDate = cancelDate;
		this.curDate = curDate;
		this.pg = pg;
		this.revFlag = revFlag;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalDisPrice() {
		return totalDisPrice;
	}
	public void setTotalDisPrice(int totalDisPrice) {
		this.totalDisPrice = totalDisPrice;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public Date getCurDate() {
		return curDate;
	}
	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public int getRevFlag() {
		return revFlag;
	}
	public void setRevFlag(int revFlag) {
		this.revFlag = revFlag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancelDate == null) ? 0 : cancelDate.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + ((curDate == null) ? 0 : curDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((payStatus == null) ? 0 : payStatus.hashCode());
		result = prime * result + ((pg == null) ? 0 : pg.hashCode());
		result = prime * result + revFlag;
		result = prime * result + seqNum;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + totalDisPrice;
		result = prime * result + totalPrice;
		result = prime * result + ((useDate == null) ? 0 : useDate.hashCode());
		result = prime * result + ((used == null) ? 0 : used.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
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
		PaymentVO other = (PaymentVO) obj;
		if (cancelDate == null) {
			if (other.cancelDate != null)
				return false;
		} else if (!cancelDate.equals(other.cancelDate))
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (curDate == null) {
			if (other.curDate != null)
				return false;
		} else if (!curDate.equals(other.curDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (payStatus == null) {
			if (other.payStatus != null)
				return false;
		} else if (!payStatus.equals(other.payStatus))
			return false;
		if (pg == null) {
			if (other.pg != null)
				return false;
		} else if (!pg.equals(other.pg))
			return false;
		if (revFlag != other.revFlag)
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (totalDisPrice != other.totalDisPrice)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (useDate == null) {
			if (other.useDate != null)
				return false;
		} else if (!useDate.equals(other.useDate))
			return false;
		if (used == null) {
			if (other.used != null)
				return false;
		} else if (!used.equals(other.used))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentVO [seqNum=" + seqNum + ", email=" + email + ", userPhone=" + userPhone + ", orderNum="
				+ orderNum + ", cpName=" + cpName + ", cpSeq=" + cpSeq + ", goods=" + goods + ", totalPrice="
				+ totalPrice + ", totalDisPrice=" + totalDisPrice + ", payStatus=" + payStatus + ", tid=" + tid
				+ ", used=" + used + ", payDate=" + payDate + ", useDate=" + useDate + ", cancelDate=" + cancelDate
				+ ", curDate=" + curDate + ", pg=" + pg + ", revFlag=" + revFlag + "]";
	}
}
