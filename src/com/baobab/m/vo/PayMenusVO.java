package com.baobab.m.vo;

import java.util.Date;

public class PayMenusVO {
	private int seqNum;
	private String orderNum;
	private String menuName;
	private int menuSeq;
	private String optionSerial;
	private int cpSeq;
	private String payEmail;
	private int price;
	private int disPrice;
	private int ea;
	private Date payDate;
	
	public PayMenusVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayMenusVO(int seqNum, String orderNum, String menuName, int menuSeq, String optionSerial, int cpSeq,
			String payEmail, int price, int disPrice, int ea, Date payDate) {
		super();
		this.seqNum = seqNum;
		this.orderNum = orderNum;
		this.menuName = menuName;
		this.menuSeq = menuSeq;
		this.optionSerial = optionSerial;
		this.cpSeq = cpSeq;
		this.payEmail = payEmail;
		this.price = price;
		this.disPrice = disPrice;
		this.ea = ea;
		this.payDate = payDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}
	public String getOptionSerial() {
		return optionSerial;
	}
	public void setOptionSerial(String optionSerial) {
		this.optionSerial = optionSerial;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	public String getPayEmail() {
		return payEmail;
	}
	public void setPayEmail(String payEmail) {
		this.payEmail = payEmail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDisPrice() {
		return disPrice;
	}
	public void setDisPrice(int disPrice) {
		this.disPrice = disPrice;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpSeq;
		result = prime * result + disPrice;
		result = prime * result + ea;
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + menuSeq;
		result = prime * result + ((optionSerial == null) ? 0 : optionSerial.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((payEmail == null) ? 0 : payEmail.hashCode());
		result = prime * result + price;
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
		PayMenusVO other = (PayMenusVO) obj;
		if (cpSeq != other.cpSeq)
			return false;
		if (disPrice != other.disPrice)
			return false;
		if (ea != other.ea)
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuSeq != other.menuSeq)
			return false;
		if (optionSerial == null) {
			if (other.optionSerial != null)
				return false;
		} else if (!optionSerial.equals(other.optionSerial))
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
		if (payEmail == null) {
			if (other.payEmail != null)
				return false;
		} else if (!payEmail.equals(other.payEmail))
			return false;
		if (price != other.price)
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PayMenusVO [seqNum=" + seqNum + ", orderNum=" + orderNum + ", menuName=" + menuName + ", menuSeq="
				+ menuSeq + ", optionSerial=" + optionSerial + ", cpSeq=" + cpSeq + ", payEmail=" + payEmail
				+ ", price=" + price + ", disPrice=" + disPrice + ", ea=" + ea + ", payDate=" + payDate + "]";
	}
}
