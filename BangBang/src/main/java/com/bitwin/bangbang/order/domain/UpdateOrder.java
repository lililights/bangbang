package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateOrder {
	private int oidx;
	private String name;
	private String phone;
	private String msg;

}
