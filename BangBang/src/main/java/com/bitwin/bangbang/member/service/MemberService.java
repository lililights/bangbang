package com.bitwin.bangbang.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.SearchPassword;

@Service
public class MemberService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private RamdomPassword ramdomPw;
	@Autowired
	private MailSenderService mailSender;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	public int searchById(String email) {
		int resultCnt =0;
		
		dao = template.getMapper(MemberDao.class);
		
		if(dao.selectCountByEmail(email) > 0) {
			// 메일로 회원의 아이디 전송
			String userid = dao.searchId(email);
			resultCnt = mailSender.sendId(email, userid);
		}
		
		return resultCnt;
	}

	public int searchByPw(SearchPassword searchPw) {
		int resultCnt = 0;
		dao = template.getMapper(MemberDao.class);
		if(dao.selectCountByEmailUserId(searchPw) > 0) {
			String password = ramdomPw.getRamdomPassword(8);
			resultCnt = mailSender.sendPw(searchPw.getEmail(), password);
			String bpw = bcrypt.encode(password);
			searchPw.setBpw(bpw);
			dao.updatePassword2(searchPw);
		}
		
		return resultCnt;
	}
}
