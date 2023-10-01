package com.accounting.rest.report;

public class DataBean {
	private String accountName;
	private String accountTypeName;
	private String date;
	private Long debitAmount;
	private Long creditAmount;
	private Long folioNo;
	private Long folioNo2;

	public DataBean(String accountName, String accountTypeName, String date, Long debitAmount, Long creditAmount,
			Long folioNo, Long folioNo2) {
		super();
		this.accountName = accountName;
		this.accountTypeName = accountTypeName;
		this.date = date;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.folioNo = folioNo;
		this.folioNo2 = folioNo2;
	}

	public DataBean(String accountName, String accountTypeName, String date, Long debitAmount, Long creditAmount,
			Long folioNo) {
		super();
		this.accountName = accountName;
		this.accountTypeName = accountTypeName;
		this.date = date;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.folioNo = folioNo;

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

	public String getDate() {
		return date;
	}

	public Long getFolioNo2() {
		return folioNo2;
	}

	public void setFolioNo2(Long folioNo2) {
		this.folioNo2 = folioNo2;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Long debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Long getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Long creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Long getFolioNo() {
		return folioNo;
	}

	public void setFolioNo(Long folioNo) {
		this.folioNo = folioNo;
	}

//	private String name;
//	private String country;
//	private List<SubReportBean> subReportBeanList;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}

//	public List<SubReportBean> getSubReportBeanList() {
//		return subReportBeanList;
//	}
//
//	public void setSubReportBeanList(List<SubReportBean> subReportBeanList) {
//		this.subReportBeanList = subReportBeanList;
//	}
}