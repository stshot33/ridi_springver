package com.ridi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ridi.dao.MemberDao;
import com.ridi.dto.LoginMember;

public class LoginService {

	@Autowired
	private MemberDao dao;
	
	public int Login(LoginMember member) {
		
		return  dao.login(member);
	}
}
