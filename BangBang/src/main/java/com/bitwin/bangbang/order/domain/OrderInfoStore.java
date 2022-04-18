package com.bitwin.bangbang.order.domain;//

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderInfoStore {
	private int oidx;
	private String date;
	private String status;
	private String name;
	private List<OrderItemInfo> orderItemInfo;
	private String msg;
	private String commission;

}
