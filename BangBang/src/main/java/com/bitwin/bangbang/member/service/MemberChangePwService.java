package com.bitwin.bangbang.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.Member;
import com.bitwin.bangbang.member.domain.MemberPassword;

@Service
public class MemberChangePwService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public int changePw (String userid, String newPw) {
		int resultCnt = 0;
		MemberPassword memberPw = new MemberPassword();

		String password = bcrypt.encode(newPw);
		
		memberPw.setUserid(userid);
		memberPw.setNewPassword(password);
		
		dao = template.getMapper(MemberDao.class);
		
		resultCnt = dao.updatePassword(memberPw);
		
		
		
		return resultCnt;
	}
	
}
