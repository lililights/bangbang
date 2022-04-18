package com.bitwin.bangbang.order.domain;//

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListOptMember extends OrderListOpt {
	private int uidx;

	public OrderListOptMember(int uidx, String optPeriod, String optStatus, int page) {
		super(optPeriod, optStatus, page);
		this.uidx = uidx;
	}

	@Override
	public String toString() {
		return "OrderListOptMember [uidx=" + uidx + ", getOptPeriod()=" + getOptPeriod() + ", getOptStatus()="
				+ getOptStatus() + ", getPage()=" + getPage() + "]";
	}

}
