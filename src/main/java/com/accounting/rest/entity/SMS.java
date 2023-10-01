package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SMS {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_sms", allocationSize = 1)
	private Long smsId;
	private Long partyId;
	private String partyName;
	private Long partyDetailsId;
	private String partyContactNo1;
	private String partyContactNo2;
	private String partyEmailId;

	private Double partyEmiAmount;
	private LocalDate partyEmiDate;
	private String partyEmiMessage;
	private Long partyEmiNo;
	private String partyEmiStatus;

	public SMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SMS(Long smsId, Long partyId, String partyName, Long partyDetailsId, String partyContactNo1,
			String partyContactNo2, String partyEmailId, Double partyEmiAmount, LocalDate partyEmiDate,
			String partyEmiMessage, Long partyEmiNo, String partyEmiStatus) {
		super();
		this.smsId = smsId;
		this.partyId = partyId;
		this.partyName = partyName;
		this.partyDetailsId = partyDetailsId;
		this.partyContactNo1 = partyContactNo1;
		this.partyContactNo2 = partyContactNo2;
		this.partyEmailId = partyEmailId;
		this.partyEmiAmount = partyEmiAmount;
		this.partyEmiDate = partyEmiDate;
		this.partyEmiMessage = partyEmiMessage;
		this.partyEmiNo = partyEmiNo;
		this.partyEmiStatus = partyEmiStatus;
	}

	public Long getSmsId() {
		return smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Long getPartyDetailsId() {
		return partyDetailsId;
	}

	public void setPartyDetailsId(Long partyDetailsId) {
		this.partyDetailsId = partyDetailsId;
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

	public Double getPartyEmiAmount() {
		return partyEmiAmount;
	}

	public void setPartyEmiAmount(Double partyEmiAmount) {
		this.partyEmiAmount = partyEmiAmount;
	}

	public LocalDate getPartyEmiDate() {
		return partyEmiDate;
	}

	public void setPartyEmiDate(LocalDate partyEmiDate) {
		this.partyEmiDate = partyEmiDate;
	}

	public String getPartyEmiMessage() {
		return partyEmiMessage;
	}

	public void setPartyEmiMessage(String partyEmiMessage) {
		this.partyEmiMessage = partyEmiMessage;
	}

	public Long getPartyEmiNo() {
		return partyEmiNo;
	}

	public void setPartyEmiNo(Long partyEmiNo) {
		this.partyEmiNo = partyEmiNo;
	}

	public String getPartyEmiStatus() {
		return partyEmiStatus;
	}

	public void setPartyEmiStatus(String partyEmiStatus) {
		this.partyEmiStatus = partyEmiStatus;
	}

}
