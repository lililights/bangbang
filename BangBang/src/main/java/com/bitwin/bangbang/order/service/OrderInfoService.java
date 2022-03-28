package com.bitwin.bangbang.order.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.OrderInfoAdmin;
import com.bitwin.bangbang.order.domain.OrderInfoMember;
import com.bitwin.bangbang.order.domain.OrderInfoStore;

@Service
public class OrderInfoService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 일반회원 권한으로 요청한 주문 상세보기
	public OrderInfoMember selectOrderInfoMember(int oidx) {
		dao = template.getMapper(OrderDao.class);

		// 주문 idx로 검색한 주문 상세보기 결과 객체로 반환
		OrderInfoMember orderInfo = dao.selectOrderInfoMember(oidx);

		// 주문 상세보기 결과에 구매 제품 리스트 첨부
		orderInfo.setOrderItemInfo(dao.selectOrderItemInfo(oidx));

		return orderInfo;
	}

	// 가맹점 권한으로 요청한 주문 상세보기
	public OrderInfoStore selectOrderInfoStore(int oidx) {
		dao = template.getMapper(OrderDao.class);

		// 주문 idx로 검색한 주문 상세보기 결과 객체로 반환
		OrderInfoStore orderInfo = dao.selectOrderInfoStore(oidx);

		// 주문 상세보기 결과에 구매 제품 리스트 첨부
		orderInfo.setOrderItemInfo(dao.selectOrderItemInfo(oidx));

		return orderInfo;
	}

	// 관리자 권한으로 요청한 주문 상세보기
	public OrderInfoAdmin selectOrderInfoAdmin(int oidx) {
		dao = template.getMapper(OrderDao.class);

		// 주문 idx로 검색한 주문 상세보기 결과 객체로 반환
		OrderInfoAdmin orderInfo = dao.selectOrderInfoAdmin(oidx);

		// 주문 상세보기 결과에 구매 제품 리스트 첨부
		orderInfo.setOrderItemInfo(dao.selectOrderItemInfo(oidx));

		return orderInfo;
	}

}