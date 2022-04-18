package com.bitwin.bangbang.order.domain;//

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequest {
	private int oidx;
	private int uidx;
	private int sidx;
	private String name;
	private String phone;
	private String msg;
	private List<OrderItem> orderItems;

}
