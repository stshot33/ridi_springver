package com.ridi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ridi.dto.Member;

public class MemberRegValidator implements Validator {

	// 아이디 - 영문 소문자, 숫자 / 영문 소문자 / 숫자
	private static final String idRegExp = "^[a-z[0-9]]{5,20}$" + "^[a-z]{5,20}$" + "^[0-9]{5,20}$";
//			// 비밀번호 - 영문, 숫자, 특수문자 / 영문, 숫자 / 숫자, 특수문자 / 영문, 특수문자 / 같은 문자 3번 연속
//			private static final String pwRegExp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$" 
//													+ "^[A-Za-z[0-9]]{8,}$" 
//													+ "^[[0-9]$@$!%*#?&]{8,}$" 
//													+ "^[[A-Za-z]$@$!%*#?&]{8,}$" 
//													+ "(\\S)\\1\\1";  
//			// 이메일 
//			private static final String mailRegExp =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
//													  +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//			// 이름
//			private static final String nameRegExp = "^[가-힣A-Za-z]{2,}$";

	private Pattern pattern;

	public void RequestValidator() {
		pattern = Pattern.compile(idRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member memberdto = (Member) target;

		if (memberdto.getId() == null || memberdto.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
		} else {
			Matcher m = pattern.matcher(memberdto.getId());
			if (!m.matches()) {
				errors.rejectValue("id", "bad");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwdCheck", "required");
		if(!memberdto.getPwd().isEmpty()) {
			if(!memberdto.Checkpassword()) {
				errors.rejectValue("pwdCheck", "notmatch");
			}
		}
	}

}
