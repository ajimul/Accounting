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
public class BookInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_book_info", allocationSize = 1)
	private long bookInfoId;
	private long bookInfoType_Ref;
	private Long bookInfoFolio_Ref;
	private long bookInfoUser_Ref;
	private long bookInfoAccount_Ref;
	private String bookInfoNarration;
	private String invoiceNo;
	private LocalDate invoiceDate;
	private LocalDate bookInfoDate;

	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booksInfo_Ref", referencedColumnName = "bookInfoId")
	private List<Books> books;

	@OneToMany(targetEntity = BookDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookDetailsBookInfo_Ref", referencedColumnName = "bookInfoId")
	private List<BookDetails> bookDetails;

	@OneToMany(targetEntity = Emi.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emi_BiId", referencedColumnName = "bookInfoId")
	private List<Emi> emi;

	@OneToMany(targetEntity = InventoryJournal.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ijVoucherNo", referencedColumnName = "bookInfoId")
	private List<InventoryJournal> inventoryJournals;

	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookInfo(long bookInfoId, long bookInfoType_Ref, Long bookInfoFolio_Ref, long bookInfoUser_Ref,
			long bookInfoAccount_Ref, String bookInfoNarration, String invoiceNo, LocalDate invoiceDate,
			LocalDate bookInfoDate, List<Books> books, List<BookDetails> bookDetails, List<Emi> emi,
			List<InventoryJournal> inventoryJournals) {
		super();
		this.bookInfoId = bookInfoId;
		this.bookInfoType_Ref = bookInfoType_Ref;
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
		this.bookInfoUser_Ref = bookInfoUser_Ref;
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
		this.bookInfoNarration = bookInfoNarration;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.bookInfoDate = bookInfoDate;
		this.books = books;
		this.bookDetails = bookDetails;
		this.emi = emi;
		this.inventoryJournals = inventoryJournals;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public long getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(long bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public long getBookInfoType_Ref() {
		return bookInfoType_Ref;
	}

	public void setBookInfoType_Ref(long bookInfoType_Ref) {
		this.bookInfoType_Ref = bookInfoType_Ref;
	}

	public Long getBookInfoFolio_Ref() {
		return bookInfoFolio_Ref;
	}

	public void setBookInfoFolio_Ref(Long bookInfoFolio_Ref) {
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
	}

	public long getBookInfoUser_Ref() {
		return bookInfoUser_Ref;
	}

	public void setBookInfoUser_Ref(long bookInfoUser_Ref) {
		this.bookInfoUser_Ref = bookInfoUser_Ref;
	}

	public long getBookInfoAccount_Ref() {
		return bookInfoAccount_Ref;
	}

	public void setBookInfoAccount_Ref(long bookInfoAccount_Ref) {
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
	}

	public String getBookInfoNarration() {
		return bookInfoNarration;
	}

	public void setBookInfoNarration(String bookInfoNarration) {
		this.bookInfoNarration = bookInfoNarration;
	}

	public LocalDate getBookInfoDate() {
		return bookInfoDate;
	}

	public void setBookInfoDate(LocalDate bookInfoDate) {
		this.bookInfoDate = bookInfoDate;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public List<BookDetails> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookDetails> bookDetails) {
		this.bookDetails = bookDetails;
	}

	public List<Emi> getEmi() {
		return emi;
	}

	public void setEmi(List<Emi> emi) {
		this.emi = emi;
	}

	public List<InventoryJournal> getInventoryJournals() {
		return inventoryJournals;
	}

	public void setInventoryJournals(List<InventoryJournal> inventoryJournals) {
		this.inventoryJournals = inventoryJournals;
	}

}
