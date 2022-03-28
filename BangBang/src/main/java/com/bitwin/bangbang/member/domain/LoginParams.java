package com.bitwin.bangbang.member.domain;

public class LoginParams {
	private String userid;
	private String password;
	
	public LoginParams () {}

	public LoginParams(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
