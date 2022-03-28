package com.bitwin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitwin.domain.paqVO;
import com.bitwin.domain.Criteria;
import com.bitwin.mapper.paqMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class paqServiceImpl implements paqService {
	
	//Spring 4.3 이상에서 자동 처리
	private paqMapper mapper;
	
	@Override
	public void register(paqVO paq) {
		log.info("register......" + paq);
		mapper.insertSelectKey(paq);
		
	}
	
	@Override
	public List<paqVO> memberGetList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.memberGetListWithPaging(cri);
		
	}
	
	@Override
	public List<paqVO> adminGetList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.adminGetListWithPaging(cri);
		
	}
	
	
	
	@Override
	public paqVO get(int pqidx) {
		
		log.info("get......" + pqidx);
		
		return mapper.read(pqidx);
		
	}
	
	@Override
	public boolean modify(paqVO paq) {
		
		log.info("modify....." + paq);
		
		return mapper.update(paq) == 1;
		
	}
	
	@Override
	public boolean remove(int pqidx) {
		
		log.info("remove...." + pqidx);
		
		return mapper.delete(pqidx)==1;
	}
	
	@Override
	public int memberGetTotal(Criteria cri) {
		
		log.info("get total count");
		
		return mapper.memberGetTotalCount(cri);
	}
	
	@Override
	public int adminGetTotal(Criteria cri) {
		
		log.info("get total count");
		
		return mapper.adminGetTotalCount(cri);
	}
	
	@Override
	public String getEmail(int uidx) {
		
		log.info("get email");
		return mapper.getEmail(uidx);
	}
	
	
	@Override
	public String getPhoneNum(int uidx) {
		
		log.info("get phoneNumber");
		return mapper.getPhoneNum(uidx);
	}
	
	
	
	
	
	
}
