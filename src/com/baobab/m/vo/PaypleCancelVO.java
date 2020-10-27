package com.baobab.m.vo;

public class PaypleCancelVO {
	private String PCD_PAY_RST;
	private String PCD_PAY_MSG;
	private String PCD_PAY_TYPE;
	private String PCD_PAYER_NO;
	private String PCD_PAYER_ID;
	private String PCD_PAY_GOODS;
	private String PCD_REFUND_TOTAL;
	public PaypleCancelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaypleCancelVO(String pCD_PAY_RST, String pCD_PAY_MSG, String pCD_PAY_TYPE, String pCD_PAYER_NO,
			String pCD_PAYER_ID, String pCD_PAY_GOODS, String pCD_REFUND_TOTAL) {
		super();
		PCD_PAY_RST = pCD_PAY_RST;
		PCD_PAY_MSG = pCD_PAY_MSG;
		PCD_PAY_TYPE = pCD_PAY_TYPE;
		PCD_PAYER_NO = pCD_PAYER_NO;
		PCD_PAYER_ID = pCD_PAYER_ID;
		PCD_PAY_GOODS = pCD_PAY_GOODS;
		PCD_REFUND_TOTAL = pCD_REFUND_TOTAL;
	}
	public String getPCD_PAY_RST() {
		return PCD_PAY_RST;
	}
	public void setPCD_PAY_RST(String pCD_PAY_RST) {
		PCD_PAY_RST = pCD_PAY_RST;
	}
	public String getPCD_PAY_MSG() {
		return PCD_PAY_MSG;
	}
	public void setPCD_PAY_MSG(String pCD_PAY_MSG) {
		PCD_PAY_MSG = pCD_PAY_MSG;
	}
	public String getPCD_PAY_TYPE() {
		return PCD_PAY_TYPE;
	}
	public void setPCD_PAY_TYPE(String pCD_PAY_TYPE) {
		PCD_PAY_TYPE = pCD_PAY_TYPE;
	}
	public String getPCD_PAYER_NO() {
		return PCD_PAYER_NO;
	}
	public void setPCD_PAYER_NO(String pCD_PAYER_NO) {
		PCD_PAYER_NO = pCD_PAYER_NO;
	}
	public String getPCD_PAYER_ID() {
		return PCD_PAYER_ID;
	}
	public void setPCD_PAYER_ID(String pCD_PAYER_ID) {
		PCD_PAYER_ID = pCD_PAYER_ID;
	}
	public String getPCD_PAY_GOODS() {
		return PCD_PAY_GOODS;
	}
	public void setPCD_PAY_GOODS(String pCD_PAY_GOODS) {
		PCD_PAY_GOODS = pCD_PAY_GOODS;
	}
	public String getPCD_REFUND_TOTAL() {
		return PCD_REFUND_TOTAL;
	}
	public void setPCD_REFUND_TOTAL(String pCD_REFUND_TOTAL) {
		PCD_REFUND_TOTAL = pCD_REFUND_TOTAL;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PCD_PAYER_ID == null) ? 0 : PCD_PAYER_ID.hashCode());
		result = prime * result + ((PCD_PAYER_NO == null) ? 0 : PCD_PAYER_NO.hashCode());
		result = prime * result + ((PCD_PAY_GOODS == null) ? 0 : PCD_PAY_GOODS.hashCode());
		result = prime * result + ((PCD_PAY_MSG == null) ? 0 : PCD_PAY_MSG.hashCode());
		result = prime * result + ((PCD_PAY_RST == null) ? 0 : PCD_PAY_RST.hashCode());
		result = prime * result + ((PCD_PAY_TYPE == null) ? 0 : PCD_PAY_TYPE.hashCode());
		result = prime * result + ((PCD_REFUND_TOTAL == null) ? 0 : PCD_REFUND_TOTAL.hashCode());
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
		PaypleCancelVO other = (PaypleCancelVO) obj;
		if (PCD_PAYER_ID == null) {
			if (other.PCD_PAYER_ID != null)
				return false;
		} else if (!PCD_PAYER_ID.equals(other.PCD_PAYER_ID))
			return false;
		if (PCD_PAYER_NO == null) {
			if (other.PCD_PAYER_NO != null)
				return false;
		} else if (!PCD_PAYER_NO.equals(other.PCD_PAYER_NO))
			return false;
		if (PCD_PAY_GOODS == null) {
			if (other.PCD_PAY_GOODS != null)
				return false;
		} else if (!PCD_PAY_GOODS.equals(other.PCD_PAY_GOODS))
			return false;
		if (PCD_PAY_MSG == null) {
			if (other.PCD_PAY_MSG != null)
				return false;
		} else if (!PCD_PAY_MSG.equals(other.PCD_PAY_MSG))
			return false;
		if (PCD_PAY_RST == null) {
			if (other.PCD_PAY_RST != null)
				return false;
		} else if (!PCD_PAY_RST.equals(other.PCD_PAY_RST))
			return false;
		if (PCD_PAY_TYPE == null) {
			if (other.PCD_PAY_TYPE != null)
				return false;
		} else if (!PCD_PAY_TYPE.equals(other.PCD_PAY_TYPE))
			return false;
		if (PCD_REFUND_TOTAL == null) {
			if (other.PCD_REFUND_TOTAL != null)
				return false;
		} else if (!PCD_REFUND_TOTAL.equals(other.PCD_REFUND_TOTAL))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaypleCancelVO [PCD_PAY_RST=" + PCD_PAY_RST + ", PCD_PAY_MSG=" + PCD_PAY_MSG + ", PCD_PAY_TYPE="
				+ PCD_PAY_TYPE + ", PCD_PAYER_NO=" + PCD_PAYER_NO + ", PCD_PAYER_ID=" + PCD_PAYER_ID
				+ ", PCD_PAY_GOODS=" + PCD_PAY_GOODS + ", PCD_REFUND_TOTAL=" + PCD_REFUND_TOTAL + "]";
	}
}
