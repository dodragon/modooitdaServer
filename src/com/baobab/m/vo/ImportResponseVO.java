package com.baobab.m.vo;

public class ImportResponseVO {
	private String access_token;
	private String now;
	private String expored_at;
	private String bank_holder;
	public ImportResponseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImportResponseVO(String access_token, String now, String expored_at, String bank_holder) {
		super();
		this.access_token = access_token;
		this.now = now;
		this.expored_at = expored_at;
		this.bank_holder = bank_holder;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public String getExpored_at() {
		return expored_at;
	}
	public void setExpored_at(String expored_at) {
		this.expored_at = expored_at;
	}
	public String getBank_holder() {
		return bank_holder;
	}
	public void setBank_holder(String bank_holder) {
		this.bank_holder = bank_holder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((bank_holder == null) ? 0 : bank_holder.hashCode());
		result = prime * result + ((expored_at == null) ? 0 : expored_at.hashCode());
		result = prime * result + ((now == null) ? 0 : now.hashCode());
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
		ImportResponseVO other = (ImportResponseVO) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (bank_holder == null) {
			if (other.bank_holder != null)
				return false;
		} else if (!bank_holder.equals(other.bank_holder))
			return false;
		if (expored_at == null) {
			if (other.expored_at != null)
				return false;
		} else if (!expored_at.equals(other.expored_at))
			return false;
		if (now == null) {
			if (other.now != null)
				return false;
		} else if (!now.equals(other.now))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImportResponseVO [access_token=" + access_token + ", now=" + now + ", expored_at=" + expored_at
				+ ", bank_holder=" + bank_holder + "]";
	}
}
