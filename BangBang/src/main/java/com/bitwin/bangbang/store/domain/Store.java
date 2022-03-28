package com.bitwin.bangbang.store.domain;

import org.springframework.web.multipart.MultipartFile;

public class Store {
	private int sidx;
	private String storeId;
	private String storePw;
	private String sname;
	private String sphone;
	private String address;
	private String oname;
	private String ophone;
	private String oemail;
	private String regnum;
	private String photo;
	private String date;

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

	public String getStorePw() {
		return storePw;
	}

	public void setStorePw(String storePw) {
		this.storePw = storePw;
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

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Store [sidx=" + sidx + ", storeId=" + storeId + ", storePw=" + storePw + ", sname=" + sname
				+ ", sphone=" + sphone + ", address=" + address + ", oname=" + oname + ", ophone=" + ophone
				+ ", oemail=" + oemail + ", regnum=" + regnum + ", photo=" + photo + ", date=" + date + "]";
	}

}
