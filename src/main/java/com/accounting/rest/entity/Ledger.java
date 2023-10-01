package com.accounting.rest.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ledger", allocationSize = 1)
	private Long ledgerId;
	private Long ledgerAccount_Ref;
	private Long ledgerAccountType_Ref;
	private Long ledgerFolio_Ref;
	private Long ledgerUser_Ref;
	private LocalDate ledgerDate;

	@OneToMany(targetEntity = LedgerDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgerDetailsLedger_Ref", referencedColumnName = "ledgerId")
	private List<LedgerDetails> ledgerDetails;

	public Ledger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ledger(Long ledgerId, Long ledgerAccount_Ref, Long ledgerAccountType_Ref, Long ledgerFolio_Ref,
			Long ledgerUser_Ref, LocalDate ledgerDate, List<LedgerDetails> ledgerDetails) {
		super();
		this.ledgerId = ledgerId;
		this.ledgerAccount_Ref = ledgerAccount_Ref;
		this.ledgerAccountType_Ref = ledgerAccountType_Ref;
		this.ledgerFolio_Ref = ledgerFolio_Ref;
		this.ledgerUser_Ref = ledgerUser_Ref;
		this.ledgerDate = ledgerDate;
		this.ledgerDetails = ledgerDetails;
	}

	public Long getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
	}

	public Long getLedgerAccount_Ref() {
		return ledgerAccount_Ref;
	}

	public void setLedgerAccount_Ref(Long ledgerAccount_Ref) {
		this.ledgerAccount_Ref = ledgerAccount_Ref;
	}

	public Long getLedgerAccountType_Ref() {
		return ledgerAccountType_Ref;
	}

	public void setLedgerAccountType_Ref(Long ledgerAccountType_Ref) {
		this.ledgerAccountType_Ref = ledgerAccountType_Ref;
	}

	public Long getLedgerFolio_Ref() {
		return ledgerFolio_Ref;
	}

	public void setLedgerFolio_Ref(Long ledgerFolio_Ref) {
		this.ledgerFolio_Ref = ledgerFolio_Ref;
	}

	public Long getLedgerUser_Ref() {
		return ledgerUser_Ref;
	}

	public void setLedgerUser_Ref(Long ledgerUser_Ref) {
		this.ledgerUser_Ref = ledgerUser_Ref;
	}

	public LocalDate getLedgerDate() {
		return ledgerDate;
	}

	public void setLedgerDate(LocalDate ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public List<LedgerDetails> getLedgerDetails() {
		return ledgerDetails;
	}

	public void setLedgerDetails(List<LedgerDetails> ledgerDetails) {
		this.ledgerDetails = ledgerDetails;
	}

}
