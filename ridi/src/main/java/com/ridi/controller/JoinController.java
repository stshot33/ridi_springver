package com.ridi.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ridi.config.CtxBinder;
import com.ridi.dto.Member;
import com.ridi.service.JoinService;
import com.ridi.util.SHA256;

@Controller
@RequestMapping(value="/join")
public class JoinController {
	private static ApplicationContext ctx = null;
	
	public JoinController() {
		ctx = new AnnotationConfigApplicationContext(CtxBinder.class);
	}
	
	@RequestMapping(value="/join1", method = RequestMethod.GET)
	public String join1() {
		return "join/join1";
	}
	
	@RequestMapping(value="/join2", method = RequestMethod.GET)
	public String join2() {
		return "join/join2";
	}
	
	@RequestMapping(value="/join3", method = RequestMethod.GET)
	public String join3() {
		return "join/join3";
	}
	
	@RequestMapping(value="/join2", method = RequestMethod.POST)
	public String join2(@Valid @ModelAttribute("joininfo") Member member, Errors errors, Model model) {
		JoinService service = ctx.getBean(JoinService.class);
		
		int idStatus = service.idCheck(member);
		int EmailStatus = service.EmailChecek(member);
		
		try {
			// 값 검증
			if(errors.hasErrors()) {
				return "join/join2";
			}
			
			// 비밀번호 암호화
			String encPwd = SHA256.encrypt(member.getPwd());
			member.setPwd(encPwd);
			// 회원 가입 처리
			if(idStatus == 0 && EmailStatus == 0) {
				service.join(member);
				
				return "login/login";
			}
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "join/join2";
	}
}