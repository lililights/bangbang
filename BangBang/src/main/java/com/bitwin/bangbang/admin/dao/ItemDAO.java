package com.bitwin.bangbang.admin.dao;

import java.util.List;
import java.util.Map;

import com.bitwin.bangbang.admin.domain.Item;
import com.bitwin.bangbang.admin.domain.ItemRead;
import com.bitwin.bangbang.admin.domain.OrderItemInfo;
import com.bitwin.bangbang.admin.domain.SearchParams;

public interface ItemDAO {
	
	// 상품 등록
	public void create(Item item);
	
	// 상품 불러오기
	public ItemRead read(int iidx);

	// 상품 수정
	public void update(Item item);

	// 상품 삭제
	public void delete(int iidx);
	
	// 상품 목록
	public List<ItemRead> selectList(SearchParams params);
	
	public int selectTotalCount(Map<String, String> params);
	
	public OrderItemInfo orderItemInfo(int iidx);
}
