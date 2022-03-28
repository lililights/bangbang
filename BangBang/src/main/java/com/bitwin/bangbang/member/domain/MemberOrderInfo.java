package com.bitwin.bangbang.member.domain;

public class MemberOrderInfo {
	private int uidx;
	private String username;
	private String phonenum;
	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "MemberOrderInfo [uidx=" + uidx + ", username=" + username + ", phonenum=" + phonenum + "]";
	}
	
	
}
