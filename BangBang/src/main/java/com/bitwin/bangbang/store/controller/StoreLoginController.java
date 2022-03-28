package com.bitwin.bangbang.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitwin.bangbang.exception.LoginInvalidException;
import com.bitwin.bangbang.store.domain.StoreLoginRequest;
import com.bitwin.bangbang.store.service.StoreService;

@Controller
@RequestMapping("/")
public class StoreLoginController {
	@Autowired
	private StoreService service;

	@GetMapping("/login/store")
	public String getStoreLogin() {
		return "store/loginform";
	}

	@PostMapping("/login/store")
	public String postStoreLogin(StoreLoginRequest loginReq, HttpSession session) throws LoginInvalidException {
		// login service
		return service.storeLogin(loginReq, session);
	}

	@ExceptionHandler(LoginInvalidException.class)
	public String loginFail(LoginInvalidException e) {
		return "error/loginFail";
	}

	// 로그아웃
	@GetMapping("/logout/store")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/mainpage";
	}
}
