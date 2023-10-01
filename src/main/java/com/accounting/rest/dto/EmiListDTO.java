package com.accounting.rest.dto;

import java.time.LocalDate;

public class EmiListDTO {
	private Long accountId;
	private String accountName;
	private Long partyDetailsId;
	private Long party_ac_refId;
	private String partyContactNo1;
	private String partyContactNo2;
	private String partyEmailId;
	private String partyGstNo;
	private String partyBillingAddress;
	private String partyShipingAddress;
	private Double partyOpeningBalance;
	private String partyAreaCode;
	private LocalDate partyDob;
	private String partyBloodGroup;
	private String partyAadharNo;
	private String partyPanNo;
	private long bookInfoId;
	private long bookInfoType_Ref;
	private Long bookInfoFolio_Ref;
	private LocalDate bookInfoDate;
	private Long emiId;
	private Long emiNo;
	private Double emiAmount;
	private String emiStatus;
	private LocalDate emiDate;
	private String emiMessage;
	private boolean emiSmsStatus;
	private Long emi_BiId;

	public EmiListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmiListDTO(Long accountId, String accountName, Long partyDetailsId, Long party_ac_refId,
			String partyContactNo1, String partyContactNo2, String partyEmailId, String partyGstNo,
			String partyBillingAddress, String partyShipingAddress, Double partyOpeningBalance, String partyAreaCode,
			LocalDate partyDob, String partyBloodGroup, String partyAadharNo, String partyPanNo, long bookInfoId,
			long bookInfoType_Ref, Long bookInfoFolio_Ref, LocalDate bookInfoDate, Long emiId, Long emiNo,
			Double emiAmount, String emiStatus, LocalDate emiDate, String emiMessage, boolean emiSmsStatus,
			Long emi_BiId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.partyDetailsId = partyDetailsId;
		this.party_ac_refId = party_ac_refId;
		this.partyContactNo1 = partyContactNo1;
		this.partyContactNo2 = partyContactNo2;
		this.partyEmailId = partyEmailId;
		this.partyGstNo = partyGstNo;
		this.partyBillingAddress = partyBillingAddress;
		this.partyShipingAddress = partyShipingAddress;
		this.partyOpeningBalance = partyOpeningBalance;
		this.partyAreaCode = partyAreaCode;
		this.partyDob = partyDob;
		this.partyBloodGroup = partyBloodGroup;
		this.partyAadharNo = partyAadharNo;
		this.partyPanNo = partyPanNo;
		this.bookInfoId = bookInfoId;
		this.bookInfoType_Ref = bookInfoType_Ref;
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
		this.bookInfoDate = bookInfoDate;
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

	public Long getPartyDetailsId() {
		return partyDetailsId;
	}

	public void setPartyDetailsId(Long partyDetailsId) {
		this.partyDetailsId = partyDetailsId;
	}

	public Long getParty_ac_refId() {
		return party_ac_refId;
	}

	public void setParty_ac_refId(Long party_ac_refId) {
		this.party_ac_refId = party_ac_refId;
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

	public String getPartyGstNo() {
		return partyGstNo;
	}

	public void setPartyGstNo(String partyGstNo) {
		this.partyGstNo = partyGstNo;
	}

	public String getPartyBillingAddress() {
		return partyBillingAddress;
	}

	public void setPartyBillingAddress(String partyBillingAddress) {
		this.partyBillingAddress = partyBillingAddress;
	}

	public String getPartyShipingAddress() {
		return partyShipingAddress;
	}

	public void setPartyShipingAddress(String partyShipingAddress) {
		this.partyShipingAddress = partyShipingAddress;
	}

	public Double getPartyOpeningBalance() {
		return partyOpeningBalance;
	}

	public void setPartyOpeningBalance(Double partyOpeningBalance) {
		this.partyOpeningBalance = partyOpeningBalance;
	}

	public String getPartyAreaCode() {
		return partyAreaCode;
	}

	public void setPartyAreaCode(String partyAreaCode) {
		this.partyAreaCode = partyAreaCode;
	}

	public LocalDate getPartyDob() {
		return partyDob;
	}

	public void setPartyDob(LocalDate partyDob) {
		this.partyDob = partyDob;
	}

	public String getPartyBloodGroup() {
		return partyBloodGroup;
	}

	public void setPartyBloodGroup(String partyBloodGroup) {
		this.partyBloodGroup = partyBloodGroup;
	}

	public String getPartyAadharNo() {
		return partyAadharNo;
	}

	public void setPartyAadharNo(String partyAadharNo) {
		this.partyAadharNo = partyAadharNo;
	}

	public String getPartyPanNo() {
		return partyPanNo;
	}

	public void setPartyPanNo(String partyPanNo) {
		this.partyPanNo = partyPanNo;
	}

	public long getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(long bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public long getBookInfoType_Ref() {
		return bookInfoType_Ref;
	}

	public void setBookInfoType_Ref(long bookInfoType_Ref) {
		this.bookInfoType_Ref = bookInfoType_Ref;
	}

	public Long getBookInfoFolio_Ref() {
		return bookInfoFolio_Ref;
	}

	public void setBookInfoFolio_Ref(Long bookInfoFolio_Ref) {
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
	}

	public LocalDate getBookInfoDate() {
		return bookInfoDate;
	}

	public void setBookInfoDate(LocalDate bookInfoDate) {
		this.bookInfoDate = bookInfoDate;
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