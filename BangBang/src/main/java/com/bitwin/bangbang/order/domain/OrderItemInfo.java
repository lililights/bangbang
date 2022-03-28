package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderItemInfo {
	private int iidx;
	private String thumb;
	private String name;
	private int qty;
	private int price;
	private int salePrice;

}
