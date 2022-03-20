package com.ridi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ridi.service.JoinService;
import com.ridi.service.LoginService;

@Configuration
public class ServiceCtx {
	@Bean
	public JoinService joinService() {
		return new JoinService();
	}
	
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
}
