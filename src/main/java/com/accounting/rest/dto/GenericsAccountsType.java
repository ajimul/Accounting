package com.accounting.rest.dto;

public class GenericsAccountsType {
	private Long accountTypeId;
	private String accountTypeName;
	private String accountTypeDebitAmount;
	private String accountTypeCreditAmount;

	public GenericsAccountsType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsAccountsType(Long accountTypeId, String accountTypeName, String accountTypeDebitAmount,
			String accountTypeCreditAmount) {
		super();
		this.accountTypeId = accountTypeId;
		this.accountTypeName = accountTypeName;
		this.accountTypeDebitAmount = accountTypeDebitAmount;
		this.accountTypeCreditAmount = accountTypeCreditAmount;
	}

	public GenericsAccountsType(String accountTypeName, String accountTypeDebitAmount, String accountTypeCreditAmount) {
		super();
		this.accountTypeName = accountTypeName;
		this.accountTypeDebitAmount = accountTypeDebitAmount;
		this.accountTypeCreditAmount = accountTypeCreditAmount;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getAccountTypeDebitAmount() {
		return accountTypeDebitAmount;
	}

	public void setAccountTypeDebitAmount(String accountTypeDebitAmount) {
		this.accountTypeDebitAmount = accountTypeDebitAmount;
	}

	public String getAccountTypeCreditAmount() {
		return accountTypeCreditAmount;
	}

	public void setAccountTypeCreditAmount(String accountTypeCreditAmount) {
		this.accountTypeCreditAmount = accountTypeCreditAmount;
	}

}
