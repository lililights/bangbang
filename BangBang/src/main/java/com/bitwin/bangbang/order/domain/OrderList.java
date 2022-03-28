package com.bitwin.bangbang.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
	private int oidx;
	private String date;
	private String thumb;
	private String name;
	private String restCount;
	private String status;
	private int totalpay;

	public OrderList(int oidx, String date, String status) {
		this.oidx = oidx;
		this.date = date;
		this.status = status;
	}

}
