package com.bitwin.bangbang.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.MemberPoint;
import com.bitwin.bangbang.order.domain.OrderItem;
import com.bitwin.bangbang.order.domain.OrderReqMemberInfo;
import com.bitwin.bangbang.order.domain.OrderReqStoreInfo;
import com.bitwin.bangbang.order.domain.OrderRequest;
import com.bitwin.bangbang.order.domain.PaymentInfo;

@Service
public class OrderRequestService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 주문서에 출력할 회원정보
	public OrderReqMemberInfo getOrderReqMemberInfo(int uidx) {
		dao = template.getMapper(OrderDao.class);

		OrderReqMemberInfo orderReqMemberInfo = dao.getOrderReqMemberInfo(uidx);
		
		// 회원의 적립 포인트 불러와 저장
		MemberPoint memberPoint = dao.getMemberPoint(uidx);
		orderReqMemberInfo.setPoint(memberPoint.getCount() == 0 ? 0 : memberPoint.getPoint());

		return orderReqMemberInfo;
	}

	// 주문서에 출력할 회원의 최근 이용 가맹점
	public int getRecentStore(int uidx) {
		dao = template.getMapper(OrderDao.class);

		return dao.getOrderCnt(uidx) == 0 ? 0 : dao.getRecentStore(uidx);
	}

	// 주문서에 출력할 가맹점 정보
	public OrderReqStoreInfo getStoreInfo(int sidx) {
		dao = template.getMapper(OrderDao.class);

		return dao.getStoreInfo(sidx);
	}

	// 주문 DB insert
	public int insertOrder(OrderRequest orderRequest) {

		// DB에 공백 ""이 아닌 null 값이 들어가도록 처리
		if (orderRequest.getMsg().trim().length() == 0) {
			orderRequest.setMsg(null);
		}

		dao = template.getMapper(OrderDao.class);

		return dao.insertOrder(orderRequest);
	}

	// 주문 상품 DB insert
	public int insertOrderItems(List<OrderItem> orderItems) {
		dao = template.getMapper(OrderDao.class);

		return dao.insertOrderItems(orderItems);
	}

	// 결제 정보 DB insert
	public int insertPayment(PaymentInfo paymentInfo) {
		dao = template.getMapper(OrderDao.class);

		return dao.insertPayment(paymentInfo);
	}

}