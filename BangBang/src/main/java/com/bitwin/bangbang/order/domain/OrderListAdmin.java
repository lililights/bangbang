package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListAdmin extends OrderList {
	private int uidx;
	private String userid;
	private String sname;

	public OrderListAdmin(int oidx, String date, String thumb, String name, int uidx, String userid, String sname, String status) {
		super(oidx, date, status);
		this.uidx = uidx;
		this.userid = userid;
		this.sname = sname;
	}


}
