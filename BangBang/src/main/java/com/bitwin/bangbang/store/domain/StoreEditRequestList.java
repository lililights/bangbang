package com.bitwin.bangbang.store.domain;

public class StoreEditRequestList {
	private int sridx;
	private String  sname;
	private String storeId;
	public int getSridx() {
		return sridx;
	}
	public void setSridx(int sridx) {
		this.sridx = sridx;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "StoreEditRequestList [sridx=" + sridx + ", sname=" + sname + ", storeId=" + storeId + ", getSridx()="
				+ getSridx() + ", getSname()=" + getSname() + ", getStoreId()=" + getStoreId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
