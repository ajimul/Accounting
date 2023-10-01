package com.accounting.rest.dto;

import java.time.LocalDate;

public class GenericsJournalDetails {
	private String accountName;
	private String accountTypeName;
	private LocalDate date;
	private Double debitAmount;
	private Double creditAmount;
	private Long folioNo;

	public GenericsJournalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Long getFolioNo() {
		return folioNo;
	}

	public void setFolioNo(Long folioNo) {
		this.folioNo = folioNo;
	}

	public GenericsJournalDetails(String accountName, String accountTypeName, LocalDate date, Double debitAmount,
			Double creditAmount, Long folioNo) {
		super();
		this.accountName = accountName;
		this.accountTypeName = accountTypeName;
		this.date = date;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.folioNo = folioNo;
	}

}
