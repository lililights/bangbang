package com.bitwin.bangbang.order.temp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController {

	@RequestMapping("/temp")
	public String temp(Model model) {

		return "order/temp/home";
	}

	@RequestMapping("/item")
	public String itemPage(Model model) {

		return "order/temp/item_page";
	}

	@RequestMapping("/temp/order-list")
	public String orderList() {

		return "order/temp/order_list";
	}

}
