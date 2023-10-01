package com.accounting.rest.dto;

public class TransactionalAccountDTO {
	private Long accountId;
	private String accountName;

	public TransactionalAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionalAccountDTO(Long accountId, String accountName) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
