package com.bitwin.bangbang.member.domain;

public class MemberPassword {
	private String userid;
	private String newPassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "MemberPassword [userid=" + userid + ", newPassword=" + newPassword + "]";
	}

}
