package com.baobab.m.vo;

public class MeCertVO {
	private String certNum;
	private String date;
	private String CI;
	private String phoneNo;
	private String phoneCorp;
	private String birthDay;
	private String gender;
	private String nation;
	private String name;
	private String result;
	private String certMet;
	private String ip;
	private String M_name;
	private String M_birthDay;
	private String M_Gender;
	private String M_nation;
	private String plusInfo;
	private String DI;
	public MeCertVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeCertVO(String certNum, String date, String cI, String phoneNo, String phoneCorp, String birthDay,
			String gender, String nation, String name, String result, String certMet, String ip, String m_name,
			String m_birthDay, String m_Gender, String m_nation, String plusInfo, String dI) {
		super();
		this.certNum = certNum;
		this.date = date;
		CI = cI;
		this.phoneNo = phoneNo;
		this.phoneCorp = phoneCorp;
		this.birthDay = birthDay;
		this.gender = gender;
		this.nation = nation;
		this.name = name;
		this.result = result;
		this.certMet = certMet;
		this.ip = ip;
		M_name = m_name;
		M_birthDay = m_birthDay;
		M_Gender = m_Gender;
		M_nation = m_nation;
		this.plusInfo = plusInfo;
		DI = dI;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		CI = cI;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPhoneCorp() {
		return phoneCorp;
	}
	public void setPhoneCorp(String phoneCorp) {
		this.phoneCorp = phoneCorp;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCertMet() {
		return certMet;
	}
	public void setCertMet(String certMet) {
		this.certMet = certMet;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getM_name() {
		return M_name;
	}
	public void setM_name(String m_name) {
		M_name = m_name;
	}
	public String getM_birthDay() {
		return M_birthDay;
	}
	public void setM_birthDay(String m_birthDay) {
		M_birthDay = m_birthDay;
	}
	public String getM_Gender() {
		return M_Gender;
	}
	public void setM_Gender(String m_Gender) {
		M_Gender = m_Gender;
	}
	public String getM_nation() {
		return M_nation;
	}
	public void setM_nation(String m_nation) {
		M_nation = m_nation;
	}
	public String getPlusInfo() {
		return plusInfo;
	}
	public void setPlusInfo(String plusInfo) {
		this.plusInfo = plusInfo;
	}
	public String getDI() {
		return DI;
	}
	public void setDI(String dI) {
		DI = dI;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CI == null) ? 0 : CI.hashCode());
		result = prime * result + ((DI == null) ? 0 : DI.hashCode());
		result = prime * result + ((M_Gender == null) ? 0 : M_Gender.hashCode());
		result = prime * result + ((M_birthDay == null) ? 0 : M_birthDay.hashCode());
		result = prime * result + ((M_name == null) ? 0 : M_name.hashCode());
		result = prime * result + ((M_nation == null) ? 0 : M_nation.hashCode());
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((certMet == null) ? 0 : certMet.hashCode());
		result = prime * result + ((certNum == null) ? 0 : certNum.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + ((phoneCorp == null) ? 0 : phoneCorp.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((plusInfo == null) ? 0 : plusInfo.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		MeCertVO other = (MeCertVO) obj;
		if (CI == null) {
			if (other.CI != null)
				return false;
		} else if (!CI.equals(other.CI))
			return false;
		if (DI == null) {
			if (other.DI != null)
				return false;
		} else if (!DI.equals(other.DI))
			return false;
		if (M_Gender == null) {
			if (other.M_Gender != null)
				return false;
		} else if (!M_Gender.equals(other.M_Gender))
			return false;
		if (M_birthDay == null) {
			if (other.M_birthDay != null)
				return false;
		} else if (!M_birthDay.equals(other.M_birthDay))
			return false;
		if (M_name == null) {
			if (other.M_name != null)
				return false;
		} else if (!M_name.equals(other.M_name))
			return false;
		if (M_nation == null) {
			if (other.M_nation != null)
				return false;
		} else if (!M_nation.equals(other.M_nation))
			return false;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (certMet == null) {
			if (other.certMet != null)
				return false;
		} else if (!certMet.equals(other.certMet))
			return false;
		if (certNum == null) {
			if (other.certNum != null)
				return false;
		} else if (!certNum.equals(other.certNum))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (phoneCorp == null) {
			if (other.phoneCorp != null)
				return false;
		} else if (!phoneCorp.equals(other.phoneCorp))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (plusInfo == null) {
			if (other.plusInfo != null)
				return false;
		} else if (!plusInfo.equals(other.plusInfo))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MeCertVO [certNum=" + certNum + ", date=" + date + ", CI=" + CI + ", phoneNo=" + phoneNo
				+ ", phoneCorp=" + phoneCorp + ", birthDay=" + birthDay + ", gender=" + gender + ", nation=" + nation
				+ ", name=" + name + ", result=" + result + ", certMet=" + certMet + ", ip=" + ip + ", M_name=" + M_name
				+ ", M_birthDay=" + M_birthDay + ", M_Gender=" + M_Gender + ", M_nation=" + M_nation + ", plusInfo="
				+ plusInfo + ", DI=" + DI + "]";
	}
}
