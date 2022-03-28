package com.bitwin.bangbang.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.Member;
import com.bitwin.bangbang.member.domain.MemberPassword;

@Service
public class MemberPwCheckService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String checkPw(String userid, String currentPw) {
		Member member = null;
		
		dao = template.getMapper(MemberDao.class);
		
		member = dao.selectById(userid);
		
		if(!encoder.matches(currentPw, member.getPassword())) {
			return "N";
		}
		return "Y";
		
	}
}
