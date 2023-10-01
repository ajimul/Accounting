package com.accounting.rest.dto;

import java.time.LocalDate;
import java.util.List;

import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.entity.InventoryJournal;

public class PurchaseModel {

	private Long userId;
	private Long accountId;
	private String partyAcName;
	private String invoiceNo;
	private LocalDate invoiceDate;
	private LocalDate transectionDate;
	private String naration;
	private TransectionalAccountsModel transectionalAccounts;
	private List<BookDetails> bookDetails;
	private List<InventoryJournal> inventoryJournal;

	public PurchaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseModel(Long userId, Long accountId, String partyAcName, String invoiceNo, LocalDate invoiceDate,
			LocalDate transectionDate, String naration, TransectionalAccountsModel transectionalAccounts,
			List<BookDetails> bookDetails, List<InventoryJournal> inventoryJournal) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.partyAcName = partyAcName;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.transectionDate = transectionDate;
		this.naration = naration;
		this.transectionalAccounts = transectionalAccounts;
		this.bookDetails = bookDetails;
		this.inventoryJournal = inventoryJournal;
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

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
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

	public List<InventoryJournal> getInventoryJournal() {
		return inventoryJournal;
	}

	public void setInventoryJournal(List<InventoryJournal> inventoryJournal) {
		this.inventoryJournal = inventoryJournal;
	}

}
