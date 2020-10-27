package com.baobab.m.vo;

public class OwnerInfoVO {
	private CPUseVO cpUser;
	private UserAllVO user;
	public OwnerInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OwnerInfoVO(CPUseVO cpUser, UserAllVO user) {
		super();
		this.cpUser = cpUser;
		this.user = user;
	}
	public CPUseVO getCpUser() {
		return cpUser;
	}
	public void setCpUser(CPUseVO cpUser) {
		this.cpUser = cpUser;
	}
	public UserAllVO getUser() {
		return user;
	}
	public void setUser(UserAllVO user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpUser == null) ? 0 : cpUser.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		OwnerInfoVO other = (OwnerInfoVO) obj;
		if (cpUser == null) {
			if (other.cpUser != null)
				return false;
		} else if (!cpUser.equals(other.cpUser))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OwnerInfoVO [cpUser=" + cpUser + ", user=" + user + "]";
	}
}
