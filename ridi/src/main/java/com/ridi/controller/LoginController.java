package com.ridi.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ridi.config.CtxBinder;
import com.ridi.dto.LoginMember;
import com.ridi.service.LoginService;
import com.ridi.util.SHA256;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	private static ApplicationContext ctx = null;
	
	public LoginController() {
		ctx = new AnnotationConfigApplicationContext(CtxBinder.class);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("logininfo") LoginMember member, Errors errors, Model model) {
		LoginService service = ctx.getBean(LoginService.class);
		
		try {
			// 비밀번호 암호화
			String encPwd = SHA256.encrypt(member.getPwd());
			member.setPwd(encPwd);
			
			// 로그인
			if(service.Login(member) != 400) {
				return "main/main";
			}
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "login/login";
	}
}
