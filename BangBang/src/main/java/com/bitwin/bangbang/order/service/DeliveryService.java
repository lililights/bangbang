package com.bitwin.bangbang.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.DeliveryList;
import com.bitwin.bangbang.order.domain.DeliveryRequest;

@Service
public class DeliveryService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 관리자용 택배 / 퀵 배송관리 리스트
	public List<DeliveryList> selectDeliveryList() {
		dao = template.getMapper(OrderDao.class);

		return dao.selectDeliveryList();
	}

	// 관리자용 택배 / 퀵 배송 요청
	public int deliveryRequest(@RequestBody List<DeliveryRequest> deliveryRequest) {
		dao = template.getMapper(OrderDao.class);

		return dao.deliveryRequest(deliveryRequest);
	}
	
	// 주문 번호로 택배/퀵 배송 조회
	public String deliveryTracking(int oidx) {
		dao = template.getMapper(OrderDao.class);
		
		return dao.deliveryTracking(oidx);
	}

}
