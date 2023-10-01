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
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ac", allocationSize = 1)

	private Long accountId;
	private String accountName;

	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booksAccount_Ref", referencedColumnName = "accountId")
	private List<Books> books;

	@OneToMany(targetEntity = Ledger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgerAccount_Ref", referencedColumnName = "accountId")
	private List<Ledger> ledgers;

	@OneToMany(targetEntity = BookInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookInfoAccount_Ref", referencedColumnName = "accountId")
	private List<BookInfo> bookInfos;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ps_AccountId", referencedColumnName = "accountId")
	private List<Product> productOfServices;

	@OneToMany(targetEntity = EmployeeDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_ac_refId", referencedColumnName = "accountId")
	private List<EmployeeDetails> employeeDetails;

	@OneToMany(targetEntity = PartyDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "party_ac_refId", referencedColumnName = "accountId")
	private List<PartyDetails> partyDetails;

	public Accounts() {
		super();

	}

	public Accounts(Long accountId, String accountName, List<Books> books, List<Ledger> ledgers,
			List<BookInfo> bookInfos, List<Product> productOfServices, List<EmployeeDetails> employeeDetails,
			List<PartyDetails> partyDetails) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.books = books;
		this.ledgers = ledgers;
		this.bookInfos = bookInfos;
		this.productOfServices = productOfServices;
		this.employeeDetails = employeeDetails;
		this.partyDetails = partyDetails;
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

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public List<Ledger> getLedgers() {
		return ledgers;
	}

	public void setLedgers(List<Ledger> ledgers) {
		this.ledgers = ledgers;
	}

	public List<BookInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

	public List<Product> getProductOfServices() {
		return productOfServices;
	}

	public void setProductOfServices(List<Product> productOfServices) {
		this.productOfServices = productOfServices;
	}

	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public List<PartyDetails> getPartyDetails() {
		return partyDetails;
	}

	public void setPartyDetails(List<PartyDetails> partyDetails) {
		this.partyDetails = partyDetails;
	}

}
