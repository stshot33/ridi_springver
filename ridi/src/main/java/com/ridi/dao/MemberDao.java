package com.ridi.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ridi.dto.LoginMember;
import com.ridi.dto.Member;

public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 회원가입
	public int join(Member memberDTO) {
		LocalDateTime now = LocalDateTime.now();
		
		jdbcTemplate.update("INSERT INTO memberinfo(member_Id, member_Pw, member_Email, member_Name, member_Year, member_Sex, member_SignDate, member_LoginDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
							memberDTO.getId(), memberDTO.getPwd(), memberDTO.getMail(), memberDTO.getName(), memberDTO.getBirthday(), memberDTO.getGender(), Timestamp.valueOf(now), Timestamp.valueOf(now));
		
		return 0;
	}
	
	// 아이디 중복 체크
	public int idCheck(Member memberDTO) {
		
		try {
			int result = jdbcTemplate.queryForObject("SELECT member_value FROM memberinfo WHERE member_Id = ?", Integer.class ,memberDTO.getId());
			
			return result;
		} catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	// 이메일 중복 체크
	public int EmailCheck(Member memberDTO) {
		try {
			int result = jdbcTemplate.queryForObject("SELECT member_value FROM memberinfo WHERE member_Email = ?", Integer.class ,memberDTO.getMail()); 
			
			return result;
		} catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	// 로그인
	public int login(LoginMember memberDTO) {
		try {
			int result = jdbcTemplate.queryForObject("SELECT member_value FROM memberinfo WHERE member_Id = ? AND member_Pw = ?", Integer.class, memberDTO.getId(), memberDTO.getPwd());
			
			return result;
		} catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST.value();
		}
	}
}