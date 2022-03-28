package com.bitwin.bangbang.member.domain;

public class LoginInfo {

	private int uidx;
	private String userId;
	private String username;
	private String photo;
	private boolean sns;

	public LoginInfo(int uidx, String userId, String username, String photo, boolean sns) {
		this.uidx = uidx;
		this.userId = userId;
		this.username = username;
		this.photo = photo;
		this.sns = sns;
	}

	public int getUidx() {
		return uidx;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPhoto() {
		return photo;
	}

	public boolean isSns() {
		return sns;
	}

	@Override
	public String toString() {
		return "LoginInfo [uidx=" + uidx + ", userId=" + userId + ", username=" + username + ", photo=" + photo
				+ ", sns=" + sns + "]";
	}
}
