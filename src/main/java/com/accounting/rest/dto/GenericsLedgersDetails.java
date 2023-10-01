package com.accounting.rest.dto;

import java.time.LocalDate;

//@Entity
public class GenericsLedgersDetails {
//	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
//	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ac", allocationSize = 1)

	private Long ledgerDetailsId;
	private String ledgerAccountName;
	private String ledgerAccountType;
	private LocalDate ledgerDetailsDate;
	private Double ledgerDetailsDebitAmount;
	private Double ledgerDetailsCreditAmount;

	public GenericsLedgersDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsLedgersDetails(Long ledgerDetailsId, String ledgerAccountName, String ledgerAccountType,
			LocalDate ledgerDetailsDate, Double ledgerDetailsDebitAmount, Double ledgerDetailsCreditAmount) {
		super();
		this.ledgerDetailsId = ledgerDetailsId;
		this.ledgerAccountName = ledgerAccountName;
		this.ledgerAccountType = ledgerAccountType;
		this.ledgerDetailsDate = ledgerDetailsDate;
		this.ledgerDetailsDebitAmount = ledgerDetailsDebitAmount;
		this.ledgerDetailsCreditAmount = ledgerDetailsCreditAmount;
	}

	public GenericsLedgersDetails(String ledgerAccountName, String ledgerAccountType, LocalDate ledgerDetailsDate,
			Double ledgerDetailsDebitAmount, Double ledgerDetailsCreditAmount) {
		super();
		this.ledgerAccountName = ledgerAccountName;
		this.ledgerAccountType = ledgerAccountType;
		this.ledgerDetailsDate = ledgerDetailsDate;
		this.ledgerDetailsDebitAmount = ledgerDetailsDebitAmount;
		this.ledgerDetailsCreditAmount = ledgerDetailsCreditAmount;
	}

	public Long getLedgerDetailsId() {
		return ledgerDetailsId;
	}

	public void setLedgerDetailsId(Long ledgerDetailsId) {
		this.ledgerDetailsId = ledgerDetailsId;
	}

	public String getLedgerAccountName() {
		return ledgerAccountName;
	}

	public void setLedgerAccountName(String ledgerAccountName) {
		this.ledgerAccountName = ledgerAccountName;
	}

	public String getLedgerAccountType() {
		return ledgerAccountType;
	}

	public void setLedgerAccountType(String ledgerAccountType) {
		this.ledgerAccountType = ledgerAccountType;
	}

	public LocalDate getLedgerDetailsDate() {
		return ledgerDetailsDate;
	}

	public void setLedgerDetailsDate(LocalDate ledgerDetailsDate) {
		this.ledgerDetailsDate = ledgerDetailsDate;
	}

	public Double getLedgerDetailsDebitAmount() {
		return ledgerDetailsDebitAmount;
	}

	public void setLedgerDetailsDebitAmount(Double ledgerDetailsDebitAmount) {
		this.ledgerDetailsDebitAmount = ledgerDetailsDebitAmount;
	}

	public Double getLedgerDetailsCreditAmount() {
		return ledgerDetailsCreditAmount;
	}

	public void setLedgerDetailsCreditAmount(Double ledgerDetailsCreditAmount) {
		this.ledgerDetailsCreditAmount = ledgerDetailsCreditAmount;
	}

}
