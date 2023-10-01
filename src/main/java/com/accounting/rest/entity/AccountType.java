package com.accounting.rest.entity;

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
public class AccountType {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ac_type", allocationSize = 1)
	private Long accountTypeId;
	private String accountTypeName;
	private String accountTypeDebitAmount;
	private String accountTypeCreditAmount;

	@OneToMany(targetEntity = Ledger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgerAccountType_Ref", referencedColumnName = "accountTypeId")
	private List<Ledger> ledgers;

	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booksAccountType_Ref", referencedColumnName = "accountTypeId")
	private List<Books> books;

	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountType(Long accountTypeId, String accountTypeName, String accountTypeDebitAmount,
			String accountTypeCreditAmount, List<Ledger> ledgers, List<Books> books) {
		super();
		this.accountTypeId = accountTypeId;
		this.accountTypeName = accountTypeName;
		this.accountTypeDebitAmount = accountTypeDebitAmount;
		this.accountTypeCreditAmount = accountTypeCreditAmount;
		this.ledgers = ledgers;
		this.books = books;
	}

	public AccountType(String accountTypeName, String accountTypeDebitAmount, String accountTypeCreditAmount,
			List<Ledger> ledgers, List<Books> books) {
		super();
		this.accountTypeName = accountTypeName;
		this.accountTypeDebitAmount = accountTypeDebitAmount;
		this.accountTypeCreditAmount = accountTypeCreditAmount;
		this.ledgers = ledgers;
		this.books = books;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getAccountTypeDebitAmount() {
		return accountTypeDebitAmount;
	}

	public void setAccountTypeDebitAmount(String accountTypeDebitAmount) {
		this.accountTypeDebitAmount = accountTypeDebitAmount;
	}

	public String getAccountTypeCreditAmount() {
		return accountTypeCreditAmount;
	}

	public void setAccountTypeCreditAmount(String accountTypeCreditAmount) {
		this.accountTypeCreditAmount = accountTypeCreditAmount;
	}

	public List<Ledger> getLedgers() {
		return ledgers;
	}

	public void setLedgers(List<Ledger> ledgers) {
		this.ledgers = ledgers;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

}
