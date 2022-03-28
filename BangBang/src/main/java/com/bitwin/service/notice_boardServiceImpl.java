package com.bitwin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitwin.domain.notice_boardVO;
import com.bitwin.domain.Criteria;
import com.bitwin.mapper.notice_boardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class notice_boardServiceImpl implements notice_boardService {
	
	//Spring 4.3 이상에서 자동 처리
	private notice_boardMapper mapper;
	
	@Override
	public void register(notice_boardVO board) {
		log.info("register......" + board);
		mapper.insertSelectKey(board);
		
	}
	
	@Override
	public List<notice_boardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
		
	}
	
	@Override
	public notice_boardVO get(int nidx) {
		
		log.info("get......" + nidx);
		
		return mapper.read(nidx);
		
	}
	
	@Override
	public boolean modify(notice_boardVO board) {
		
		log.info("modify....." + board);
		
		return mapper.update(board) == 1;
		
	}
	
	@Override
	public boolean remove(int nidx) {
		
		log.info("remove...." + nidx);
		
		return mapper.delete(nidx)==1;
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}
	
	
	
	
	
	
	
	
}
