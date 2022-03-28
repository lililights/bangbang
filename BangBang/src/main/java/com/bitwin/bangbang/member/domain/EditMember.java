package com.bitwin.bangbang.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class EditMember {
	private String userid;
	private String phonenum;
	private String email;
	private boolean enotify;
	private boolean mnotify;
	private boolean snotify;
	private MultipartFile photo;
	private String photoName;
	private String oldPhoto;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
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
	
	
	public String getOldPhoto() {
		return oldPhoto;
	}

	public void setOldPhoto(String oldPhoto) {
		this.oldPhoto = oldPhoto;
	}

	@Override
	public String toString() {
		return "EditMember [userid=" + userid + ", phonenum=" + phonenum + ", email=" + email + ", enotify=" + enotify
				+ ", mnotify=" + mnotify + ", snotify=" + snotify + ", photo=" + photo + ", photoName=" + photoName
				+ ", oldPhoto=" + oldPhoto + "]";
	}

	

}
