package com.ridi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Member {
	@NotNull
	private String id;
	@NotNull
	private String pwd;
	@NotNull
	private String pwdCheck;
	@NotBlank
	@Email
	private String mail;
	@NotNull
	private String name;
	private int birthday;
	private String gender;
	private LocalDateTime signDate;
	private LocalDateTime loginDate;

	public boolean Checkpassword() {
		return pwd.equals(pwdCheck);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdCheck() {
		return pwdCheck;
	}

	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDateTime signDate) {
		this.signDate = signDate;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}
}