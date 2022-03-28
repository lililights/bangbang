package com.bitwin.bangbang.admin.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.admin.dao.WishDAO;

@Service
public class WishService {
	
	private WishDAO dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void wishUpdate(Map<String, Object> map) {
		dao = template.getMapper(WishDAO.class);
		
		int result = dao.check(map);
		
		if(result == 0) {
			dao.wishUpdate(map);
		} else {
			dao.wishDelete(map);
		}
		
	}
	
	public int wishCnt(int iidx) {
		dao = template.getMapper(WishDAO.class);
		
		return dao.count(iidx);
	}
	
	
}
