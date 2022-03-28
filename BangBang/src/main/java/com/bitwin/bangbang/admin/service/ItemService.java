package com.bitwin.bangbang.admin.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.admin.dao.ItemDAO;
import com.bitwin.bangbang.admin.domain.Item;
import com.bitwin.bangbang.admin.domain.ItemRead;
import com.bitwin.bangbang.admin.domain.ListPageView;
import com.bitwin.bangbang.admin.domain.OrderItemInfo;
import com.bitwin.bangbang.admin.domain.SearchParams;

@Service
public class ItemService {

	ItemDAO dao;

	@Autowired
	private SqlSessionTemplate template;

	public void create(Item item) {

		dao = template.getMapper(ItemDAO.class);

		dao.create(item);

		System.out.println("iidx => " + item.getIidx());

	}

	public ItemRead read(int iidx) {
		ItemRead item = template.getMapper(ItemDAO.class).read(iidx);
		int sprice = Integer.parseInt(item.getSprice());
		int price = (int) (sprice*(1-((double)item.getDiscount()/100)));
		item.setPrice(price);
		
		return item;
	}

	public void update(Item item) {
		dao = template.getMapper(ItemDAO.class);
		dao.update(item);
	}

	public void delete(int iidx) {
		dao = template.getMapper(ItemDAO.class);
		
		dao.delete(iidx);
	}

	public Object getPageView(SearchParams params) throws SQLException {
		int CountPerPage = 10;

		ListPageView view = null;

		dao = template.getMapper(ItemDAO.class);

		if (params.getKeyword() == null || params.getKeyword().trim().isEmpty()) {
			params.setSearchType(null);
		}

		Map<String, String> searchMap = new HashMap();
		searchMap.put("searchType", params.getSearchType());
		searchMap.put("keyword", params.getKeyword());

		int totalCount = dao.selectTotalCount(searchMap);

		int currentPage = params.getP() == 0 ? 1 : params.getP();

		int index = (currentPage - 1) * CountPerPage;

		params.setIndex(index);
		params.setCount(CountPerPage);

		List<ItemRead> list = dao.selectList(params);

		view = new ListPageView(totalCount, currentPage, CountPerPage, list);

		return view;
	}
	
	public OrderItemInfo orderItemInfo(int iidx) {
		return template.getMapper(ItemDAO.class).orderItemInfo(iidx);
		
	}
	
}
