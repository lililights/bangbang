package com.bitwin.bangbang.store.domain;

public class StoreLoginRequest {
	private String sidx;
	private String storeId;
	private String storePw;
	private String saveId;
	
	
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
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
	public String getSaveId() {
		return saveId;
	}
	public void setSaveId(String saveId) {
		this.saveId = saveId;
	}
	@Override
	public String toString() {
		return "StoreLoginRequest [sidx=" + sidx + ", storeId=" + storeId + ", storePw=" + storePw + ", saveId="
				+ saveId + "]";
	}
	
}
