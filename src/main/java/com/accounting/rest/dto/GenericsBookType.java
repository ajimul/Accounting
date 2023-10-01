package com.accounting.rest.dto;

public class GenericsBookType {

	private Long bookTypeId;
	private String bookTypeName;

	public GenericsBookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsBookType(Long bookTypeId, String bookTypeName) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
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

}
