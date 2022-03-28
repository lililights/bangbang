package com.bitwin.bangbang.store.domain;

public class StoreLoginInfo {
	private int sidx;
	private String storeId;
	private String sname;
	private String photo;

	public int getSidx() {
		return sidx;
	}

	public void setSidx(int sidx) {
		this.sidx = sidx;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "StoreLoginInfo [sidx=" + sidx + ", storeId=" + storeId + ", sname=" + sname + ", photo=" + photo + "]";
	}

}
