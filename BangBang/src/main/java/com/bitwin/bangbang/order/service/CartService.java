package com.bitwin.bangbang.order.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.order.dao.OrderDao;
import com.bitwin.bangbang.order.domain.CartItem;
import com.bitwin.bangbang.order.domain.OrderItemInfo;

@Service
public class CartService {
	private OrderDao dao;
	@Autowired
	private SqlSessionTemplate template;

	// 장바구니 목록에 출력할 상품 정보
	public List<OrderItemInfo> getItemInfo(List<CartItem> cartItems) {
		dao = template.getMapper(OrderDao.class);

		List<OrderItemInfo> list = new ArrayList<OrderItemInfo>();

		for (int i = 0; i < cartItems.size(); i++) {
			OrderItemInfo item = dao.getItemInfo(cartItems.get(i));
			item.setQty(cartItems.get(i).getQty());
			list.add(item);
		}

		return list;
	}

}
