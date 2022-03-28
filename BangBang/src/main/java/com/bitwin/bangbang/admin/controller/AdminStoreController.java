package com.bitwin.bangbang.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwin.bangbang.admin.service.AdminStoreService;
import com.bitwin.bangbang.store.domain.StoreEditRequest;
import com.bitwin.bangbang.store.domain.StoreRegRequest;

@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {
	@Autowired
	private AdminStoreService storeService;

	@GetMapping
	public String getStore(Model model) {
		model.addAttribute("store", storeService.selectAll());
		model.addAttribute("storeReq", storeService.selectEditRequest());
		return "admin/store/management";
	}
	// 가맹점 등록
	@GetMapping("/reg")
	public String getStoreRegForm() {
		return "admin/store/regform";
	}

	@PostMapping("/reg")
	public String postStoreReg(StoreRegRequest regRequest, Model model) {
		model.addAttribute("result", storeService.insertStore(regRequest));
		return "admin/store/regComplete";
	}
	
	// 가맹점 아이디 중복 체크
	@GetMapping("/reg/checkid")
	@ResponseBody
	public String checkStoreId(@RequestParam("storeId")String storeId) {
		return storeService.checkStoreId(storeId);
	}
	
	// 가맹점 정보 상세 보기
	@GetMapping("/{sname}")
	public String getStoreDetail(@PathVariable("sname") String sname, Model model) {
		// 가맹점 이름으로 가맹점 정보 가져오기.
		model.addAttribute("store", storeService.storeDetial(sname));
		return "admin/store/detail";
	}
	
	// 가맹점 정보 수정하기
	@GetMapping("/{sname}/edit")
	public String getEditStore(@PathVariable("sname") String sname, Model model) {
		model.addAttribute("store", storeService.storeDetial(sname));
		return "admin/store/editform";
	}
	
	@PostMapping("/{sname}/edit")
	public String postEditStore(@PathVariable("sname") String sname, Model model) {
		
		return "admin/store/editComplete";
	}
	
	@GetMapping("/{sridx}/req")
	public String getEditReqStore(@PathVariable("sridx") int sridx, Model model) {
		model.addAttribute("store", storeService.getEditRequest(sridx));
		return "admin/store/editReqForm";
	}
	@PostMapping("/{sridx}/req")
	public String postEditReqStore(@PathVariable("sridx") int sridx, StoreEditRequest editRequest, Model model) {
		model.addAttribute("result", storeService.acceptEditRequest(editRequest));
		return "admin/store/editReqComplete";
	}
	
}	
