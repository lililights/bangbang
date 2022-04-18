package com.bitwin.bangbang.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListMember extends OrderList {
	private String sname;

	public OrderListMember(int oidx, String date, String thumb, String name, String restCount, String sname,
			String status, int totalpay) {
		super(oidx, date, thumb, name, restCount, status, totalpay);
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "OrderListMember [sname=" + sname + ", getOidx()=" + getOidx() + ", getDate()=" + getDate()
				+ ", getThumb()=" + getThumb() + ", getName()=" + getName() + ", getRestCount()=" + getRestCount()
				+ ", getStatus()=" + getStatus() + ", getTotalpay()=" + getTotalpay() + "]";
	}

}