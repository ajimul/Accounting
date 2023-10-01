package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_books", allocationSize = 1)
	private Long booksId;
	private Long booksInfo_Ref;
	private Long booksAccount_Ref;
	private Long booksAccountType_Ref;
	private LocalDate booksDate;
	private Double booksDebitAmount;
	private Double booksCreditAmount;

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(Long booksId, Long booksInfo_Ref, Long booksAccount_Ref, Long booksAccountType_Ref,
			LocalDate booksDate, Double booksDebitAmount, Double booksCreditAmount) {
		super();
		this.booksId = booksId;
		this.booksInfo_Ref = booksInfo_Ref;
		this.booksAccount_Ref = booksAccount_Ref;
		this.booksAccountType_Ref = booksAccountType_Ref;
		this.booksDate = booksDate;
		this.booksDebitAmount = booksDebitAmount;
		this.booksCreditAmount = booksCreditAmount;
	}

	public Books(Long booksInfo_Ref, Long booksAccount_Ref, Long booksAccountType_Ref, LocalDate booksDate,
			Double booksDebitAmount, Double booksCreditAmount) {
		super();
		this.booksInfo_Ref = booksInfo_Ref;
		this.booksAccount_Ref = booksAccount_Ref;
		this.booksAccountType_Ref = booksAccountType_Ref;
		this.booksDate = booksDate;
		this.booksDebitAmount = booksDebitAmount;
		this.booksCreditAmount = booksCreditAmount;
	}

	public Long getBooksId() {
		return booksId;
	}

	public void setBooksId(Long booksId) {
		this.booksId = booksId;
	}

	public Long getBooksInfo_Ref() {
		return booksInfo_Ref;
	}

	public void setBooksInfo_Ref(Long booksInfo_Ref) {
		this.booksInfo_Ref = booksInfo_Ref;
	}

	public Long getBooksAccount_Ref() {
		return booksAccount_Ref;
	}

	public void setBooksAccount_Ref(Long booksAccount_Ref) {
		this.booksAccount_Ref = booksAccount_Ref;
	}

	public Long getBooksAccountType_Ref() {
		return booksAccountType_Ref;
	}

	public void setBooksAccountType_Ref(Long booksAccountType_Ref) {
		this.booksAccountType_Ref = booksAccountType_Ref;
	}

	public LocalDate getBooksDate() {
		return booksDate;
	}

	public void setBooksDate(LocalDate booksDate) {
		this.booksDate = booksDate;
	}

	public Double getBooksDebitAmount() {
		return booksDebitAmount;
	}

	public void setBooksDebitAmount(Double booksDebitAmount) {
		this.booksDebitAmount = booksDebitAmount;
	}

	public Double getBooksCreditAmount() {
		return booksCreditAmount;
	}

	public void setBooksCreditAmount(Double booksCreditAmount) {
		this.booksCreditAmount = booksCreditAmount;
	}

}
