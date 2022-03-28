package com.bitwin.bangbang.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UrlPathHelper;

import com.bitwin.bangbang.member.domain.LoginInfo;
import com.bitwin.bangbang.order.domain.DeliveryRequest;
import com.bitwin.bangbang.order.domain.OrderListAdmin;
import com.bitwin.bangbang.order.domain.OrderListMember;
import com.bitwin.bangbang.order.domain.OrderListOptAdmin;
import com.bitwin.bangbang.order.domain.OrderListOptMember;
import com.bitwin.bangbang.order.domain.OrderListOptStore;
import com.bitwin.bangbang.order.domain.OrderListStore;
import com.bitwin.bangbang.order.domain.OrderRequest;
import com.bitwin.bangbang.order.domain.PaymentInfo;
import com.bitwin.bangbang.order.domain.UpdateOrder;
import com.bitwin.bangbang.order.domain.UpdateStatus;
import com.bitwin.bangbang.order.service.DeliveryService;
import com.bitwin.bangbang.order.service.OrderInfoService;
import com.bitwin.bangbang.order.service.OrderListService;
import com.bitwin.bangbang.order.service.OrderRequestService;
import com.bitwin.bangbang.order.service.OrderUpdateService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRequestService orderRequestService;
	@Autowired
	private OrderListService orderListService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private OrderUpdateService orderUpdateService;

	// ------------------------------------------------------------------------------------------------------

	// 주문서 요청
	@GetMapping(value = { "", "/linked" })
	public String getOrderForm(HttpSession session, Model model, HttpServletRequest request) {

		// 주문서에 출력할 현재 세션의 회원정보 불러오기
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		int uidx = loginInfo.getUidx();

		model.addAttribute("orderReqMemberInfo", orderRequestService.getOrderReqMemberInfo(uidx));

//		// 현재 세션의 회원이 메인화면 지도에서 선택한 매장 불러오기 / 없을 경우 최근 이용 매장 불러오기
//		MyStore myStore = (MyStore) session.getAttribute("myStore");
//		int sidx = myStore != null && loginInfo.getUidx() == myStore.getUidx() ? myStore.getSidx()
//				: orderRequestService.getRecentStore(uidx);
//
//		model.addAttribute("OrderReqStoreInfo", sidx == 0 ? null : orderRequestService.getStoreInfo(sidx));
		model.addAttribute("OrderReqStoreInfo", orderRequestService.getStoreInfo(1));

		// 장바구니를 거치지 않고 제품 상세보기 페이지에서 바로 주문서를 요청할 경우 처리
		UrlPathHelper urls = new UrlPathHelper();
		String url = urls.getOriginatingServletPath(request);

		if (url.contains("linked")) {
			model.addAttribute("linked", "on");
		}

		return "order/order_form";
	}

	// ------------------------------------------------------------------------------------------------------

	// 주문 접수
	@PostMapping(value = { "", "/linked" })
	@ResponseBody
	public String orderRequest(@RequestBody OrderRequest orderRequest) {

		// 주문 DB insert
		int orderCnt = orderRequestService.insertOrder(orderRequest);
		String result = orderCnt == 1 ? "[OR3] success" : orderCnt == 0 ? "[OR3] fail" : "[OR3] error";

		// 주문 DB insert 성공시 주문상품 DB insert
		if (orderCnt == 1) {

			int oidx = orderRequest.getOidx();
			int items = orderRequest.getOrderItems().size();

			// 각 주문상품에 주문 idx 값 저장 (foreign key 역할)
			for (int i = 0; i < items; i++) {
				orderRequest.getOrderItems().get(i).setOidx(oidx);
			}

			// 주문상품 DB insert
			int itemCnt = orderRequestService.insertOrderItems(orderRequest.getOrderItems());

			// 모든 단계 성공시 주문 idx 결과로 반환
			result = itemCnt == items ? Integer.toString(oidx) : itemCnt == 0 ? "[OR4] fail" : "[OR4] error";
		}

		return result;
	}

	// ------------------------------------------------------------------------------------------------------

	// 결제 정보 DB insert
	@PostMapping(value = { "/pay", "/linked/pay" })
	@ResponseBody
	public String insertPayment(@RequestBody PaymentInfo paymentInfo) {

		int paymentCnt = orderRequestService.insertPayment(paymentInfo);
		String result = paymentCnt == 1 ? "[OP2] success" : paymentCnt == 0 ? "[OP2] fail" : "[OP2] error";

		return result;
	}

	// ------------------------------------------------------------------------------------------------------

	// 일반회원 / 가맹점 권한으로 요청한 주문 목록 페이지
	@GetMapping(value = { "/member/{uidx}/list", "/store/{sidx}/list" })
	public String getOrderList() {

		return "order/order_list";
	}

	// 관리자 권한으로 요청한 주문 목록 페이지
	@GetMapping("/admin/list")
	public String getAdminOrderList() {

		return "order/order_list_admin";
	}

	// ------------------------------------------------------------------------------------------------------

	// 일반회원 권한으로 요청한 주문 목록 반환
	@GetMapping("/member/{uidx}/list/opt")
	@ResponseBody
	public List<OrderListMember> getMemberOrderList(OrderListOptMember listOpt) {

		// 검색 옵션값 객체로 담아 조회 후 결과 리스트로 반환 (JSON)
		return orderListService.selectOrderList(listOpt);
	}

	// 가맹점 권한으로 요청한 주문 목록 반환
	@GetMapping("/store/{sidx}/list/opt")
	@ResponseBody
	public List<OrderListStore> getStoreOrderList(OrderListOptStore listOpt) {

		// 검색 옵션값 객체로 담아 조회 후 결과 리스트로 반환 (JSON)
		return orderListService.selectOrderList(listOpt);
	}

	// 관리자 권한으로 요청한 주문 목록 반환
	@GetMapping("/admin/list/opt")
	@ResponseBody
	public List<OrderListAdmin> getAdminOrderList(OrderListOptAdmin listOpt) {

		// 검색 옵션값 객체로 담아 조회 후 결과 리스트로 반환 (JSON)
		return orderListService.selectOrderList(listOpt);
	}

	// ------------------------------------------------------------------------------------------------------

	// 일반회원 / 가맹점 / 관리자 권한으로 요청한 주문 상세보기
	@GetMapping(value = { "/member/list/{oidx}", "/store/list/{oidx}", "/admin/list/{oidx}" })
	public String getMemberOrderInfo(@PathVariable("oidx") int oidx, Model model, HttpServletRequest request) {

		UrlPathHelper urls = new UrlPathHelper();
		String url = urls.getOriginatingServletPath(request);

		// 들어온 url 경로에 따른 분기 처리
		if (url.contains("member")) {
			model.addAttribute("orderInfo", orderInfoService.selectOrderInfoMember(oidx));

		} else if (url.contains("store")) {
			model.addAttribute("orderInfo", orderInfoService.selectOrderInfoStore(oidx));

		} else if (url.contains("admin")) {
			model.addAttribute("orderInfo", orderInfoService.selectOrderInfoAdmin(oidx));
		}

		return "order/order_info";
	}

	// ------------------------------------------------------------------------------------------------------

	// 주문 정보 변경
	@PutMapping(value = { "/member/list/{oidx}", "/store/list/{oidx}", "/admin/list/{oidx}" })
	@ResponseBody
	public String updateOrder(@RequestBody UpdateOrder updateOrder) {

		return orderUpdateService.updateOrder(updateOrder);
	}

	// ------------------------------------------------------------------------------------------------------

	// 주문 단계 변경
	@PutMapping(value = { "/member/list/{oidx}/status", "/store/list/{oidx}/status", "/admin/list/{oidx}/status" })
	@ResponseBody
	public String updateStatus(@RequestBody UpdateStatus updateStatus) {

		return orderUpdateService.updateStatus(updateStatus);
	}

	// ------------------------------------------------------------------------------------------------------

	// 관리자용 택배/퀵 배송 리스트
	@GetMapping("/admin/delivery")
	public String getDeliveryList(Model model) {

		model.addAttribute("deliveryList", deliveryService.selectDeliveryList());

		return "order/delivery_list";
	}

	// ------------------------------------------------------------------------------------------------------
	
	// 주문 번호로 택배/퀵 배송 조회
	@GetMapping("/admin/delivery/{oidx}")
	@ResponseBody
	public String deliveryTracking(@PathVariable("oidx") int oidx) {

		return deliveryService.deliveryTracking(oidx);
	}

	// ------------------------------------------------------------------------------------------------------

	// 관리자용 택배/퀵 배송 요청
	@PostMapping("/admin/delivery")
	@ResponseBody
	public String deliveryRequest(@RequestBody List<DeliveryRequest> deliveryRequest) {

		int result = deliveryService.deliveryRequest(deliveryRequest);

		// 성공시 성공 횟수 반환
		return result == deliveryRequest.size() ? Integer.toString(result) : "[OR7] fail";
	}

}