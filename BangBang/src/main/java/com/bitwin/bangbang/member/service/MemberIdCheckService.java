package com.bitwin.bangbang.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;

@Service
public class MemberIdCheckService {
	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public String checkId(String userId) {
		dao = template.getMapper(MemberDao.class);
		return dao.selectCountByUesrId(userId) > 0 ? "N" : "Y";
	}
}
