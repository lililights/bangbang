package com.bitwin.bangbang.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.EditMember;
import com.bitwin.bangbang.member.domain.Member;

@Service
public class MemberEditService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public Member getMember(int uidx) {
		dao = template.getMapper(MemberDao.class);
		return dao.selectByIdx(uidx);
	}

	public int editMember(EditMember editMember, HttpServletRequest req) throws IllegalStateException, IOException {
		int resultCnt = 0;

		File newFile = null;
		
		if (!(editMember.getPhoto() == null) && editMember.getPhoto().getSize() > 0) {
			String savePath = req.getSession().getServletContext().getRealPath(CommonsData.SAVE_URL);
			String[] files = editMember.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			editMember.getPhoto().transferTo(newFile);
			editMember.setPhotoName(newFileName);
		}else {
			editMember.setPhotoName(editMember.getOldPhoto());
		}

		try {
			dao = template.getMapper(MemberDao.class);
			resultCnt = dao.editMember(editMember);
			System.out.println("성공");
		} catch (Exception e) {
			// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제
			if (newFile != null && newFile.exists()) {
				newFile.delete();
				System.out.println(e);
				System.out.println("실패");
			}
		}

		return resultCnt;
	}

}
