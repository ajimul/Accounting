package com.accounting.rest.dto;

public class ProductServiceModel {
	private String lsEngineerName;// accountId
	private Long lsServiceNo;
	private String lsDate;
	private String lsStatus;
	private String lsMessage;

	public ProductServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceModel(String lsEngineerName, Long lsServiceNo, String lsDate, String lsStatus,
			String lsMessage) {
		super();
		this.lsEngineerName = lsEngineerName;
		this.lsServiceNo = lsServiceNo;
		this.lsDate = lsDate;
		this.lsStatus = lsStatus;
		this.lsMessage = lsMessage;

	}

	public String getLsEngineerName() {
		return lsEngineerName;
	}

	public void setLsEngineerName(String lsEngineerName) {
		this.lsEngineerName = lsEngineerName;
	}

	public Long getLsServiceNo() {
		return lsServiceNo;
	}

	public void setLsServiceNo(Long lsServiceNo) {
		this.lsServiceNo = lsServiceNo;
	}

	public String getLsDate() {
		return lsDate;
	}

	public void setLsDate(String lsDate) {
		this.lsDate = lsDate;
	}

	public String getLsStatus() {
		return lsStatus;
	}

	public void setLsStatus(String lsStatus) {
		this.lsStatus = lsStatus;
	}

	public String getLsMessage() {
		return lsMessage;
	}

	public void setLsMessage(String lsMessage) {
		this.lsMessage = lsMessage;
	}

}
