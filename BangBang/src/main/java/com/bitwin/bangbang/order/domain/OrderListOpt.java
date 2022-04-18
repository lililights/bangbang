package com.bitwin.bangbang.order.domain;//

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
public class OrderListOpt {
	private String optPeriod;
	private String optStatus;
	private int page;

}
