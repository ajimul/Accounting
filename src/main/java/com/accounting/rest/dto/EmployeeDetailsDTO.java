package com.accounting.rest.dto;

import java.time.LocalDate;

public class EmployeeDetailsDTO {
	private Long accountId;
	private String accountName;
	private Long empDetailsId;
	private Long emp_ac_refId;
	private String empContactNo1;
	private String empContactNo2;
	private String empEmailId;
	private String empGstNo;
	private String empBillingAddress;
	private String empShipingAddress;
	private Long empOpeningBalance;
	private String empAreaCode;
	private LocalDate empDob;
	private String empBloodGroup;
	private String empJobeDesignation;
	private LocalDate empJoiningDate;
	private String empSalaryPackage;
	private String empAadharNo;
	private String empPanNo;

	public EmployeeDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetailsDTO(Long accountId, String accountName, Long empDetailsId, Long emp_ac_refId,
			String empContactNo1, String empContactNo2, String empEmailId, String empGstNo, String empBillingAddress,
			String empShipingAddress, Long empOpeningBalance, String empAreaCode, LocalDate empDob,
			String empBloodGroup, String empJobeDesignation, LocalDate empJoiningDate, String empSalaryPackage,
			String empAadharNo, String empPanNo) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.empDetailsId = empDetailsId;
		this.emp_ac_refId = emp_ac_refId;
		this.empContactNo1 = empContactNo1;
		this.empContactNo2 = empContactNo2;
		this.empEmailId = empEmailId;
		this.empGstNo = empGstNo;
		this.empBillingAddress = empBillingAddress;
		this.empShipingAddress = empShipingAddress;
		this.empOpeningBalance = empOpeningBalance;
		this.empAreaCode = empAreaCode;
		this.empDob = empDob;
		this.empBloodGroup = empBloodGroup;
		this.empJobeDesignation = empJobeDesignation;
		this.empJoiningDate = empJoiningDate;
		this.empSalaryPackage = empSalaryPackage;
		this.empAadharNo = empAadharNo;
		this.empPanNo = empPanNo;
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

	public Long getEmpDetailsId() {
		return empDetailsId;
	}

	public void setEmpDetailsId(Long empDetailsId) {
		this.empDetailsId = empDetailsId;
	}

	public Long getEmp_ac_refId() {
		return emp_ac_refId;
	}

	public void setEmp_ac_refId(Long emp_ac_refId) {
		this.emp_ac_refId = emp_ac_refId;
	}

	public String getEmpContactNo1() {
		return empContactNo1;
	}

	public void setEmpContactNo1(String empContactNo1) {
		this.empContactNo1 = empContactNo1;
	}

	public String getEmpContactNo2() {
		return empContactNo2;
	}

	public void setEmpContactNo2(String empContactNo2) {
		this.empContactNo2 = empContactNo2;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpGstNo() {
		return empGstNo;
	}

	public void setEmpGstNo(String empGstNo) {
		this.empGstNo = empGstNo;
	}

	public String getEmpBillingAddress() {
		return empBillingAddress;
	}

	public void setEmpBillingAddress(String empBillingAddress) {
		this.empBillingAddress = empBillingAddress;
	}

	public String getEmpShipingAddress() {
		return empShipingAddress;
	}

	public void setEmpShipingAddress(String empShipingAddress) {
		this.empShipingAddress = empShipingAddress;
	}

	public Long getEmpOpeningBalance() {
		return empOpeningBalance;
	}

	public void setEmpOpeningBalance(Long empOpeningBalance) {
		this.empOpeningBalance = empOpeningBalance;
	}

	public String getEmpAreaCode() {
		return empAreaCode;
	}

	public void setEmpAreaCode(String empAreaCode) {
		this.empAreaCode = empAreaCode;
	}

	public LocalDate getEmpDob() {
		return empDob;
	}

	public void setEmpDob(LocalDate empDob) {
		this.empDob = empDob;
	}

	public String getEmpBloodGroup() {
		return empBloodGroup;
	}

	public void setEmpBloodGroup(String empBloodGroup) {
		this.empBloodGroup = empBloodGroup;
	}

	public String getEmpJobeDesignation() {
		return empJobeDesignation;
	}

	public void setEmpJobeDesignation(String empJobeDesignation) {
		this.empJobeDesignation = empJobeDesignation;
	}

	public LocalDate getEmpJoiningDate() {
		return empJoiningDate;
	}

	public void setEmpJoiningDate(LocalDate empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}

	public String getEmpSalaryPackage() {
		return empSalaryPackage;
	}

	public void setEmpSalaryPackage(String empSalaryPackage) {
		this.empSalaryPackage = empSalaryPackage;
	}

	public String getEmpAadharNo() {
		return empAadharNo;
	}

	public void setEmpAadharNo(String empAadharNo) {
		this.empAadharNo = empAadharNo;
	}

	public String getEmpPanNo() {
		return empPanNo;
	}

	public void setEmpPanNo(String empPanNo) {
		this.empPanNo = empPanNo;
	}

}
