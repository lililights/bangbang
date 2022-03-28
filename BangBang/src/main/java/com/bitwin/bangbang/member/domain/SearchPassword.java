package com.bitwin.bangbang.member.domain;

public class SearchPassword {
	private String email;
	private String userid;
	private String bpw;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	@Override
	public String toString() {
		return "SearchPassword [email=" + email + ", userid=" + userid + ", bpw=" + bpw + "]";
	}


	
}
