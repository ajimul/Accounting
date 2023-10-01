package com.accounting.rest.dto;

import java.time.LocalDate;
import java.util.List;

import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.entity.Emi;
import com.accounting.rest.entity.Product;

public class AmcModel {

	private Long userId;
	private Long accountId;
	private String partyAcName;
	private String invoiceNo;
//	private LocalDate invoiceDate;
	private LocalDate transectionDate;
	private String naration;
	private TransectionalAccountsModel transectionalAccounts;
	private List<BookDetails> bookDetails;
	private List<Product> product;
	private List<Emi> emi;

	public AmcModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AmcModel(Long userId, Long accountId, String partyAcName, String invoiceNo, LocalDate transectionDate,
			String naration, TransectionalAccountsModel transectionalAccounts, List<BookDetails> bookDetails,
			List<Product> product, List<Emi> emi) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.partyAcName = partyAcName;
		this.invoiceNo = invoiceNo;
		this.transectionDate = transectionDate;
		this.naration = naration;
		this.transectionalAccounts = transectionalAccounts;
		this.bookDetails = bookDetails;
		this.product = product;
		this.emi = emi;
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

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public LocalDate getTransectionDate() {
		return transectionDate;
	}

	public void setTransectionDate(LocalDate transectionDate) {
		this.transectionDate = transectionDate;
	}

	public String getNaration() {
		return naration;
	}

	public void setNaration(String naration) {
		this.naration = naration;
	}

	public TransectionalAccountsModel getTransectionalAccounts() {
		return transectionalAccounts;
	}

	public void setTransectionalAccounts(TransectionalAccountsModel transectionalAccounts) {
		this.transectionalAccounts = transectionalAccounts;
	}

	public List<BookDetails> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookDetails> bookDetails) {
		this.bookDetails = bookDetails;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Emi> getEmi() {
		return emi;
	}

	public void setEmi(List<Emi> emi) {
		this.emi = emi;
	}

}
