package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class PartyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_partyDetails", allocationSize = 1)
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

	public PartyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartyDetails(Long partyDetailsId, Long party_ac_refId, String partyContactNo1, String partyContactNo2,
			String partyEmailId, String partyGstNo, String partyBillingAddress, String partyShipingAddress,
			Double partyOpeningBalance, String partyAreaCode, LocalDate partyDob, String partyBloodGroup,
			String partyAadharNo, String partyPanNo) {
		super();
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

}
