package com.baobab.m.vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class EventCpMenuVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @SerializedName("seqNum")
	private int seqNum;
    @SerializedName("menuName")
	private String menuName;
    @SerializedName("optionSeq")
	private int optionSeq;
    @SerializedName("price")
	private int price;
    @SerializedName("disPrice")
	private int disPrice;
    @SerializedName("percentAge")
	private int percentAge;
    @SerializedName("salesRate")
	private int salesRate;
    @SerializedName("optionSerial")
    private String optionSerial;
    @SerializedName("menuInfo")
	private String menuInfo;
    @SerializedName("selectedEa")
	private int selectedEa;
	public EventCpMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventCpMenuVO(int seqNum, String menuName, int optionSeq, int price, int disPrice, int percentAge,
			int salesRate, String optionSerial, String menuInfo, int selectedEa) {
		super();
		this.seqNum = seqNum;
		this.menuName = menuName;
		this.optionSeq = optionSeq;
		this.price = price;
		this.disPrice = disPrice;
		this.percentAge = percentAge;
		this.salesRate = salesRate;
		this.optionSerial = optionSerial;
		this.menuInfo = menuInfo;
		this.selectedEa = selectedEa;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getOptionSeq() {
		return optionSeq;
	}
	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
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
	public int getPercentAge() {
		return percentAge;
	}
	public void setPercentAge(int percentAge) {
		this.percentAge = percentAge;
	}
	public int getSalesRate() {
		return salesRate;
	}
	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}
	public String getOptionSerial() {
		return optionSerial;
	}
	public void setOptionSerial(String optionSerial) {
		this.optionSerial = optionSerial;
	}
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	public int getSelectedEa() {
		return selectedEa;
	}
	public void setSelectedEa(int selectedEa) {
		this.selectedEa = selectedEa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + disPrice;
		result = prime * result + ((menuInfo == null) ? 0 : menuInfo.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + optionSeq;
		result = prime * result + ((optionSerial == null) ? 0 : optionSerial.hashCode());
		result = prime * result + percentAge;
		result = prime * result + price;
		result = prime * result + salesRate;
		result = prime * result + selectedEa;
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
		EventCpMenuVO other = (EventCpMenuVO) obj;
		if (disPrice != other.disPrice)
			return false;
		if (menuInfo == null) {
			if (other.menuInfo != null)
				return false;
		} else if (!menuInfo.equals(other.menuInfo))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (optionSeq != other.optionSeq)
			return false;
		if (optionSerial == null) {
			if (other.optionSerial != null)
				return false;
		} else if (!optionSerial.equals(other.optionSerial))
			return false;
		if (percentAge != other.percentAge)
			return false;
		if (price != other.price)
			return false;
		if (salesRate != other.salesRate)
			return false;
		if (selectedEa != other.selectedEa)
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EventCpMenuVO [seqNum=" + seqNum + ", menuName=" + menuName + ", optionSeq=" + optionSeq + ", price="
				+ price + ", disPrice=" + disPrice + ", percentAge=" + percentAge + ", salesRate=" + salesRate
				+ ", optionSerial=" + optionSerial + ", menuInfo=" + menuInfo + ", selectedEa=" + selectedEa + "]";
	}
}
