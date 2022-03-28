package com.bitwin.bangbang.order.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderInfoAdmin {
	private int oidx;
	private String date;
	private String status;
	private int uidx;
	private String userid;
	private String sname;
	private List<OrderItemInfo> orderItemInfo;
	private String name;
	private String phone;
	private String msg;
	private String totalPrice;
	private String discount;
	private String pointUsed;
	private String totalPay;
	private String commission;
	private int didx;

}
