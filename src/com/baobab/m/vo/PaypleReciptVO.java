package com.baobab.m.vo;

public class PaypleReciptVO {
	private String PCD_CST_ID;
	private String PCD_CUST_KEY;
	private String PCD_AUTH_KEY;
	private String PCD_PAYER_ID;
	private String PCD_PAY_OID;
	public PaypleReciptVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaypleReciptVO(String pCD_CST_ID, String pCD_CUST_KEY, String pCD_AUTH_KEY, String pCD_PAYER_ID,
			String pCD_PAY_OID) {
		super();
		PCD_CST_ID = pCD_CST_ID;
		PCD_CUST_KEY = pCD_CUST_KEY;
		PCD_AUTH_KEY = pCD_AUTH_KEY;
		PCD_PAYER_ID = pCD_PAYER_ID;
		PCD_PAY_OID = pCD_PAY_OID;
	}
	public String getPCD_CST_ID() {
		return PCD_CST_ID;
	}
	public void setPCD_CST_ID(String pCD_CST_ID) {
		PCD_CST_ID = pCD_CST_ID;
	}
	public String getPCD_CUST_KEY() {
		return PCD_CUST_KEY;
	}
	public void setPCD_CUST_KEY(String pCD_CUST_KEY) {
		PCD_CUST_KEY = pCD_CUST_KEY;
	}
	public String getPCD_AUTH_KEY() {
		return PCD_AUTH_KEY;
	}
	public void setPCD_AUTH_KEY(String pCD_AUTH_KEY) {
		PCD_AUTH_KEY = pCD_AUTH_KEY;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PCD_AUTH_KEY == null) ? 0 : PCD_AUTH_KEY.hashCode());
		result = prime * result + ((PCD_CST_ID == null) ? 0 : PCD_CST_ID.hashCode());
		result = prime * result + ((PCD_CUST_KEY == null) ? 0 : PCD_CUST_KEY.hashCode());
		result = prime * result + ((PCD_PAYER_ID == null) ? 0 : PCD_PAYER_ID.hashCode());
		result = prime * result + ((PCD_PAY_OID == null) ? 0 : PCD_PAY_OID.hashCode());
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
		PaypleReciptVO other = (PaypleReciptVO) obj;
		if (PCD_AUTH_KEY == null) {
			if (other.PCD_AUTH_KEY != null)
				return false;
		} else if (!PCD_AUTH_KEY.equals(other.PCD_AUTH_KEY))
			return false;
		if (PCD_CST_ID == null) {
			if (other.PCD_CST_ID != null)
				return false;
		} else if (!PCD_CST_ID.equals(other.PCD_CST_ID))
			return false;
		if (PCD_CUST_KEY == null) {
			if (other.PCD_CUST_KEY != null)
				return false;
		} else if (!PCD_CUST_KEY.equals(other.PCD_CUST_KEY))
			return false;
		if (PCD_PAYER_ID == null) {
			if (other.PCD_PAYER_ID != null)
				return false;
		} else if (!PCD_PAYER_ID.equals(other.PCD_PAYER_ID))
			return false;
		if (PCD_PAY_OID == null) {
			if (other.PCD_PAY_OID != null)
				return false;
		} else if (!PCD_PAY_OID.equals(other.PCD_PAY_OID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaypleReciptVO [PCD_CST_ID=" + PCD_CST_ID + ", PCD_CUST_KEY=" + PCD_CUST_KEY + ", PCD_AUTH_KEY="
				+ PCD_AUTH_KEY + ", PCD_PAYER_ID=" + PCD_PAYER_ID + ", PCD_PAY_OID=" + PCD_PAY_OID + "]";
	}
}
