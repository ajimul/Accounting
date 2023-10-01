package com.accounting.rest.dto;

import java.time.LocalDate;

import com.accounting.rest.entity.Emi;

public class PayEmiModel {
	private Long userId;
	private Long accountId;
	private String partyAcName;
	private LocalDate transectionDate;
	private String narration;
	private Emi emi;
	private TransectionalAccountsModel transectionalAccounts;

	public PayEmiModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayEmiModel(Long userId, Long accountId, String partyAcName, LocalDate transectionDate, String narration,
			Emi emi, TransectionalAccountsModel transectionalAccounts) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.partyAcName = partyAcName;
		this.transectionDate = transectionDate;
		this.narration = narration;
		this.emi = emi;
		this.transectionalAccounts = transectionalAccounts;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getPartyAcName() {
		return partyAcName;
	}

	public void setPartyAcName(String partyAcName) {
		this.partyAcName = partyAcName;
	}

	public LocalDate getTransectionDate() {
		return transectionDate;
	}

	public void setTransectionDate(LocalDate transectionDate) {
		this.transectionDate = transectionDate;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Emi getEmi() {
		return emi;
	}

	public void setEmi(Emi emi) {
		this.emi = emi;
	}

	public TransectionalAccountsModel getTransectionalAccounts() {
		return transectionalAccounts;
	}

	public void setTransectionalAccounts(TransectionalAccountsModel transectionalAccounts) {
		this.transectionalAccounts = transectionalAccounts;
	}

	@Override
	public String toString() {
		return "PayEmiModel [userId=" + userId + ", accountId=" + accountId + ", partyAcName=" + partyAcName
				+ ", transectionDate=" + transectionDate + ", narration=" + narration + ", emi=" + emi
				+ ", transectionalAccounts=" + transectionalAccounts + "]";
	}

}
