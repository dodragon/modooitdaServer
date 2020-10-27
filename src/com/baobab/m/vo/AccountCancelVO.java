package com.baobab.m.vo;

public class AccountCancelVO {
	private String PCD_PAY_RST;
	private String PCD_PAY_MSG;
	private String PCD_PAY_TYPE;
	private String PCD_PAY_WORK;
	private String PCD_PAYER_ID;
	private String PCD_PAYER_NO;
	public AccountCancelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountCancelVO(String pCD_PAY_RST, String pCD_PAY_MSG, String pCD_PAY_TYPE, String pCD_PAY_WORK,
			String pCD_PAYER_ID, String pCD_PAYER_NO) {
		super();
		PCD_PAY_RST = pCD_PAY_RST;
		PCD_PAY_MSG = pCD_PAY_MSG;
		PCD_PAY_TYPE = pCD_PAY_TYPE;
		PCD_PAY_WORK = pCD_PAY_WORK;
		PCD_PAYER_ID = pCD_PAYER_ID;
		PCD_PAYER_NO = pCD_PAYER_NO;
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
	public String getPCD_PAY_WORK() {
		return PCD_PAY_WORK;
	}
	public void setPCD_PAY_WORK(String pCD_PAY_WORK) {
		PCD_PAY_WORK = pCD_PAY_WORK;
	}
	public String getPCD_PAYER_ID() {
		return PCD_PAYER_ID;
	}
	public void setPCD_PAYER_ID(String pCD_PAYER_ID) {
		PCD_PAYER_ID = pCD_PAYER_ID;
	}
	public String getPCD_PAYER_NO() {
		return PCD_PAYER_NO;
	}
	public void setPCD_PAYER_NO(String pCD_PAYER_NO) {
		PCD_PAYER_NO = pCD_PAYER_NO;
	}
	@Override
	public String toString() {
		return "AccountCancelVO [PCD_PAY_RST=" + PCD_PAY_RST + ", PCD_PAY_MSG=" + PCD_PAY_MSG + ", PCD_PAY_TYPE="
				+ PCD_PAY_TYPE + ", PCD_PAY_WORK=" + PCD_PAY_WORK + ", PCD_PAYER_ID=" + PCD_PAYER_ID + ", PCD_PAYER_NO="
				+ PCD_PAYER_NO + "]";
	}
}
