package com.accounting.rest.dto;

public class GenericsUser {

	private Long userId;
	private String userName;

	public GenericsUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsUser(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public GenericsUser(String userName) {
		super();
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
