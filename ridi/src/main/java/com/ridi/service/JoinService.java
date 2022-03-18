package com.ridi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ridi.dao.MemberDao;
import com.ridi.dto.Member;
import com.ridi.util.Check.BlankDelete;

public class JoinService {
	BlankDelete blank = new BlankDelete();
	
	@Autowired
	private MemberDao dao;
	
	public int idCheck(Member member) {
		return dao.idCheck(member);
	}
	
	public int EmailChecek(Member member) {
		return dao.EmailCheck(member);
	}
	
	public int join(Member member) {
		
		dao.join(member);
		
		return HttpStatus.CREATED.value();
	}
}
