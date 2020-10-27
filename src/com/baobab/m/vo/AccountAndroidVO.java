package com.baobab.m.vo;

public class AccountAndroidVO {
	private String accountHolder;
    private String payerId;
    private String email;
    private String phoneNumber;
    private String bankCode;
    private String bankName;
    private String accountNumber;
	public AccountAndroidVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountAndroidVO(String accountHolder, String payerId, String email, String phoneNumber, String bankCode,
			String bankName, String accountNumber) {
		super();
		this.accountHolder = accountHolder;
		this.payerId = payerId;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolder == null) ? 0 : accountHolder.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((payerId == null) ? 0 : payerId.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		AccountAndroidVO other = (AccountAndroidVO) obj;
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (payerId == null) {
			if (other.payerId != null)
				return false;
		} else if (!payerId.equals(other.payerId))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AccountAndroidVO [accountHolder=" + accountHolder + ", payerId=" + payerId + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", accountNumber=" + accountNumber + "]";
	}
}
