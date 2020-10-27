package com.baobab.m.vo;

public class ImportVO {
	private String code;
	private String message;
	private ImportResponseVO response;
	public ImportVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImportVO(String code, String message, ImportResponseVO response) {
		super();
		this.code = code;
		this.message = message;
		this.response = response;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ImportResponseVO getResponse() {
		return response;
	}
	public void setResponse(ImportResponseVO response) {
		this.response = response;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
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
		ImportVO other = (ImportVO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImportVO [code=" + code + ", message=" + message + ", response=" + response + "]";
	}
}
