package com.ridi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ridi.service.JoinService;

@Configuration
public class ServiceCtx {
	@Bean
	public JoinService joinService() {
		return new JoinService();
	}
}
