package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReqMemberInfo extends MemberPoint {
	private int uidx;
	private String username;
	private String phonenum;

	@Override
	public String toString() {
		return "OrderReqMemberInfo [uidx=" + uidx + ", username=" + username + ", phonenum=" + phonenum
				+ ", getPoint()=" + getPoint() + "]";
	}

}
