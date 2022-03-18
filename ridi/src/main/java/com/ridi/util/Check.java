package com.ridi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ridi.dto.Member;

public class Check {

	public static class BlankDelete {
		
		public void StringDelete(String data) {
			data = data.trim();
			data = data.replace(" ", "");
		}
	}
	
	/*
		// 아이디 확인
		Matcher i;

		public boolean idcheck(String id) {
			boolean confirm = false;

			i = Pattern.compile(IdPattern1).matcher(id);
			if (i.find()) {
				confirm = true;
			}

			i = Pattern.compile(IdPattern2).matcher(id);
			if (i.find()) {
				confirm = true;
			}

			i = Pattern.compile(IdPattern3).matcher(id);
			if (i.find()) {
				confirm = true;
			}

			return confirm;
		}

		// 비밀번호 확인
		Matcher m;

		public boolean pwcheck(String pwd) {
			boolean check = false;
			// 영문, 숫자, 특수문자
			m = Pattern.compile(pwpattern1).matcher(pwd);
			if (m.find()) {
				check = true;
			}
			// 영문, 숫자
			m = Pattern.compile(pwpattern2).matcher(pwd);
			if (m.find()) {
				check = true;
			}
			// 숫자, 특수문자
			m = Pattern.compile(pwpattern3).matcher(pwd);
			if (m.find()) {
				check = true;
			}
			// 영문, 특수문자
			m = Pattern.compile(pwpattern4).matcher(pwd);
			if (m.find()) {
				check = true;
			}
			// 같은 문자 3번 연속
			m = Pattern.compile(pwpattern5).matcher(pwd);
			if (m.find()) {
				check = false;
			}

			return check;
		}

		// 이메일 형식 체크
		Matcher e;

		String Epattern = "(\\S+)@(\\w+).(\\w+)";

		public boolean mailcheck(String email) {
			boolean echeck = false;

			e = Pattern.compile(Epattern).matcher(email);
			if (e.find()) {
				echeck = true;
			}

			return echeck;
		}
		
		// 이름 확인
		Matcher n;

		String npattern = "^[가-힣A-Za-z]{2,}$";

		public boolean namecheck(String name) {
			boolean ncheck = false;

			n = Pattern.compile(npattern).matcher(name);
			if (n.find()) {
				ncheck = true;
			}

			return ncheck;
		}
	}
	*/
}