package com.bitwin.bangbang.store.domain;

public class StorePassword {
	private String storeId;
	private String newPw1;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getNewPw1() {
		return newPw1;
	}

	public void setNewPw1(String newPw1) {
		this.newPw1 = newPw1;
	}

	@Override
	public String toString() {
		return "StorePassword [storeId=" + storeId + ", newPw1=" + newPw1 + "]";
	}

}
