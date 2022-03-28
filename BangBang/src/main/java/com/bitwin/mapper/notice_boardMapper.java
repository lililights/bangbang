package com.bitwin.mapper;

import java.util.List;

import com.bitwin.domain.notice_boardVO;
import com.bitwin.domain.Criteria;

public interface notice_boardMapper {
	
//	@Select("select * from tbl_board where nidx > 0") -> BorderMapper.xml 로 처리완료 (아래 메소드들도 동일)
	public List<notice_boardVO> getList();
	
	public void insert(notice_boardVO board);
	
	public void insertSelectKey(notice_boardVO board);
	
	public notice_boardVO read(int nidx);
	
	public int delete(int nidx);
	
	public int update(notice_boardVO board);
	
	public List<notice_boardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
