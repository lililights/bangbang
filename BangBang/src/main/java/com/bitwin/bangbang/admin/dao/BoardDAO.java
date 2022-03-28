package com.bitwin.bangbang.admin.dao;

import java.util.List;
import java.util.Map;

import com.bitwin.bangbang.admin.domain.Board;
import com.bitwin.bangbang.admin.domain.BoardEdit;
import com.bitwin.bangbang.admin.domain.BoardReg;
import com.bitwin.bangbang.admin.domain.SearchParams;

public interface BoardDAO {
	
	// 게시글 작성
	public int create(BoardReg reg);
	
	// 게시글 상세보기
	public Board read(int iidx);
	
	// 게시글 수정
	public int update(BoardEdit boardEdit);

	// 게시글 삭제
	public void delete(int iidx);
	
	// 게시글 목록
	public List<Board> selectList(SearchParams params);

	public List<Board> selectTypeList(SearchParams params);

	public int selectTotalCount(Map<String, String> params);

	public int selectCount(Map<String, String> params);
	
	public int hits(int iidx);
	
		
}
