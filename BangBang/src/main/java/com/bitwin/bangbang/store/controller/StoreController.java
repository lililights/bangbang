package com.bitwin.bangbang.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwin.bangbang.exception.LoginInvalidException;
import com.bitwin.bangbang.member.domain.LoginInfo;
import com.bitwin.bangbang.store.domain.StoreEditRequest;
import com.bitwin.bangbang.store.domain.StoreLoginInfo;
import com.bitwin.bangbang.store.domain.StoreLoginRequest;
import com.bitwin.bangbang.store.domain.StorePassword;
import com.bitwin.bangbang.store.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService service;
	
	@GetMapping
	public String getStore() {
		return "store/store";
	}
	
	@GetMapping("/mypage")
	public String getStoreMypage(HttpSession session, Model model) {
		model.addAttribute("store", service.getStoreInfo(session));
		return "store/mypage";
	}
	
	@GetMapping("/mypage/edit")
	public String getStoreEdit (HttpSession session, Model model) {
		model.addAttribute("store", service.getStoreInfo(session));
		return "store/editform";
	}
	@PostMapping("/mypage/edit")
	public String postStoreEdit (StoreEditRequest editRequest, Model model, HttpSession session) {
		model.addAttribute("result", service.storeEditRequest(editRequest, session));
		return "store/editRequest";
	}
	
	// 가맹점 비밀번호 변경
	@GetMapping("/mypage/edit/pw")
	public String getChangePw() {
		return "store/changePw";
	}
	@PostMapping("/mypage/edit/pw")
	public String postChangePw(
			@RequestParam("currentPw") String currentPw, HttpSession session,
			StorePassword storePw, Model model) {
		StoreLoginInfo storeInfo = (StoreLoginInfo) session.getAttribute("storeInfo");
		storePw.setStoreId(storeInfo.getStoreId());
		int resultCnt = service.changePw(storePw, currentPw);
		model.addAttribute("result", resultCnt);
		if(resultCnt > 0) {
			session.invalidate();
		}
		return "store/changeComplete";
	}
	@GetMapping("/mypage/edit/pw/checkpw")
	@ResponseBody
	public String checkPw(@RequestParam("currentpw") String currentPw, HttpSession session) {
		StoreLoginInfo storeInfo = (StoreLoginInfo) session.getAttribute("storeInfo");
		String storeid = storeInfo.getStoreId();

		return service.checkPw(storeid, currentPw);
	}
	@GetMapping("/fee")
	public String getStoreFee () {
		return "store/fee";
	}
}
