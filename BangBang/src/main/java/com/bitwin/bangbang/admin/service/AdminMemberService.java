package com.bitwin.bangbang.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.Member;

@Service
public class AdminMemberService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<Member> getMemberList() {
		List<Member> member = null;

		dao = template.getMapper(MemberDao.class);

		member = dao.selectAll();

		return member;
	}

	public Member getMember(int uidx) {
		Member member = null;

		dao = template.getMapper(MemberDao.class);

		member = dao.selectByIdx(uidx);
		
		System.out.println(member);

		return member;
	}
}
