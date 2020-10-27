package com.baobab.m.vo;

public class AccountSelectVO {
	private String PCD_PAY_RST;
	private String PCD_PAY_CODE;
	private String PCD_PAY_MSG;
	private String PCD_PAY_TYPE;
	private String PCD_PAYER_ID;
	private String PCD_PAYER_NAME;
	private String PCD_PAYER_HP;
	private String PCD_PAY_BANK;
	private String PCD_PAY_BANKNAME;
	private String PCD_PAY_BANKNUM;
	public AccountSelectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountSelectVO(String pCD_PAY_RST, String pCD_PAY_CODE, String pCD_PAY_MSG, String pCD_PAY_TYPE,
			String pCD_PAYER_ID, String pCD_PAYER_NAME, String pCD_PAYER_HP, String pCD_PAY_BANK,
			String pCD_PAY_BANKNAME, String pCD_PAY_BANKNUM) {
		super();
		PCD_PAY_RST = pCD_PAY_RST;
		PCD_PAY_CODE = pCD_PAY_CODE;
		PCD_PAY_MSG = pCD_PAY_MSG;
		PCD_PAY_TYPE = pCD_PAY_TYPE;
		PCD_PAYER_ID = pCD_PAYER_ID;
		PCD_PAYER_NAME = pCD_PAYER_NAME;
		PCD_PAYER_HP = pCD_PAYER_HP;
		PCD_PAY_BANK = pCD_PAY_BANK;
		PCD_PAY_BANKNAME = pCD_PAY_BANKNAME;
		PCD_PAY_BANKNUM = pCD_PAY_BANKNUM;
	}
	public String getPCD_PAY_RST() {
		return PCD_PAY_RST;
	}
	public void setPCD_PAY_RST(String pCD_PAY_RST) {
		PCD_PAY_RST = pCD_PAY_RST;
	}
	public String getPCD_PAY_CODE() {
		return PCD_PAY_CODE;
	}
	public void setPCD_PAY_CODE(String pCD_PAY_CODE) {
		PCD_PAY_CODE = pCD_PAY_CODE;
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
	public String getPCD_PAYER_ID() {
		return PCD_PAYER_ID;
	}
	public void setPCD_PAYER_ID(String pCD_PAYER_ID) {
		PCD_PAYER_ID = pCD_PAYER_ID;
	}
	public String getPCD_PAYER_NAME() {
		return PCD_PAYER_NAME;
	}
	public void setPCD_PAYER_NAME(String pCD_PAYER_NAME) {
		PCD_PAYER_NAME = pCD_PAYER_NAME;
	}
	public String getPCD_PAYER_HP() {
		return PCD_PAYER_HP;
	}
	public void setPCD_PAYER_HP(String pCD_PAYER_HP) {
		PCD_PAYER_HP = pCD_PAYER_HP;
	}
	public String getPCD_PAY_BANK() {
		return PCD_PAY_BANK;
	}
	public void setPCD_PAY_BANK(String pCD_PAY_BANK) {
		PCD_PAY_BANK = pCD_PAY_BANK;
	}
	public String getPCD_PAY_BANKNAME() {
		return PCD_PAY_BANKNAME;
	}
	public void setPCD_PAY_BANKNAME(String pCD_PAY_BANKNAME) {
		PCD_PAY_BANKNAME = pCD_PAY_BANKNAME;
	}
	public String getPCD_PAY_BANKNUM() {
		return PCD_PAY_BANKNUM;
	}
	public void setPCD_PAY_BANKNUM(String pCD_PAY_BANKNUM) {
		PCD_PAY_BANKNUM = pCD_PAY_BANKNUM;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PCD_PAYER_HP == null) ? 0 : PCD_PAYER_HP.hashCode());
		result = prime * result + ((PCD_PAYER_ID == null) ? 0 : PCD_PAYER_ID.hashCode());
		result = prime * result + ((PCD_PAYER_NAME == null) ? 0 : PCD_PAYER_NAME.hashCode());
		result = prime * result + ((PCD_PAY_BANK == null) ? 0 : PCD_PAY_BANK.hashCode());
		result = prime * result + ((PCD_PAY_BANKNAME == null) ? 0 : PCD_PAY_BANKNAME.hashCode());
		result = prime * result + ((PCD_PAY_BANKNUM == null) ? 0 : PCD_PAY_BANKNUM.hashCode());
		result = prime * result + ((PCD_PAY_CODE == null) ? 0 : PCD_PAY_CODE.hashCode());
		result = prime * result + ((PCD_PAY_MSG == null) ? 0 : PCD_PAY_MSG.hashCode());
		result = prime * result + ((PCD_PAY_RST == null) ? 0 : PCD_PAY_RST.hashCode());
		result = prime * result + ((PCD_PAY_TYPE == null) ? 0 : PCD_PAY_TYPE.hashCode());
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
		AccountSelectVO other = (AccountSelectVO) obj;
		if (PCD_PAYER_HP == null) {
			if (other.PCD_PAYER_HP != null)
				return false;
		} else if (!PCD_PAYER_HP.equals(other.PCD_PAYER_HP))
			return false;
		if (PCD_PAYER_ID == null) {
			if (other.PCD_PAYER_ID != null)
				return false;
		} else if (!PCD_PAYER_ID.equals(other.PCD_PAYER_ID))
			return false;
		if (PCD_PAYER_NAME == null) {
			if (other.PCD_PAYER_NAME != null)
				return false;
		} else if (!PCD_PAYER_NAME.equals(other.PCD_PAYER_NAME))
			return false;
		if (PCD_PAY_BANK == null) {
			if (other.PCD_PAY_BANK != null)
				return false;
		} else if (!PCD_PAY_BANK.equals(other.PCD_PAY_BANK))
			return false;
		if (PCD_PAY_BANKNAME == null) {
			if (other.PCD_PAY_BANKNAME != null)
				return false;
		} else if (!PCD_PAY_BANKNAME.equals(other.PCD_PAY_BANKNAME))
			return false;
		if (PCD_PAY_BANKNUM == null) {
			if (other.PCD_PAY_BANKNUM != null)
				return false;
		} else if (!PCD_PAY_BANKNUM.equals(other.PCD_PAY_BANKNUM))
			return false;
		if (PCD_PAY_CODE == null) {
			if (other.PCD_PAY_CODE != null)
				return false;
		} else if (!PCD_PAY_CODE.equals(other.PCD_PAY_CODE))
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
		return true;
	}
	@Override
	public String toString() {
		return "AccountSelectVO [PCD_PAY_RST=" + PCD_PAY_RST + ", PCD_PAY_CODE=" + PCD_PAY_CODE + ", PCD_PAY_MSG="
				+ PCD_PAY_MSG + ", PCD_PAY_TYPE=" + PCD_PAY_TYPE + ", PCD_PAYER_ID=" + PCD_PAYER_ID
				+ ", PCD_PAYER_NAME=" + PCD_PAYER_NAME + ", PCD_PAYER_HP=" + PCD_PAYER_HP + ", PCD_PAY_BANK="
				+ PCD_PAY_BANK + ", PCD_PAY_BANKNAME=" + PCD_PAY_BANKNAME + ", PCD_PAY_BANKNUM=" + PCD_PAY_BANKNUM
				+ "]";
	}
}
