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
public class BookType {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_booktype", allocationSize = 1)
	private Long bookTypeId;
	private String bookTypeName;

	@OneToMany(targetEntity = BookInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookInfoType_Ref", referencedColumnName = "bookTypeId")
	private List<BookInfo> bookInfos;

	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookType(Long bookTypeId, String bookTypeName, List<BookInfo> bookInfos) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
		this.bookInfos = bookInfos;
	}

	public BookType(String bookTypeName, List<BookInfo> bookInfos) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookInfos = bookInfos;
	}

	public Long getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Long bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public List<BookInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

}
