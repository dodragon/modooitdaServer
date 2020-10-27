package com.baobab.m.vo;

public class SafeCpVO {
	private int safeNo;
	private String sido;
	private String sigungu;
	private String cpName;
	private String addr;
	private String addrDetail;
	private String kind;
	private String type;
	private String tel;
	private String safetyDiv;
	private String postCode;
	private double latitude;
	private double longitude;
	
	public SafeCpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SafeCpVO(int safeNo, String sido, String sigungu, String cpName, String addr, String addrDetail, String kind,
			String type, String tel, String safetyDiv, String postCode, double latitude, double longitude) {
		super();
		this.safeNo = safeNo;
		this.sido = sido;
		this.sigungu = sigungu;
		this.cpName = cpName;
		this.addr = addr;
		this.addrDetail = addrDetail;
		this.kind = kind;
		this.type = type;
		this.tel = tel;
		this.safetyDiv = safetyDiv;
		this.postCode = postCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public int getSafeNo() {
		return safeNo;
	}
	public void setSafeNo(int safeNo) {
		this.safeNo = safeNo;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSafetyDiv() {
		return safetyDiv;
	}
	public void setSafetyDiv(String safetyDiv) {
		this.safetyDiv = safetyDiv;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((addrDetail == null) ? 0 : addrDetail.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + safeNo;
		result = prime * result + ((safetyDiv == null) ? 0 : safetyDiv.hashCode());
		result = prime * result + ((sido == null) ? 0 : sido.hashCode());
		result = prime * result + ((sigungu == null) ? 0 : sigungu.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SafeCpVO other = (SafeCpVO) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (addrDetail == null) {
			if (other.addrDetail != null)
				return false;
		} else if (!addrDetail.equals(other.addrDetail))
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (safeNo != other.safeNo)
			return false;
		if (safetyDiv == null) {
			if (other.safetyDiv != null)
				return false;
		} else if (!safetyDiv.equals(other.safetyDiv))
			return false;
		if (sido == null) {
			if (other.sido != null)
				return false;
		} else if (!sido.equals(other.sido))
			return false;
		if (sigungu == null) {
			if (other.sigungu != null)
				return false;
		} else if (!sigungu.equals(other.sigungu))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SafeCpVO [safeNo=" + safeNo + ", sido=" + sido + ", sigungu=" + sigungu + ", cpName=" + cpName
				+ ", addr=" + addr + ", addrDetail=" + addrDetail + ", kind=" + kind + ", type=" + type + ", tel=" + tel
				+ ", safetyDiv=" + safetyDiv + ", postCode=" + postCode + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
}
