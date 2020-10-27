package com.baobab.m.vo;

public class PaypleReciptResultVO {
	private String PCD_PAY_RST;
	private String PCD_PAY_MSG;
	private String PCD_PAYER_ID;
	private String PCD_PAY_OID;
	private String PCD_REGULER_FLAG;
	private String PCD_TAXSAVE_AMOUNT;
	private String PCD_TAXSAVE_MGTNUM;
	public PaypleReciptResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaypleReciptResultVO(String pCD_PAY_RST, String pCD_PAY_MSG, String pCD_PAYER_ID, String pCD_PAY_OID,
			String pCD_REGULER_FLAG, String pCD_TAXSAVE_AMOUNT, String pCD_TAXSAVE_MGTNUM) {
		super();
		PCD_PAY_RST = pCD_PAY_RST;
		PCD_PAY_MSG = pCD_PAY_MSG;
		PCD_PAYER_ID = pCD_PAYER_ID;
		PCD_PAY_OID = pCD_PAY_OID;
		PCD_REGULER_FLAG = pCD_REGULER_FLAG;
		PCD_TAXSAVE_AMOUNT = pCD_TAXSAVE_AMOUNT;
		PCD_TAXSAVE_MGTNUM = pCD_TAXSAVE_MGTNUM;
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
	public String getPCD_PAYER_ID() {
		return PCD_PAYER_ID;
	}
	public void setPCD_PAYER_ID(String pCD_PAYER_ID) {
		PCD_PAYER_ID = pCD_PAYER_ID;
	}
	public String getPCD_PAY_OID() {
		return PCD_PAY_OID;
	}
	public void setPCD_PAY_OID(String pCD_PAY_OID) {
		PCD_PAY_OID = pCD_PAY_OID;
	}
	public String getPCD_REGULER_FLAG() {
		return PCD_REGULER_FLAG;
	}
	public void setPCD_REGULER_FLAG(String pCD_REGULER_FLAG) {
		PCD_REGULER_FLAG = pCD_REGULER_FLAG;
	}
	public String getPCD_TAXSAVE_AMOUNT() {
		return PCD_TAXSAVE_AMOUNT;
	}
	public void setPCD_TAXSAVE_AMOUNT(String pCD_TAXSAVE_AMOUNT) {
		PCD_TAXSAVE_AMOUNT = pCD_TAXSAVE_AMOUNT;
	}
	public String getPCD_TAXSAVE_MGTNUM() {
		return PCD_TAXSAVE_MGTNUM;
	}
	public void setPCD_TAXSAVE_MGTNUM(String pCD_TAXSAVE_MGTNUM) {
		PCD_TAXSAVE_MGTNUM = pCD_TAXSAVE_MGTNUM;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PCD_PAYER_ID == null) ? 0 : PCD_PAYER_ID.hashCode());
		result = prime * result + ((PCD_PAY_MSG == null) ? 0 : PCD_PAY_MSG.hashCode());
		result = prime * result + ((PCD_PAY_OID == null) ? 0 : PCD_PAY_OID.hashCode());
		result = prime * result + ((PCD_PAY_RST == null) ? 0 : PCD_PAY_RST.hashCode());
		result = prime * result + ((PCD_REGULER_FLAG == null) ? 0 : PCD_REGULER_FLAG.hashCode());
		result = prime * result + ((PCD_TAXSAVE_AMOUNT == null) ? 0 : PCD_TAXSAVE_AMOUNT.hashCode());
		result = prime * result + ((PCD_TAXSAVE_MGTNUM == null) ? 0 : PCD_TAXSAVE_MGTNUM.hashCode());
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
		PaypleReciptResultVO other = (PaypleReciptResultVO) obj;
		if (PCD_PAYER_ID == null) {
			if (other.PCD_PAYER_ID != null)
				return false;
		} else if (!PCD_PAYER_ID.equals(other.PCD_PAYER_ID))
			return false;
		if (PCD_PAY_MSG == null) {
			if (other.PCD_PAY_MSG != null)
				return false;
		} else if (!PCD_PAY_MSG.equals(other.PCD_PAY_MSG))
			return false;
		if (PCD_PAY_OID == null) {
			if (other.PCD_PAY_OID != null)
				return false;
		} else if (!PCD_PAY_OID.equals(other.PCD_PAY_OID))
			return false;
		if (PCD_PAY_RST == null) {
			if (other.PCD_PAY_RST != null)
				return false;
		} else if (!PCD_PAY_RST.equals(other.PCD_PAY_RST))
			return false;
		if (PCD_REGULER_FLAG == null) {
			if (other.PCD_REGULER_FLAG != null)
				return false;
		} else if (!PCD_REGULER_FLAG.equals(other.PCD_REGULER_FLAG))
			return false;
		if (PCD_TAXSAVE_AMOUNT == null) {
			if (other.PCD_TAXSAVE_AMOUNT != null)
				return false;
		} else if (!PCD_TAXSAVE_AMOUNT.equals(other.PCD_TAXSAVE_AMOUNT))
			return false;
		if (PCD_TAXSAVE_MGTNUM == null) {
			if (other.PCD_TAXSAVE_MGTNUM != null)
				return false;
		} else if (!PCD_TAXSAVE_MGTNUM.equals(other.PCD_TAXSAVE_MGTNUM))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaypleReciptResultVO [PCD_PAY_RST=" + PCD_PAY_RST + ", PCD_PAY_MSG=" + PCD_PAY_MSG + ", PCD_PAYER_ID="
				+ PCD_PAYER_ID + ", PCD_PAY_OID=" + PCD_PAY_OID + ", PCD_REGULER_FLAG=" + PCD_REGULER_FLAG
				+ ", PCD_TAXSAVE_AMOUNT=" + PCD_TAXSAVE_AMOUNT + ", PCD_TAXSAVE_MGTNUM=" + PCD_TAXSAVE_MGTNUM + "]";
	}
}
