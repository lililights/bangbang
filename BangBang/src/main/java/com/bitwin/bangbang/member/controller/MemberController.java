package com.bitwin.bangbang.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitwin.bangbang.exception.ChangePwInvalidException;
import com.bitwin.bangbang.exception.LoginInvalidException;
import com.bitwin.bangbang.member.domain.EditMember;
import com.bitwin.bangbang.member.domain.KakaoInfo;
import com.bitwin.bangbang.member.domain.LoginInfo;
import com.bitwin.bangbang.member.domain.MemberLoginRequest;
import com.bitwin.bangbang.member.domain.MemberRegRequest;
import com.bitwin.bangbang.member.domain.NaverInfo;
import com.bitwin.bangbang.member.domain.SearchPassword;
import com.bitwin.bangbang.member.domain.SimpleRegRequest;
import com.bitwin.bangbang.member.service.MemberChangePwService;
import com.bitwin.bangbang.member.service.MemberEditService;
import com.bitwin.bangbang.member.service.MemberEmailCheckService;
import com.bitwin.bangbang.member.service.MemberIdCheckService;
import com.bitwin.bangbang.member.service.MemberLoginService;
import com.bitwin.bangbang.member.service.MemberPwCheckService;
import com.bitwin.bangbang.member.service.MemberRegService;
import com.bitwin.bangbang.member.service.MemberService;
import com.bitwin.bangbang.member.service.SimpleLoginService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberLoginService loginService;

	@Autowired
	private MemberRegService regService;

	@Autowired
	private SimpleLoginService apiService;

	@Autowired
	private MemberEditService editService;

	@Autowired
	private MemberEmailCheckService checkEmailService;

	@Autowired
	private MemberIdCheckService checkIdService;

	@Autowired
	private MemberPwCheckService pwCheckService;

	@Autowired
	private MemberChangePwService changePwService;

	// ?????????
	@GetMapping("/login")
	public String getLogin(Model model) {
		KakaoInfo kakao = new KakaoInfo();
		NaverInfo naver = new NaverInfo();
		model.addAttribute("kakao", kakao);
		model.addAttribute("naver", naver);
		return "member/loginform";
	}
	@PostMapping("/login")
	public String postLogin(MemberLoginRequest loginRequest, HttpServletResponse res, HttpSession session)
			throws LoginInvalidException {

		return loginService.login(loginRequest, res, session);
	}

	@ExceptionHandler(LoginInvalidException.class)
	public String loginFail(LoginInvalidException e) {
		return "error/loginFail";
	}

	@GetMapping("/login/oauth/{snsname}")
	public String socialLogin(@PathVariable("snsname") String snsname, @RequestParam("code") String code,
			HttpSession session) {
		String page = "";

		String access_Token = apiService.getAccessToken(snsname, code);
		HashMap<String, Object> userInfo = apiService.getUserInfo(snsname, access_Token);
		// DB??? ?????? ??? ???????????? ??????
		String email = (String) userInfo.get("email");
		int countEmail = apiService.checkEmail(email);

		if (countEmail > 0) {
			// email ??? ?????? ?????? ????????????.
			// session ??? ????????? ?????? ??????
			session.setAttribute("loginInfo", apiService.getLoginInfo(email));
			session.setAttribute("access_Token", access_Token);
			session.setAttribute("loginType", snsname);
			page = "redirect:/main/mainpage";
		} else {
			// userInfo ?????? joinform ?????? ????????? ???????????? ??????.
			session.setAttribute("userInfo", userInfo);
			page = "redirect:/member/join/simple-reg";
		}

		return page;
	}
	
	// ????????????
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/mainpage";
		}

	// Kakao api ????????????
	@GetMapping("/logout/oauth/kakao")
	public String kakaoLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/mainpage";
	}
	// Id ??????
	@GetMapping("/search/id")
	public String getSearchId() {
		return "member/searchId";
	}
	@PostMapping("/search/id")
	public String postSearchId(@RequestParam("email") String email, Model model) {
		model.addAttribute("result", service.searchById(email));
		return "member/searchIdComplete";
	}
	
	// PW ??????
	@GetMapping("/search/pw")
	public String getSearchPw() {
		return "member/searchPw";
	}
	@PostMapping("/search/pw")
	public String postSearchPw(SearchPassword searchPW, Model model) {
		model.addAttribute("result", service.searchByPw(searchPW));
		return "member/searchPwComplete";
	}
	
	// ???????????? ?????????
	@GetMapping("/join")
	public String getJoin() {
		return "member/join";
	}

	// ?????? ????????????
	@GetMapping("/join/general")
	public String getGeneralMember() {
		return "member/joinform";
	}

	@PostMapping("/join/general")
	public String postGeneralMember(MemberRegRequest regRequest, Model model) {
		System.out.println("regRequest: " + regRequest);

		model.addAttribute("result", regService.insertMember(regRequest));
		return "member/regComplete";
	}

	// ?????? ?????? ??????
	@GetMapping("join/general/checkemail")
	@ResponseBody
	public String checkEmail(@RequestParam("email") String email) {
		return checkEmailService.checkEmail(email);
	}

	@GetMapping("/join/general/checkid")
	@ResponseBody
	public String checkId(@RequestParam("userid") String userId) {
		return checkIdService.checkId(userId);
	}

	@GetMapping("/mypage/edit/pw/checkpw")
	@ResponseBody
	public String checkPw(@RequestParam("currentpw") String currentPw, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String userid = loginInfo.getUserId();

		return pwCheckService.checkPw(userid, currentPw);
	}

	// ?????? ????????????
	@GetMapping("/join/simple-reg")
	public String getSimpleReg() {
		return "member/simplereg";
	}

	@PostMapping("/join/simple-reg")
	public String postSimpleReg(SimpleRegRequest regRequest, HttpServletRequest req, Model model) {

		model.addAttribute("result", regService.insertSimpleMember(regRequest, req));

		return "member/regComplete";
	}

	// ???????????????
	@GetMapping("/mypage")
	public String getMypage() {
		return "member/mypage/mypage";
	}

	// ??????????????? ???????????? ??????
	@GetMapping("/mypage/edit")
	public String getMemberEdit(HttpSession session, Model model) {
		// ?????? ???????????? ????????? session ?????? ????????????.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		int uidx = loginInfo.getUidx();
		model.addAttribute("member", editService.getMember(uidx));
		return "member/mypage/editform";
	}

	@PostMapping("/mypage/edit")
	public String postMemeberEdit(EditMember editMember, Model model, HttpServletRequest req)
			throws IllegalStateException, IOException {
		System.out.println("Controller" + editMember);

		model.addAttribute("result", editService.editMember(editMember, req));

		return "member/mypage/editComplete";
	}

	// ???????????? ??????
	@GetMapping("/mypage/edit/pw")
	public String getEditPw() {
		return "member/mypage/changepw";
	}

	@PostMapping("/mypage/edit/pw")
	public String changePw(@RequestParam("currentPw") String currentPw, @RequestParam("newPw1") String newPw,
			HttpSession session, Model model) throws ChangePwInvalidException {
		String page = "";
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String userid = loginInfo.getUserId();

		String check = pwCheckService.checkPw(userid, currentPw);
		if (check.equals("Y")) {
			model.addAttribute("result", changePwService.changePw(userid, newPw));
			session.invalidate();
			page = "member/mypage/changeComplete";
		} else {
			throw new ChangePwInvalidException("?????? ??????????????? ???????????? ????????????.");
		}

		return page;
	}

	@ExceptionHandler(ChangePwInvalidException.class)
	public String changeFail(ChangePwInvalidException e) {
		return "error/changeFail";
	}
}
