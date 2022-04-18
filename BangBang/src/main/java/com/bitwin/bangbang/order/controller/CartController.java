package com.bitwin.bangbang.order.controller;
//
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwin.bangbang.order.domain.CartItem;
import com.bitwin.bangbang.order.domain.OrderItemInfo;
import com.bitwin.bangbang.order.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	// 장바구니 보기
	@GetMapping
	public String showCart() {
		return "order/cart";
	}

	// 웹스토리지 장바구니에 저장된 상품 정보 요청
	@PostMapping // Get 방식으로 List를 받아올 수 없어 Post 방식으로 대체
	@ResponseBody
	public List<OrderItemInfo> getCartItemInfo(@RequestBody List<CartItem> cartItems) {

		// 검색 옵션값 객체로 담아 조회 후 결과 리스트로 반환 (JSON)
		return cartService.getItemInfo(cartItems);
	}

}
