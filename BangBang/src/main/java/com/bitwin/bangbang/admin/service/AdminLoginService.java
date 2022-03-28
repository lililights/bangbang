package com.bitwin.bangbang.admin.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.admin.dao.AdminDao;
import com.bitwin.bangbang.admin.domain.Admin;
import com.bitwin.bangbang.exception.LoginInvalidException;

@Service
public class AdminLoginService {
	
	private AdminDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public String login(Admin loginReq, HttpServletResponse res, HttpSession session) throws LoginInvalidException {
		String viewPage = "";
		
		Admin admin = null;
		
		dao = template.getMapper(AdminDao.class);
		
		admin = dao.selectById(loginReq.getAid());
		
		// 관리자 비밀번호 암호화 필요 ! DB에서도 암호화 필요 !
		
		if(admin == null) {
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		}else if(!loginReq.getApw().equals(admin.getApw())) {
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		}
		
		session.setAttribute("adminInfo", admin.getAid());
		
		viewPage = "redirect:/admin";
		
		return viewPage;
	}
	
	
}
