package com.accounting.rest.dto;

import java.time.LocalDate;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmiSmsConfig {
	private Long accountId;
	private String accountName;
	private Long emiId;
	private Long emiNo;
	private Double emiAmount;
	private String emiStatus;
	private LocalDate emiDate;
	private String emiMessage;
	private boolean emiSmsStatus;
	private Long emi_BiId;

	public EmiSmsConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmiSmsConfig(Long accountId, String accountName, Long emiId, Long emiNo, Double emiAmount, String emiStatus,
			LocalDate emiDate, String emiMessage, boolean emiSmsStatus, Long emi_BiId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.emiId = emiId;
		this.emiNo = emiNo;
		this.emiAmount = emiAmount;
		this.emiStatus = emiStatus;
		this.emiDate = emiDate;
		this.emiMessage = emiMessage;
		this.emiSmsStatus = emiSmsStatus;
		this.emi_BiId = emi_BiId;
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

	public Long getEmiId() {
		return emiId;
	}

	public void setEmiId(Long emiId) {
		this.emiId = emiId;
	}

	public Long getEmiNo() {
		return emiNo;
	}

	public void setEmiNo(Long emiNo) {
		this.emiNo = emiNo;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public String getEmiStatus() {
		return emiStatus;
	}

	public void setEmiStatus(String emiStatus) {
		this.emiStatus = emiStatus;
	}

	public LocalDate getEmiDate() {
		return emiDate;
	}

	public void setEmiDate(LocalDate emiDate) {
		this.emiDate = emiDate;
	}

	public String getEmiMessage() {
		return emiMessage;
	}

	public void setEmiMessage(String emiMessage) {
		this.emiMessage = emiMessage;
	}

	public boolean isEmiSmsStatus() {
		return emiSmsStatus;
	}

	public void setEmiSmsStatus(boolean emiSmsStatus) {
		this.emiSmsStatus = emiSmsStatus;
	}

	public Long getEmi_BiId() {
		return emi_BiId;
	}

	public void setEmi_BiId(Long emi_BiId) {
		this.emi_BiId = emi_BiId;
	}

}