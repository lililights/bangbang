package com.bitwin.bangbang.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.exception.LoginInvalidException;
import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.Member;
import com.bitwin.bangbang.member.domain.MemberLoginRequest;

@Service
public class MemberLoginService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public String login(MemberLoginRequest loginRequest, HttpServletResponse res, HttpSession session)
			throws LoginInvalidException {
		String viewName = null;

		Member member = null;

		dao = template.getMapper(MemberDao.class);

		member = dao.selectById(loginRequest.getUserid());

		if (member == null) {
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		} else if (!encoder.matches(loginRequest.getPassword(), member.getPassword())) {
			// 사용자가 입력한 비밀번호와 Member객체가 가지고 있는 비밀번호를 확인
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		}
		// session에 로그인 데이터를 저장한다.
		session.setAttribute("loginInfo", member.getLoginInfo());
		session.setAttribute("loginType", "general");
		
		
		// id 저장하기 체크 처리 : checked 상태 -> "on" -> 쿠키 저장
		if (loginRequest.getSaveid() != null && loginRequest.getSaveid().equals("on")) {

			Cookie c = new Cookie("saveId", loginRequest.getUserid());
			res.addCookie(c);
		}else if(loginRequest.getSaveid() == null) {
			// check 상태 -> "null" 쿠키 null
			Cookie c = new Cookie("saveId", null);
			res.addCookie(c);
		}
		
		if (loginRequest.getUrl().length() > 0) {
			viewName = "redirect:" + loginRequest.getUrl();
		} else {
			viewName = "redirect:/main/mainpage";
		}

		return viewName;
	}

}
