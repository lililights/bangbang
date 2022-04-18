package com.bitwin.bangbang.order.domain;//

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryRequest {
	private String service;
	private String provider;
	private int oidx;

}
