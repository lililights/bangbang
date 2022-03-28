package com.bitwin.bangbang.member.domain;

public class KakaoInfo {
	private String client_id = "a085f34768fc66402a5576852c5c8a96";
	private String redirect_uri = "http://localhost:8080/bangbang/member/login/oauth/kakao";
	private String logout_redirect_uri ="http://localhost:8080/bangbang/member/logout/oauth/kakao";
	
	public String getClient_id() {
		return client_id;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	public String getLogout_redirect_uri() {
		return logout_redirect_uri;
	}
	
	
} 
