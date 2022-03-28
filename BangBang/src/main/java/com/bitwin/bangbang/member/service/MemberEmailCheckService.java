package com.bitwin.bangbang.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;

@Service
public class MemberEmailCheckService {
	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public String checkEmail(String email) {
		dao = template.getMapper(MemberDao.class);
		return dao.selectCountByEmail(email) > 0 ? "N" : "Y";
	}
}
