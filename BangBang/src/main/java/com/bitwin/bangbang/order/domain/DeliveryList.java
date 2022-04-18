package com.bitwin.bangbang.order.domain;
//
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryList {
	private int didx;
	private int oidx;
	private String service;
	private String provider;
	private String no;
	private int fee;

}
