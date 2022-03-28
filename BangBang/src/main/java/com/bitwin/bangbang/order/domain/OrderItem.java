package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderItem {
	private int oidx;
	private int iidx;
	private int qty;

}
