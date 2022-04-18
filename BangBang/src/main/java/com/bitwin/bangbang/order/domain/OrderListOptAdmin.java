package com.bitwin.bangbang.order.domain;//

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderListOptAdmin extends OrderListOpt {
	private String searchType;
	private String searchKeyword;

	public OrderListOptAdmin(String optPeriod, String searchType, String searchKeyword, String optStatus, int page) {
		super(optPeriod, optStatus, page);
		this.searchType = searchType;
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "OrderListOptAdmin [searchType=" + searchType + ", searchKeyword=" + searchKeyword + ", getOptPeriod()="
				+ getOptPeriod() + ", getOptStatus()=" + getOptStatus() + ", getPage()=" + getPage() + "]";
	}

}
