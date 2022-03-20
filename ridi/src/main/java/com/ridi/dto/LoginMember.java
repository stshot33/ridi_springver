package com.ridi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class LoginMember {
	@NotNull
	private String id;
	@NotNull
	private String pwd;
	private LocalDateTime loginDate;

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

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

}