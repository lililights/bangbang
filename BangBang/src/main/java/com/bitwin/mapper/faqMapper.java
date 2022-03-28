package com.bitwin.mapper;

import java.util.List;

import com.bitwin.domain.faqVO;
import com.bitwin.domain.Criteria;

public interface faqMapper {
	
//	@Select("select * from tbl_board where fqidx > 0") -> BorderMapper.xml 로 처리완료 (아래 메소드들도 동일)
	public List<faqVO> getList();
	
	public void insert(faqVO board);
	
	public void insertSelectKey(faqVO board);
	
	public faqVO read(int fqidx);
	
	public int delete(int fqidx);
	
	public int update(faqVO board);
	
	public List<faqVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
