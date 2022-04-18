package com.bitwin.bangbang.order.service;//

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.UpdateOrder;
import com.bitwin.bangbang.order.domain.UpdateStatus;

@Service
public class OrderUpdateService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 주문 정보 변경
	public String updateOrder(UpdateOrder updateOrder) {
		dao = template.getMapper(OrderDao.class);

		return dao.updateOrder(updateOrder) == 1 ? "[OM7] success" : "[OM7] fail";
	}

	// 주문 단계 변경
	public String updateStatus(UpdateStatus updateStatus) {
		dao = template.getMapper(OrderDao.class);

		updateStatus.setStatus(reformOrderStatus(updateStatus.getStatus()));

		return dao.updateStatus(updateStatus) == 1 ? "[OM5] success" : "[OM5] fail";
	}

	// 주문 단계 실제 DB에 입력할 값으로 변경
	public String reformOrderStatus(String status) {

		switch (status) {

		case "accepted":
			status = "주문완료";
			break;
		case "delivering":
			status = "배송진행중";
			break;
		case "pickupPro":
			status = "픽업가능";
			break;
		case "pickupCom":
			status = "픽업완료";
			break;
		case "cancelPro":
			status = "취소진행중";
			break;
		case "cancelCom":
			status = "취소완료";
			break;
		case "exchangePro":
			status = "교환진행중";
			break;
		case "refundPro":
			status = "반품진행중";
			break;
		case "refundCom":
			status = "반품완료";
			break;
		}

		return status;
	}

}
