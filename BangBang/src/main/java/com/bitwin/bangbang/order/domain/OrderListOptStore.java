package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListOptStore extends OrderListOpt {
	private int sidx;

	public OrderListOptStore(int sidx, String optPeriod, String optStatus, int page) {
		super(optPeriod, optStatus, page);
		this.sidx = sidx;
	}

	@Override
	public String toString() {
		return "OrderListOptStore [sidx=" + sidx + ", getOptPeriod()=" + getOptPeriod() + ", getOptStatus()="
				+ getOptStatus() + ", getPage()=" + getPage() + "]";
	}

}
