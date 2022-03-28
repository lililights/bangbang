package com.bitwin.bangbang.member.domain;

public class Member {

	private int uidx;
	private String userid;
	private String password;
	private String username;
	private String birth;
	private String phonenum;
	private String email;
	private boolean enotify;
	private boolean mnotify;
	private boolean snotify;
	private String photo;
	private String regdate;
	private boolean sns;

	public Member(int uidx, String userid, String password, String username, String birth, String phonenum, String email,
			boolean enotify, boolean mnotify, boolean snotify, String photo, String regdate, boolean sns) {
		this.uidx = uidx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.birth = birth;
		this.phonenum = phonenum;
		this.email = email;
		this.enotify = enotify;
		this.mnotify = mnotify;
		this.snotify = snotify;
		this.photo = photo;
		this.regdate = regdate;
		this.sns=sns;
	}

	public int getUidx() {
		return uidx;
	}

	public void setUidx(int uidx) {
		this.uidx = uidx;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnotify() {
		return enotify;
	}

	public void setEnotify(boolean enotify) {
		this.enotify = enotify;
	}

	public boolean isMnotify() {
		return mnotify;
	}

	public void setMnotify(boolean mnotify) {
		this.mnotify = mnotify;
	}

	public boolean isSnotify() {
		return snotify;
	}

	public void setSnotify(boolean snotify) {
		this.snotify = snotify;
	}
	

	public boolean isSns() {
		return sns;
	}

	public void setSns(boolean sns) {
		this.sns = sns;
	}

	@Override
	public String toString() {
		return "Member [uidx=" + uidx + ", userid=" + userid + ", password=" + password + ", username=" + username
				+ ", birth=" + birth + ", phonenum=" + phonenum + ", email=" + email + ", enotify=" + enotify
				+ ", mnotify=" + mnotify + ", snotify=" + snotify + ", photo=" + photo + ", regdate=" + regdate
				+ ", sns=" + sns + "]";
	}

	public LoginInfo getLoginInfo() {
		return new LoginInfo(uidx, userid, username, photo, sns);
	}

}