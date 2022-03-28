package com.bitwin.bangbang.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitwin.bangbang.admin.service.AdminMemberService;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private AdminMemberService memberService;
	
	@GetMapping
	public String getMember(Model model) {
//		// List 에 Member 객채를 담아서 보낸다.
		model.addAttribute("member", memberService.getMemberList());
		return "admin/member/management";
	}
	
	@GetMapping("/{uidx}")
	public String getMember(@PathVariable("uidx")int uidx, Model model) {
		model.addAttribute("member", memberService.getMember(uidx));
		return "admin/member/detail";
	}
}
