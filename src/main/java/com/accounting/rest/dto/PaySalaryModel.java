package com.accounting.rest.dto;

import java.time.LocalDate;

public class PaySalaryModel {
	private Long userId;
	private Long accountId;
	private String employeeAcName;
	private LocalDate transectionDate;
	private String narration;
	private TransectionalAccountsModel transectionalAccounts;

	public PaySalaryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaySalaryModel(Long userId, Long accountId, String employeeAcName, LocalDate transectionDate,
			String narration, TransectionalAccountsModel transectionalAccounts) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.employeeAcName = employeeAcName;
		this.transectionDate = transectionDate;
		this.narration = narration;
		this.transectionalAccounts = transectionalAccounts;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmployeeAcName() {
		return employeeAcName;
	}

	public void setEmployeeAcName(String employeeAcName) {
		this.employeeAcName = employeeAcName;
	}

	public LocalDate getTransectionDate() {
		return transectionDate;
	}

	public void setTransectionDate(LocalDate transectionDate) {
		this.transectionDate = transectionDate;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public TransectionalAccountsModel getTransectionalAccounts() {
		return transectionalAccounts;
	}

	public void setTransectionalAccounts(TransectionalAccountsModel transectionalAccounts) {
		this.transectionalAccounts = transectionalAccounts;
	}

}
