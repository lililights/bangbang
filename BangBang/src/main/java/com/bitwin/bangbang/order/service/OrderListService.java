package com.bitwin.bangbang.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.OrderListAdmin;
import com.bitwin.bangbang.order.domain.OrderListMember;
import com.bitwin.bangbang.order.domain.OrderListOpt;
import com.bitwin.bangbang.order.domain.OrderListOptAdmin;
import com.bitwin.bangbang.order.domain.OrderListOptMember;
import com.bitwin.bangbang.order.domain.OrderListOptStore;
import com.bitwin.bangbang.order.domain.OrderListStore;

@Service
public class OrderListService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 일반회원 권한으로 요청한 주문 목록
	public List<OrderListMember> selectOrderList(OrderListOptMember listOpt) {
		dao = template.getMapper(OrderDao.class);

		// 검색 옵션 sql문으로 효율적으로 조회 가능한 값으로 변경하여 결과 리스트로 반환
		List<OrderListMember> list = dao.selectOrderListMember((OrderListOptMember) reformOptStatus(listOpt));

		// 주문 상품 개수 javascript 처리 없이 바로 출력할 수 있도록 값 변경
		for (int i = 0; i < list.size(); i++) {
			String restQty = list.get(i).getRestCount();
			list.get(i).setRestCount(restQty.equals("0") ? "" : " 외 " + restQty + "건");
		}

		return list;
	}

	// 가맹점 권한으로 요청한 주문 목록
	public List<OrderListStore> selectOrderList(OrderListOptStore listOpt) {
		dao = template.getMapper(OrderDao.class);

		// 검색 옵션 sql문으로 효율적으로 조회 가능한 값으로 변경하여 결과 리스트로 반환
		List<OrderListStore> list = dao.selectOrderListStore((OrderListOptStore) reformOptStatus(listOpt));

		// 주문 상품 개수 javascript 처리 없이 바로 출력할 수 있도록 값 변경
		for (int i = 0; i < list.size(); i++) {
			String restQty = list.get(i).getRestCount();
			list.get(i).setRestCount(restQty.equals("0") ? "" : " 외 " + restQty + "건");
		}

		return list;
	}

	// 관리자 권한으로 요청한 주문 목록
	public List<OrderListAdmin> selectOrderList(OrderListOptAdmin listOpt) {
		dao = template.getMapper(OrderDao.class);

		List<OrderListAdmin> list = dao.selectOrderListAdmin((OrderListOptAdmin) reformOptStatus(listOpt));

		// 검색 옵션 sql문으로 효율적으로 조회 가능한 값으로 변경하여 결과 리스트로 반환
		return list;
	}

	// 검색 옵션 sql문으로 효율적으로 조회 가능한 값으로 변경하여 결과 리스트로 반환
	private OrderListOpt reformOptStatus(OrderListOpt listOpt) {

		switch (listOpt.getOptStatus()) {

		case "accepted":
			listOpt.setOptStatus("주문완료");
			break;
		case "delivering":
			listOpt.setOptStatus("배송진행중");
			break;
		case "pickupPro":
			listOpt.setOptStatus("픽업가능");
			break;
		case "pickupCom":
			listOpt.setOptStatus("픽업완료");
			break;
		}

		return listOpt;
	}

}