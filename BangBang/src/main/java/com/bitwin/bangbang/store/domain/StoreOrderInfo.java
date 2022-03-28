package com.bitwin.bangbang.store.domain;

public class StoreOrderInfo {
	private int sidx;
	private String sname;
	private String sphone;
	private String address;

	public int getSidx() {
		return sidx;
	}

	public void setSidx(int sidx) {
		this.sidx = sidx;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StoreOrderInfo [sidx=" + sidx + ", sname=" + sname + ", sphone=" + sphone + ", address=" + address
				+ "]";
	}

}
