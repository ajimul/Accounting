package com.accounting.rest.dto;

public class CreditAccounts {
	private String accountType;
	private String accountName;

	public CreditAccounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditAccounts(String accountType, String accountName) {
		super();
		this.accountType = accountType;
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
