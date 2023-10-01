package com.accounting.rest.dto;

public class TransectionalAccountsModel {
	private String transactionAccountName;
	private Double transactionAmount;

	public TransectionalAccountsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransectionalAccountsModel(String transactionAccountName, Double transactionAmount) {
		super();
		this.transactionAccountName = transactionAccountName;
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionAccountName() {
		return transactionAccountName;
	}

	public void setTransactionAccountName(String transactionAccountName) {
		this.transactionAccountName = transactionAccountName;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
