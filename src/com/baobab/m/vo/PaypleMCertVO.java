package com.baobab.m.vo;

public class PaypleMCertVO {
	private String result;
	private String result_msg;
	private String cst_id;
	private String custKey;
	private String AuthKey;
	private String PCD_PAY_HOST;
	private String PCD_PAY_URL;
	private String return_url;
	public PaypleMCertVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaypleMCertVO(String result, String result_msg, String cst_id, String custKey, String authKey,
			String pCD_PAY_HOST, String pCD_PAY_URL, String return_url) {
		super();
		this.result = result;
		this.result_msg = result_msg;
		this.cst_id = cst_id;
		this.custKey = custKey;
		AuthKey = authKey;
		PCD_PAY_HOST = pCD_PAY_HOST;
		PCD_PAY_URL = pCD_PAY_URL;
		this.return_url = return_url;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}
	public String getCst_id() {
		return cst_id;
	}
	public void setCst_id(String cst_id) {
		this.cst_id = cst_id;
	}
	public String getCustKey() {
		return custKey;
	}
	public void setCustKey(String custKey) {
		this.custKey = custKey;
	}
	public String getAuthKey() {
		return AuthKey;
	}
	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}
	public String getPCD_PAY_HOST() {
		return PCD_PAY_HOST;
	}
	public void setPCD_PAY_HOST(String pCD_PAY_HOST) {
		PCD_PAY_HOST = pCD_PAY_HOST;
	}
	public String getPCD_PAY_URL() {
		return PCD_PAY_URL;
	}
	public void setPCD_PAY_URL(String pCD_PAY_URL) {
		PCD_PAY_URL = pCD_PAY_URL;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AuthKey == null) ? 0 : AuthKey.hashCode());
		result = prime * result + ((PCD_PAY_HOST == null) ? 0 : PCD_PAY_HOST.hashCode());
		result = prime * result + ((PCD_PAY_URL == null) ? 0 : PCD_PAY_URL.hashCode());
		result = prime * result + ((cst_id == null) ? 0 : cst_id.hashCode());
		result = prime * result + ((custKey == null) ? 0 : custKey.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((result_msg == null) ? 0 : result_msg.hashCode());
		result = prime * result + ((return_url == null) ? 0 : return_url.hashCode());
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
		PaypleMCertVO other = (PaypleMCertVO) obj;
		if (AuthKey == null) {
			if (other.AuthKey != null)
				return false;
		} else if (!AuthKey.equals(other.AuthKey))
			return false;
		if (PCD_PAY_HOST == null) {
			if (other.PCD_PAY_HOST != null)
				return false;
		} else if (!PCD_PAY_HOST.equals(other.PCD_PAY_HOST))
			return false;
		if (PCD_PAY_URL == null) {
			if (other.PCD_PAY_URL != null)
				return false;
		} else if (!PCD_PAY_URL.equals(other.PCD_PAY_URL))
			return false;
		if (cst_id == null) {
			if (other.cst_id != null)
				return false;
		} else if (!cst_id.equals(other.cst_id))
			return false;
		if (custKey == null) {
			if (other.custKey != null)
				return false;
		} else if (!custKey.equals(other.custKey))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (result_msg == null) {
			if (other.result_msg != null)
				return false;
		} else if (!result_msg.equals(other.result_msg))
			return false;
		if (return_url == null) {
			if (other.return_url != null)
				return false;
		} else if (!return_url.equals(other.return_url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaypleMCertVO [result=" + result + ", result_msg=" + result_msg + ", cst_id=" + cst_id + ", custKey="
				+ custKey + ", AuthKey=" + AuthKey + ", PCD_PAY_HOST=" + PCD_PAY_HOST + ", PCD_PAY_URL=" + PCD_PAY_URL
				+ ", return_url=" + return_url + "]";
	}
}
