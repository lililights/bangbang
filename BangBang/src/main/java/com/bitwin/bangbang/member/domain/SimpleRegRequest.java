package com.bitwin.bangbang.member.domain;

public class SimpleRegRequest {
	private int uidx;
	private String photo;
	private String userid;
	private String username;
	private String birth;
	private String phonenum;
	private String email;
	private boolean enotify;
	private boolean mnotify;
	private boolean snotify;
	private boolean sns;
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "SimpleRegRequest [uidx=" + uidx + ", photo=" + photo + ", userid=" + userid + ", username=" + username
				+ ", birth=" + birth + ", phonenum=" + phonenum + ", email=" + email + ", enotify=" + enotify
				+ ", mnotify=" + mnotify + ", snotify=" + snotify + ", sns=" + sns + "]";
	}

}
