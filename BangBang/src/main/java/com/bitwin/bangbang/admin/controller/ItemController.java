package com.bitwin.bangbang.admin.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitwin.bangbang.admin.domain.Item;
import com.bitwin.bangbang.admin.domain.SearchParams;
import com.bitwin.bangbang.admin.service.ItemService;

@Controller
@RequestMapping("/admin/item/*")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "item/write";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute Item item) {
		
		String sprice = item.getSprice().replaceAll("[^\\d]*", "");
		String oprice = item.getOprice().replaceAll("[^\\d]*", "");
		
		item.setSprice(sprice);
		item.setOprice(oprice);
		
		itemService.create(item);
		return "redirect:list";
	}

	@RequestMapping("list")
	public void getListPage(SearchParams params, Model model) throws SQLException {
		model.addAttribute("item", itemService.getPageView(params));

	}

	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String form(@RequestParam("iidx") int iidx, Model model) {
		model.addAttribute("item", itemService.read(iidx));
		return "item/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Item item) {
		itemService.update(item);
		return "redirect:list";
	}

	@RequestMapping(value = "delete")
	public String delete(@RequestParam int iidx) {
		itemService.delete(iidx);
		return "redirect:list";
	}
	
	public void orderItemInfo(@RequestParam("iidx") int iidx) {
		itemService.orderItemInfo(iidx);
	}

	
}
