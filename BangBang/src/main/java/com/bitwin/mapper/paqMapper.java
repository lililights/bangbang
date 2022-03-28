package com.bitwin.mapper;

import java.util.List;

import com.bitwin.domain.paqVO;
import com.bitwin.domain.Criteria;

public interface paqMapper {
	
//	@Select("select * from tbl_paq where pqidx > 0") -> BorderMapper.xml 로 처리완료 (아래 메소드들도 동일)
	public List<paqVO> getList();
	
	public void insert(paqVO paq);
	
	public void insertSelectKey(paqVO paq);
	
	public paqVO read(int pqidx);
	
	public int delete(int pqidx);
	
	public int update(paqVO paq);
	
	public List<paqVO> memberGetListWithPaging(Criteria cri);
	
	public List<paqVO> adminGetListWithPaging(Criteria cri);
	
	public int memberGetTotalCount(Criteria cri);
	
	public int adminGetTotalCount(Criteria cri);

	public String getEmail(int uidx);
	
	public String getPhoneNum(int uidx);
}
