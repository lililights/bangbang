package com.bitwin.bangbang.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.service.MailSenderService;
import com.bitwin.bangbang.member.service.RamdomPassword;
import com.bitwin.bangbang.store.dao.StoreDao;
import com.bitwin.bangbang.store.domain.Store;
import com.bitwin.bangbang.store.domain.StoreEditRequest;
import com.bitwin.bangbang.store.domain.StoreEditRequestList;
import com.bitwin.bangbang.store.domain.StoreRegRequest;

@Service
public class AdminStoreService {
	private StoreDao dao;

	@Autowired
	private SqlSessionTemplate template;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private MailSenderService mailSender;

	@Autowired
	private RamdomPassword randomPw;

	public int insertStore(StoreRegRequest regRequest) {
		int resultCnt = 0;

		// 임시 비밀번호 생성
		String pw = randomPw.getRamdomPassword(8);

		// 임시 비밀번호를 암호화 하여 DB에 저장
		String bPw = bcrypt.encode(pw);
		regRequest.setPhoto("storedefault.jpg");
		regRequest.setStorePw(bPw);

		dao = template.getMapper(StoreDao.class);

		resultCnt = dao.insertStore(regRequest);

		if (resultCnt > 0) {
			// 가맹점 등록 성공
			// 사업자의 이메일로 가맹점 등록 정보를 전송
			if (mailSender.sendStore(regRequest, pw) > 0) {
				System.out.println("메일 발송 성공");
			} else {
				System.out.println("메일 발송 실패");
			}
		} else {
			System.out.println("가맹점 등록 실패");
		}

		return resultCnt;
	}

	public List<Store> selectAll() {
		List<Store> store = null;

		dao = template.getMapper(StoreDao.class);

		store = dao.selectAll();

		return store;
	}

	// 가맹점 아이디 중복 체크
	public String checkStoreId(String storeId) {
		String result = "";

		dao = template.getMapper(StoreDao.class);

		int count = dao.selectByStoreId(storeId);

		if (count > 0) {
			result = "N";
		} else {
			result = "Y";
		}
		return result;

	}

	public Store storeDetial(String sname) {
		Store store = null;

		dao = template.getMapper(StoreDao.class);

		store = dao.selectBySname(sname);

		return store;
	}

	public List<StoreEditRequestList> selectEditRequest() {
		List<StoreEditRequestList> store = null;
		dao = template.getMapper(StoreDao.class);
		
		store = dao.selectEditRequestList();
		
		return store;
	}

	public StoreEditRequest getEditRequest(int sridx) {
		
		StoreEditRequest storeReq = null;
		
		dao = template.getMapper(StoreDao.class);
		
		storeReq = dao.selectStoreEditReq(sridx);
		
		return storeReq;
	}

	public int acceptEditRequest(StoreEditRequest editRequest) {
		int resultCnt = 0;
		
		dao = template.getMapper(StoreDao.class);
		
		resultCnt = dao.updateStore(editRequest);
		
		if(resultCnt > 0) {
			// 성공적으로 update 되었으므로 요청 리스트 에서 삭제
			dao.deleteEditReq(editRequest.getSidx());
		}
		
		return resultCnt;
	}

}
