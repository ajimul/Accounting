package com.accounting.rest.dto;

public class SMSModel {
	private String contactNo;
	private String message;

	public SMSModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SMSModel(String contactNo, String message) {
		super();
		this.contactNo = contactNo;
		this.message = message;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
