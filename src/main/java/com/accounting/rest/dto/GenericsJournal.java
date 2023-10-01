package com.accounting.rest.dto;

import java.util.List;

public class GenericsJournal {
	private String bookNarration;
//	private String accountName;
	private String bookName;
	List<GenericsJournalDetails> journalDetails;

	public GenericsJournal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsJournal(String bookNarration, String bookName, List<GenericsJournalDetails> journalDetails) {
		super();
		this.bookNarration = bookNarration;
		this.bookName = bookName;
		this.journalDetails = journalDetails;
	}

	public String getBookNarration() {
		return bookNarration;
	}

	public void setBookNarration(String bookNarration) {
		this.bookNarration = bookNarration;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<GenericsJournalDetails> getJournalDetails() {
		return journalDetails;
	}

	public void setJournalDetails(List<GenericsJournalDetails> journalDetails) {
		this.journalDetails = journalDetails;
	}

}
