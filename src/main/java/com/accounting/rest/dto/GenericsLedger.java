package com.accounting.rest.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//@Entity
public class GenericsLedger {
//	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
//	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ac", allocationSize = 1)
	private Long ledgerId;
	private String ledgerAccountName;
	private String ledgerAccountType;
	private Long ledgerFolioNumber;
	private String ledgerUserName;
	private LocalDate date;

	@OneToMany(targetEntity = GenericsLedgersDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgers_Ref", referencedColumnName = "ledgerId")
	private List<GenericsLedgersDetails> ledgersDetails;

	public GenericsLedger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsLedger(Long ledgerId, String ledgerAccountName, String ledgerAccountType, Long ledgerFolioNumber,
			String ledgerUserName, LocalDate date, List<GenericsLedgersDetails> ledgersDetails) {
		super();
		this.ledgerId = ledgerId;
		this.ledgerAccountName = ledgerAccountName;
		this.ledgerAccountType = ledgerAccountType;
		this.ledgerFolioNumber = ledgerFolioNumber;
		this.ledgerUserName = ledgerUserName;
		this.date = date;
		this.ledgersDetails = ledgersDetails;
	}

	public GenericsLedger(String ledgerAccountName, String ledgerAccountType, Long ledgerFolioNumber,
			String ledgerUserName, LocalDate date, List<GenericsLedgersDetails> ledgersDetails) {
		super();
		this.ledgerAccountName = ledgerAccountName;
		this.ledgerAccountType = ledgerAccountType;
		this.ledgerFolioNumber = ledgerFolioNumber;
		this.ledgerUserName = ledgerUserName;
		this.date = date;
		this.ledgersDetails = ledgersDetails;
	}

	public Long getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
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

	public Long getLedgerFolioNumber() {
		return ledgerFolioNumber;
	}

	public void setLedgerFolioNumber(Long ledgerFolioNumber) {
		this.ledgerFolioNumber = ledgerFolioNumber;
	}

	public String getLedgerUserName() {
		return ledgerUserName;
	}

	public void setLedgerUserName(String ledgerUserName) {
		this.ledgerUserName = ledgerUserName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<GenericsLedgersDetails> getLedgersDetails() {
		return ledgersDetails;
	}

	public void setLedgersDetails(List<GenericsLedgersDetails> ledgersDetails) {
		this.ledgersDetails = ledgersDetails;
	}

}
