package com.baobab.m.vo;

import java.util.Date;

public class UserAllVO {
	private String email;
	private String user_password;
	private String userName;
	private String phon_num;
	private String phone_corp;
	private String div_code;
	private String birth;
	private int gender;
	private int nation;
	private String push_agree;
	private String email_agree;
	private String sms_agree;
	private int point;
	private Date join_date;
	private String nickName;
	private String profileImg;
	public UserAllVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAllVO(String email, String user_password, String userName, String phon_num, String phone_corp,
			String div_code, String birth, int gender, int nation, String push_agree, String email_agree,
			String sms_agree, int point, Date join_date, String nickName, String profileImg) {
		super();
		this.email = email;
		this.user_password = user_password;
		this.userName = userName;
		this.phon_num = phon_num;
		this.phone_corp = phone_corp;
		this.div_code = div_code;
		this.birth = birth;
		this.gender = gender;
		this.nation = nation;
		this.push_agree = push_agree;
		this.email_agree = email_agree;
		this.sms_agree = sms_agree;
		this.point = point;
		this.join_date = join_date;
		this.nickName = nickName;
		this.profileImg = profileImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhon_num() {
		return phon_num;
	}
	public void setPhon_num(String phon_num) {
		this.phon_num = phon_num;
	}
	public String getPhone_corp() {
		return phone_corp;
	}
	public void setPhone_corp(String phone_corp) {
		this.phone_corp = phone_corp;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getNation() {
		return nation;
	}
	public void setNation(int nation) {
		this.nation = nation;
	}
	public String getPush_agree() {
		return push_agree;
	}
	public void setPush_agree(String push_agree) {
		this.push_agree = push_agree;
	}
	public String getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(String email_agree) {
		this.email_agree = email_agree;
	}
	public String getSms_agree() {
		return sms_agree;
	}
	public void setSms_agree(String sms_agree) {
		this.sms_agree = sms_agree;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email_agree == null) ? 0 : email_agree.hashCode());
		result = prime * result + gender;
		result = prime * result + ((join_date == null) ? 0 : join_date.hashCode());
		result = prime * result + nation;
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((phon_num == null) ? 0 : phon_num.hashCode());
		result = prime * result + ((phone_corp == null) ? 0 : phone_corp.hashCode());
		result = prime * result + point;
		result = prime * result + ((profileImg == null) ? 0 : profileImg.hashCode());
		result = prime * result + ((push_agree == null) ? 0 : push_agree.hashCode());
		result = prime * result + ((sms_agree == null) ? 0 : sms_agree.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
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
		UserAllVO other = (UserAllVO) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (div_code == null) {
			if (other.div_code != null)
				return false;
		} else if (!div_code.equals(other.div_code))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_agree == null) {
			if (other.email_agree != null)
				return false;
		} else if (!email_agree.equals(other.email_agree))
			return false;
		if (gender != other.gender)
			return false;
		if (join_date == null) {
			if (other.join_date != null)
				return false;
		} else if (!join_date.equals(other.join_date))
			return false;
		if (nation != other.nation)
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (phon_num == null) {
			if (other.phon_num != null)
				return false;
		} else if (!phon_num.equals(other.phon_num))
			return false;
		if (phone_corp == null) {
			if (other.phone_corp != null)
				return false;
		} else if (!phone_corp.equals(other.phone_corp))
			return false;
		if (point != other.point)
			return false;
		if (profileImg == null) {
			if (other.profileImg != null)
				return false;
		} else if (!profileImg.equals(other.profileImg))
			return false;
		if (push_agree == null) {
			if (other.push_agree != null)
				return false;
		} else if (!push_agree.equals(other.push_agree))
			return false;
		if (sms_agree == null) {
			if (other.sms_agree != null)
				return false;
		} else if (!sms_agree.equals(other.sms_agree))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserAllVO [email=" + email + ", user_password=" + user_password + ", userName=" + userName
				+ ", phon_num=" + phon_num + ", phone_corp=" + phone_corp + ", div_code=" + div_code + ", birth="
				+ birth + ", gender=" + gender + ", nation=" + nation + ", push_agree=" + push_agree + ", email_agree="
				+ email_agree + ", sms_agree=" + sms_agree + ", point=" + point + ", join_date=" + join_date
				+ ", nickName=" + nickName + ", profileImg=" + profileImg + "]";
	}
}
