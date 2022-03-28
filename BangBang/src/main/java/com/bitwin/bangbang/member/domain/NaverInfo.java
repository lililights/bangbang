package com.bitwin.bangbang.member.domain;

public class NaverInfo {
	private String client_id = "KDtI_xrcHtNm3MgYwc_T";
	private String client_secret = "pu3PnI2a4z";
	private String redirect_uri = "http://localhost:8080/bangbang/member/login/oauth/naver";
	
	
	public String getClient_id() {
		return client_id;
	}
	
	
	public String getClient_secret() {
		return client_secret;
	}


	public String getRedirect_uri() {
		return redirect_uri;
	}
	
	
} 
