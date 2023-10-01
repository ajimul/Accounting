package com.accounting.rest.dto;

import java.time.LocalDate;

public class InvoiceViewDTO {
	private Long accountId;
	private Long bookInfoId;
	private String accountName;
	private String partyContactNo1;
	private String partyContactNo2;
	private String partyEmailId;
	private LocalDate voucherDate;
	private Double voucherAmount;
	private String voucherType;

	public InvoiceViewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(Long bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public InvoiceViewDTO(Long accountId, Long bookInfoId, String accountName, String partyContactNo1,
			String partyContactNo2, String partyEmailId, LocalDate voucherDate, Double voucherAmount,
			String voucherType) {
		super();
		this.accountId = accountId;
		this.bookInfoId = bookInfoId;
		this.accountName = accountName;
		this.partyContactNo1 = partyContactNo1;
		this.partyContactNo2 = partyContactNo2;
		this.partyEmailId = partyEmailId;
		this.voucherDate = voucherDate;
		this.voucherAmount = voucherAmount;
		this.voucherType = voucherType;
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

	public String getPartyContactNo1() {
		return partyContactNo1;
	}

	public void setPartyContactNo1(String partyContactNo1) {
		this.partyContactNo1 = partyContactNo1;
	}

	public String getPartyContactNo2() {
		return partyContactNo2;
	}

	public void setPartyContactNo2(String partyContactNo2) {
		this.partyContactNo2 = partyContactNo2;
	}

	public String getPartyEmailId() {
		return partyEmailId;
	}

	public void setPartyEmailId(String partyEmailId) {
		this.partyEmailId = partyEmailId;
	}

	public LocalDate getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(LocalDate voucherDate) {
		this.voucherDate = voucherDate;
	}

	public Double getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(Double voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

}
