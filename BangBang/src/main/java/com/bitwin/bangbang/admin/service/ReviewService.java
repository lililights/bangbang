package com.bitwin.bangbang.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.admin.dao.ReviewDAO;
import com.bitwin.bangbang.admin.domain.Review;
import com.bitwin.bangbang.admin.domain.ReviewList;

@Service
public class ReviewService {

	private ReviewDAO dao;

	@Autowired
	private SqlSessionTemplate template;

	public void create(Review review) {
		dao = template.getMapper(ReviewDAO.class);

		dao.create(review);
	}

	public List<ReviewList> read(int iidx) {
		dao = template.getMapper(ReviewDAO.class);

		return dao.read(iidx);
	}
	
	public void update(Review review) {
		dao = template.getMapper(ReviewDAO.class);

		dao.update(review);
	}

	public void delete(Review review) {
		dao = template.getMapper(ReviewDAO.class);
		
		dao.delete(review);
	}
	
	public Review selectReview(int ridx) {
		dao = template.getMapper(ReviewDAO.class);
		return dao.selectReview(ridx);
	}
	
	public int reviewUidCheck(int ridx) {
		dao = template.getMapper(ReviewDAO.class);
		return dao.reviewUidCheck(ridx);
	}
	
}