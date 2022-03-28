package com.bitwin.bangbang.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwin.bangbang.admin.domain.BoardEdit;
import com.bitwin.bangbang.admin.domain.BoardReg;
import com.bitwin.bangbang.admin.domain.Review;
import com.bitwin.bangbang.admin.domain.ReviewList;
import com.bitwin.bangbang.admin.domain.SearchParams;
import com.bitwin.bangbang.admin.service.BoardService;
import com.bitwin.bangbang.admin.service.ItemService;
import com.bitwin.bangbang.admin.service.ReviewService;
import com.bitwin.bangbang.admin.service.WishService;

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ItemService itemService;
	 
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private WishService wishService;
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(@RequestParam int iidx, Model model) {
		model.addAttribute("item", itemService.read(iidx));
		return "board/write";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(BoardReg reg, Model model, HttpServletRequest request) throws IllegalStateException, IOException {
		model.addAttribute("board", boardService.create(reg, request));
		return "redirect:list";
	}

	@RequestMapping("list")
	public String getListPage(SearchParams params, Model model) throws SQLException {
		model.addAttribute("board", boardService.getPageView(params));
		return "board/list";
	}
	
	@RequestMapping("list-type")
	public void getListPage(SearchParams params, Model model, @RequestParam("type") String type) throws SQLException {
		params.setKeyword(type);
		model.addAttribute("board", boardService.getCateView(params));
	}

	@RequestMapping("detail")
	public void getPage(@RequestParam("iidx") int iidx, Model model) {
		boardService.hits(iidx);
		model.addAttribute("item", itemService.read(iidx));
		model.addAttribute("board", boardService.read(iidx));
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String form(@RequestParam("iidx") int iidx, Model model) {
		model.addAttribute("board", boardService.read(iidx));
		System.out.println(boardService.read(iidx));
		model.addAttribute("item", itemService.read(iidx));
		return "board/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardEdit edit, HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println(edit);
		boardService.update(edit, request);
		return "redirect:list";
	}

	@RequestMapping(value = "delete")
	public String delete(@RequestParam int iidx) {
		boardService.delete(iidx);
		return "redirect:list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/detail/review-list", method = RequestMethod.GET)
	public List<ReviewList> getReviewList(@RequestParam("iidx") int iidx){
		List<ReviewList> review = reviewService.read(iidx);
		return review;
	}
	
	@ResponseBody
	@RequestMapping(value = "/detail/review-reg", method = RequestMethod.POST)
	public void write(Review review, HttpSession session) throws Exception {
		
		// Member member = (Member)session.getAttribute("member");
		// review.setUidx(member.getUserId());
		
		reviewService.create(review);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/detail/review-del", method = RequestMethod.POST)
	public int deleteReview(Review review, HttpSession session) throws Exception {
	 int result = 0;
	 
	 // Member member = (Member)session.getAttribute("member");
	 int uidx = reviewService.reviewUidCheck(review.getRidx());
	 
		/*
		 * if(member.getUidx() == uidx) {
		 * 	review.setUidx(member.getUidx());
		 * 	reviewService.delete(review);
		 * 
		 * 	result = 1;
		 * }
		 */
	 
	 return result; 
	}
	
	
	
	// 회원 연결 수정필요 및 ajax 추가
	@ResponseBody
	@RequestMapping(value = "/detail/review-up", method = RequestMethod.POST)
	public int updateReview(Review review, HttpSession session) throws Exception {
	 int result = 0;
	 
	// Member member = (Member)session.getAttribute("member");
	 int uidx = reviewService.reviewUidCheck(review.getRidx());
	 
		/*
		 * if(member.getUidx().equals(uidx)) { 
		 * review.setUidx(member.getUidx());
		 * reviewService.update(review);
		 * result = 1; 
		 * }
		 */
	 return result; 
	}
	
	@RequestMapping(value = "/detail/wishcheck", method= RequestMethod.POST)
	public void wishCheck(@RequestParam("iidx") int iidx, int uidx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iidx", iidx);
		map.put("uidx", uidx);
		
		wishService.wishUpdate(map);
	}
	@RequestMapping(value = "/detail/wishcount", method= RequestMethod.POST)
	public void wishCount(@RequestParam("iidx") int iidx) {
		wishService.wishCnt(iidx);
	}
	
	
	
}
