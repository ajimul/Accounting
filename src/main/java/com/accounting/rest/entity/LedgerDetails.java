package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class LedgerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ledger_details", allocationSize = 1)
	private Long ledgerDetailsId;
	private Long ledgerDetailsLedger_Ref;
	private Long ledgerDetailsAccount_Ref;// particular
	private Long ledgerDetailsAccountType_Ref;
	private LocalDate ledgerDetailsDate;
	private Double ledgerDetailsDebitAmount;
	private Double ledgerDetailsCreditAmount;

	public LedgerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LedgerDetails(Long ledgerDetailsId, Long ledgerDetailsLedger_Ref, Long ledgerDetailsAccount_Ref,
			Long ledgerDetailsAccountType_Ref, LocalDate ledgerDetailsDate, Double ledgerDetailsDebitAmount,
			Double ledgerDetailsCreditAmount) {
		super();
		this.ledgerDetailsId = ledgerDetailsId;
		this.ledgerDetailsLedger_Ref = ledgerDetailsLedger_Ref;
		this.ledgerDetailsAccount_Ref = ledgerDetailsAccount_Ref;
		this.ledgerDetailsAccountType_Ref = ledgerDetailsAccountType_Ref;
		this.ledgerDetailsDate = ledgerDetailsDate;
		this.ledgerDetailsDebitAmount = ledgerDetailsDebitAmount;
		this.ledgerDetailsCreditAmount = ledgerDetailsCreditAmount;
	}

	public LedgerDetails(Long ledgerDetailsLedger_Ref, Long ledgerDetailsAccount_Ref, Long ledgerDetailsAccountType_Ref,
			LocalDate ledgerDetailsDate, Double ledgerDetailsDebitAmount, Double ledgerDetailsCreditAmount) {
		super();
		this.ledgerDetailsLedger_Ref = ledgerDetailsLedger_Ref;
		this.ledgerDetailsAccount_Ref = ledgerDetailsAccount_Ref;
		this.ledgerDetailsAccountType_Ref = ledgerDetailsAccountType_Ref;
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

	public Long getLedgerDetailsLedger_Ref() {
		return ledgerDetailsLedger_Ref;
	}

	public void setLedgerDetailsLedger_Ref(Long ledgerDetailsLedger_Ref) {
		this.ledgerDetailsLedger_Ref = ledgerDetailsLedger_Ref;
	}

	public Long getLedgerDetailsAccountc_Ref() {
		return ledgerDetailsAccount_Ref;
	}

	public void setLedgerDetailsAccount_Ref(Long ledgerDetailsAccount_Ref) {
		this.ledgerDetailsAccount_Ref = ledgerDetailsAccount_Ref;
	}

	public Long getLedgerDetailsAccountType_Ref() {
		return ledgerDetailsAccountType_Ref;
	}

	public void setLedgerDetailsAccountType_Ref(Long ledgerDetailsAccountType_Ref) {
		this.ledgerDetailsAccountType_Ref = ledgerDetailsAccountType_Ref;
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
