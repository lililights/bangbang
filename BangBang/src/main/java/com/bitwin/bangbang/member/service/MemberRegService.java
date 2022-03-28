package com.bitwin.bangbang.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.MemberRegRequest;
import com.bitwin.bangbang.member.domain.SimpleRegRequest;

@Service
public class MemberRegService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	@Autowired
	private MailSenderService mailSender;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public int insertMember(MemberRegRequest regRequest) {
		int resultCnt = 0;

		regRequest.setPhotoName("default.jpg");

		// 비밀번호 암호화 필요
		String bPw = bcrypt.encode(regRequest.getPassword());
		// 암호화 된 비밀번호를 저장
		regRequest.setPassword(bPw);

		dao = template.getMapper(MemberDao.class);

		resultCnt = dao.insertMember(regRequest);
		if (mailSender.send(regRequest.getEmail(), regRequest.getUsername()) > 0) {
			System.out.println("메일발송 완료");
		} else {
			System.out.println("메일 발송 실패!");
		}

		return resultCnt;
	}

	public int insertSimpleMember(SimpleRegRequest regRequest, HttpServletRequest req) {
		int resultCnt = 0;

		dao = template.getMapper(MemberDao.class);

		resultCnt = dao.insertSimpleMember(regRequest);
		if (mailSender.send(regRequest.getEmail(), regRequest.getUsername()) > 0) {
			System.out.println("메일전송 성공");
		} else {
			System.out.println("메일전송 실패");
		}

		return resultCnt;
	}
}
