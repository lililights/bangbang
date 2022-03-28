package com.bitwin.bangbang.admin.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.admin.dao.BoardDAO;
import com.bitwin.bangbang.admin.domain.Board;
import com.bitwin.bangbang.admin.domain.BoardEdit;
import com.bitwin.bangbang.admin.domain.BoardListPageView;
import com.bitwin.bangbang.admin.domain.BoardReg;
import com.bitwin.bangbang.admin.domain.SearchParams;
import com.bitwin.bangbang.member.service.CommonsData;

@Service
public class BoardService {

	BoardDAO dao;

	@Autowired
	private SqlSessionTemplate template;

	// 게시물 등록
	public int create(BoardReg reg, HttpServletRequest request) throws IllegalStateException, IOException {
		
		int resultCnt = 0;
		
		reg.setThumbName("default.jpg");
		reg.setPhoto1Name("default.jpg");
		reg.setPhoto2Name("default.jpg");

		File newFile = null;
		String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URL);
		
		if (!reg.getThumb().isEmpty() && reg.getThumb().getSize() > 0) {
			String[] files = reg.getThumb().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			reg.getThumb().transferTo(newFile);
			reg.setThumbName(newFileName);
		}
		if (!reg.getPhoto1().isEmpty() && reg.getPhoto1().getSize() > 0) {
			String[] files = reg.getPhoto1().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			reg.getPhoto1().transferTo(newFile);
			reg.setPhoto1Name(newFileName);
		}
		if (!reg.getPhoto2().isEmpty() && reg.getPhoto2().getSize() > 0) {
			String[] files = reg.getPhoto2().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			reg.getPhoto2().transferTo(newFile);
			reg.setPhoto2Name(newFileName);
		}
		System.out.println(savePath);

		try {
			dao = template.getMapper(BoardDAO.class);

			resultCnt = dao.create(reg);
		} catch (Exception e) {
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}

	// 게시물 읽어오기
	public Board read(int iidx) {
		
		Board board = template.getMapper(BoardDAO.class).read(iidx);
		
		return board;
	}

	// 게시물 수정
	public int update(BoardEdit boardEdit, HttpServletRequest request) throws IllegalStateException, IOException {
		int resultCnt = 0;
		
		File newFile = null;
		String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URL);

		if (!boardEdit.getThumb().isEmpty() && boardEdit.getThumb().getSize() > 0) {
			String[] files = boardEdit.getThumb().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			boardEdit.getThumb().transferTo(newFile);
			boardEdit.setThumbName(newFileName);
		}
		if (!boardEdit.getPhoto1().isEmpty() && boardEdit.getPhoto1().getSize() > 0) {
			String[] files = boardEdit.getPhoto1().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			boardEdit.getPhoto1().transferTo(newFile);
			boardEdit.setPhoto1Name(newFileName);
		}
		if (!boardEdit.getPhoto2().isEmpty() && boardEdit.getPhoto2().getSize() > 0) {
			String[] files = boardEdit.getPhoto2().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			boardEdit.getPhoto2().transferTo(newFile);
			boardEdit.setPhoto2Name(newFileName);
		}


		try {
			
			dao = template.getMapper(BoardDAO.class);
			resultCnt = dao.update(boardEdit);

		} catch (Exception e) {
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}

	// 게시물 삭제
	public void delete(int iidx) {
		dao = template.getMapper(BoardDAO.class);

		dao.delete(iidx);
	}

	// 페이지
	public Object getPageView(SearchParams params) throws SQLException {
		int CountPerPage = 10;

		BoardListPageView view = null;

		dao = template.getMapper(BoardDAO.class);

		if (params.getKeyword() == null || params.getKeyword().trim().isEmpty()) {
			params.setSearchType(null);
		}

		Map<String, String> searchMap = new HashMap();
		searchMap.put("searchType", params.getSearchType());
		searchMap.put("keyword", params.getKeyword());

		int totalCount = dao.selectTotalCount(searchMap);

		int currentPage = params.getP() == 0 ? 1 : params.getP();

		int index = (currentPage - 1) * CountPerPage;

		params.setIndex(index);
		params.setCount(CountPerPage);

		List<Board> list = dao.selectList(params);

		view = new BoardListPageView(totalCount, currentPage, CountPerPage, list);

		return view;
	}
	
	// 카테고리 목록
	public Object getCateView(SearchParams params) throws SQLException {
		int CountPerPage = 10;

		BoardListPageView view = null;

		dao = template.getMapper(BoardDAO.class);

		if (params.getKeyword() == null || params.getKeyword().trim().isEmpty()) {
			params.setSearchType(null);
		}

		Map<String, String> searchMap = new HashMap();
		searchMap.put("searchType", params.getSearchType());
		searchMap.put("keyword", params.getKeyword());

		int totalCount = dao.selectCount(searchMap);

		int currentPage = params.getP() == 0 ? 1 : params.getP();

		int index = (currentPage - 1) * CountPerPage;

		params.setIndex(index);
		params.setCount(CountPerPage);

		List<Board> list = dao.selectTypeList(params);

		view = new BoardListPageView(totalCount, currentPage, CountPerPage, list);

		return view;
	}
	
	// 조회수
	public int hits(int iidx) {
		dao = template.getMapper(BoardDAO.class);
		return dao.hits(iidx);
	}

}
