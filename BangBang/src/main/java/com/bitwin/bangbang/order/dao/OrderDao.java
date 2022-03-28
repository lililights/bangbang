package com.bitwin.bangbang.order.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.bitwin.bangbang.order.domain.CartItem;
import com.bitwin.bangbang.order.domain.DeliveryList;
import com.bitwin.bangbang.order.domain.DeliveryRequest;
import com.bitwin.bangbang.order.domain.MemberPoint;
import com.bitwin.bangbang.order.domain.OrderInfoAdmin;
import com.bitwin.bangbang.order.domain.OrderInfoMember;
import com.bitwin.bangbang.order.domain.OrderInfoStore;
import com.bitwin.bangbang.order.domain.OrderItem;
import com.bitwin.bangbang.order.domain.OrderItemInfo;
import com.bitwin.bangbang.order.domain.OrderListAdmin;
import com.bitwin.bangbang.order.domain.OrderListMember;
import com.bitwin.bangbang.order.domain.OrderListOptAdmin;
import com.bitwin.bangbang.order.domain.OrderListOptMember;
import com.bitwin.bangbang.order.domain.OrderListOptStore;
import com.bitwin.bangbang.order.domain.OrderListStore;
import com.bitwin.bangbang.order.domain.OrderReqMemberInfo;
import com.bitwin.bangbang.order.domain.OrderReqStoreInfo;
import com.bitwin.bangbang.order.domain.OrderRequest;
import com.bitwin.bangbang.order.domain.PaymentInfo;
import com.bitwin.bangbang.order.domain.UpdateOrder;
import com.bitwin.bangbang.order.domain.UpdateStatus;

public interface OrderDao {

	// 장바구니 목록에 출력할 상품 정보
	public OrderItemInfo getItemInfo(CartItem cartItems);

	// 주문서에 출력할 회원정보
	public OrderReqMemberInfo getOrderReqMemberInfo(int uidx);

	// 사용가능 적립금 조회
	public MemberPoint getMemberPoint(int uidx);

	// 회원의 주문 이력 조회
	public int getOrderCnt(int uidx);

	// 주문서에 출력할 회원의 최근 이용 가맹점
	public int getRecentStore(int uidx);

	// 주문서에 출력할 가맹점 정보
	public OrderReqStoreInfo getStoreInfo(int sidx);

	// 주문 DB insert
	public int insertOrder(OrderRequest orderRequest);

	// 주문 상품 DB insert
	public int insertOrderItems(List<OrderItem> orderItems);

	// 결제 정보 DB insert
	public int insertPayment(PaymentInfo paymentInfo);

	// 회원용 주문 목록 출력
	public List<OrderListMember> selectOrderListMember(OrderListOptMember listOpt);

	// 가맹점용 주문 목록 출력
	public List<OrderListStore> selectOrderListStore(OrderListOptStore listOpt);

	// 관리자용 주문 목록 출력
	public List<OrderListAdmin> selectOrderListAdmin(OrderListOptAdmin listOpt);

	// 구매 제품 리스트
	public List<OrderItemInfo> selectOrderItemInfo(int oidx);

	// 일반회원 권한으로 요청한 주문 상세보기
	public OrderInfoMember selectOrderInfoMember(int oidx);

	// 가맹점 권한으로 요청한 주문 상세보기
	public OrderInfoStore selectOrderInfoStore(int oidx);

	// 관리자 권한으로 요청한 주문 상세보기
	public OrderInfoAdmin selectOrderInfoAdmin(int oidx);

	// 주문 정보 변경
	public int updateOrder(UpdateOrder updateOrder);

	// 주문 단계 변경
	public int updateStatus(UpdateStatus updateStatus);

	// 관리자용 택배/퀵 배송관리 리스트
	public List<DeliveryList> selectDeliveryList();

	// 관리자용 택배/퀵 배송 요청
	public int deliveryRequest(@RequestBody List<DeliveryRequest> deliveryRequest);

	// 주문 번호로 택배/퀵 배송 조회
	public String deliveryTracking(int oidx);

}
