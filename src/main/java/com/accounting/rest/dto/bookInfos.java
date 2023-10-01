package com.accounting.rest.dto;

import java.util.List;

import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.entity.Emi;

public class bookInfos {
	private long bookInfoId;
	private long bookInfoType_Ref;
	private Long bookInfoFolio_Ref;
	private long bookInfoUser_Ref;
	private long bookInfoAccount_Ref;
	private String bookInfoNarration;
	private String bookInfoDate;
	private List<BookDetails> bookDetails;
	private List<Emi> emi;

	public bookInfos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bookInfos(long bookInfoId, long bookInfoType_Ref, Long bookInfoFolio_Ref, long bookInfoUser_Ref,
			long bookInfoAccount_Ref, String bookInfoNarration, String bookInfoDate, List<BookDetails> bookDetails,
			List<Emi> emi) {
		super();
		this.bookInfoId = bookInfoId;
		this.bookInfoType_Ref = bookInfoType_Ref;
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
		this.bookInfoUser_Ref = bookInfoUser_Ref;
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
		this.bookInfoNarration = bookInfoNarration;
		this.bookInfoDate = bookInfoDate;
		this.bookDetails = bookDetails;
		this.emi = emi;
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

	public String getBookInfoDate() {
		return bookInfoDate;
	}

	public void setBookInfoDate(String bookInfoDate) {
		this.bookInfoDate = bookInfoDate;
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

}
