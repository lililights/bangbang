package com.bitwin.bangbang.order.domain;//

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentInfo {
	private int oidx;
	private int totalprice;
	private int discount;
	private int pointused;
	private int totalpay;
	private String method;

}
