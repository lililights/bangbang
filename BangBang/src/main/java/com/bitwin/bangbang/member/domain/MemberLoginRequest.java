package com.bitwin.bangbang.member.domain;

public class MemberLoginRequest {

	private String url;
	private String userid;
	private String password;
	private String saveid;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getSaveid() {
		return saveid;
	}

	public void setSaveid(String saveid) {
		this.saveid = saveid;
	}

	@Override
	public String toString() {
		return "MemberLoginRequest [url=" + url + ", userid=" + userid + ", password=" + password + ", saveid=" + saveid + "]";
	}
	
	public LoginParams getLoginParams() {
		return new LoginParams(userid, password);
	}
	
	
	
	
	
	
	

}
