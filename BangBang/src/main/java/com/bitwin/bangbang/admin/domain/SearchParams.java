package com.bitwin.bangbang.admin.domain;

public class SearchParams {

	private int p;
	private int index;
	private int count;
	private String searchType;
	private String keyword;

	public SearchParams() {
	}

	public SearchParams(int index, int count, String searchType, String keyword) {
		this.index = index;
		this.count = count;
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "SearchParams [p=" + p + ", index=" + index + ", count=" + count + ", searchType=" + searchType
				+ ", keyword=" + keyword + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
