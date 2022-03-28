package com.bitwin.service;

import java.util.List;

import com.bitwin.domain.notice_boardVO;
import com.bitwin.domain.Criteria;

public interface notice_boardService {
	
	
	public void register(notice_boardVO board);
	
	public notice_boardVO get(int nidx);
	
	public boolean modify(notice_boardVO board);
	
	public boolean remove(int nidx);
	
	public List<notice_boardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	
}
