package com.bitwin.bangbang.admin.dao;

import java.util.List;

import com.bitwin.bangbang.admin.domain.Review;
import com.bitwin.bangbang.admin.domain.ReviewList;

public interface ReviewDAO {

	public void create(Review review);
	
	public List<ReviewList> read(int iidx);
	
	public void update(Review review);
	
	public void delete(Review review);
	
	public Review selectReview(int ridx);
	
	public int reviewUidCheck(int ridx);
}
