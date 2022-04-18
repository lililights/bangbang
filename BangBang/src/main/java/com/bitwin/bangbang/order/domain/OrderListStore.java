package com.bitwin.bangbang.order.domain;//

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListStore extends OrderList {
	private String username;
	private int commission;

	public OrderListStore(int oidx, String date, String thumb, String name, String restCount, String username,
			String status, int totalpay, int commission) {
		super(oidx, date, thumb, name, restCount, status, totalpay);
		this.username = username;
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "OrderListStore [username=" + username + ", commission=" + commission + ", getOidx()=" + getOidx()
				+ ", getDate()=" + getDate() + ", getThumb()=" + getThumb() + ", getName()=" + getName()
				+ ", getRestCount()=" + getRestCount() + ", getStatus()=" + getStatus() + ", getTotalpay()="
				+ getTotalpay() + "]";
	}

}
