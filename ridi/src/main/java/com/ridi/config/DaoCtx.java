package com.ridi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ridi.dao.MemberDao;

@Configuration
public class DaoCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
