package com.accounting.rest.dto;

import java.time.LocalDate;

public class ProductServiceSmsConfig {
	private Long accountId;
	private String accountName;
	private Long psId;
	private Long ps_Id;
	private String psEngineerName;
	private Integer psNo;
	private LocalDate psDate;
	private String psStatus;
	private String psMessage;
	private boolean psSmsStatus;

	public ProductServiceSmsConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceSmsConfig(Long accountId, String accountName, Long psId, Long ps_Id, String psEngineerName,
			Integer psNo, LocalDate psDate, String psStatus, String psMessage, boolean psSmsStatus) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.psId = psId;
		this.ps_Id = ps_Id;
		this.psEngineerName = psEngineerName;
		this.psNo = psNo;
		this.psDate = psDate;
		this.psStatus = psStatus;
		this.psMessage = psMessage;
		this.psSmsStatus = psSmsStatus;
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

	public Long getPsId() {
		return psId;
	}

	public void setPsId(Long psId) {
		this.psId = psId;
	}

	public Long getPs_Id() {
		return ps_Id;
	}

	public void setPs_Id(Long ps_Id) {
		this.ps_Id = ps_Id;
	}

	public String getPsEngineerName() {
		return psEngineerName;
	}

	public void setPsEngineerName(String psEngineerName) {
		this.psEngineerName = psEngineerName;
	}

	public Integer getPsNo() {
		return psNo;
	}

	public void setPsNo(Integer psNo) {
		this.psNo = psNo;
	}

	public LocalDate getPsDate() {
		return psDate;
	}

	public void setPsDate(LocalDate psDate) {
		this.psDate = psDate;
	}

	public String getPsStatus() {
		return psStatus;
	}

	public void setPsStatus(String psStatus) {
		this.psStatus = psStatus;
	}

	public String getPsMessage() {
		return psMessage;
	}

	public void setPsMessage(String psMessage) {
		this.psMessage = psMessage;
	}

	public boolean isPsSmsStatus() {
		return psSmsStatus;
	}

	public void setPsSmsStatus(boolean psSmsStatus) {
		this.psSmsStatus = psSmsStatus;
	}

}