package com.accounting.rest.dto;

import java.util.List;

public class InvoiceJRBeanDataSource {

	private List<String> bookDetailsParticular;
	private Double bookDetailsParticularAmount;
	private String bookDetailsUnit;
	private Integer bookDetailsUnitValue;
	private String bookDetailsHsnCode;
	private Integer bookDetailsTradDiscount;
	private Double bookDetailsTradDiscountAmount;

	public InvoiceJRBeanDataSource() {

		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceJRBeanDataSource(List<String> bookDetailsParticular, Double bookDetailsParticularAmount,
			String bookDetailsUnit, Integer bookDetailsUnitValue, String bookDetailsHsnCode,
			Integer bookDetailsTradDiscount, Double bookDetailsTradDiscountAmount) {
		super();
		this.bookDetailsParticular = bookDetailsParticular;
		this.bookDetailsParticularAmount = bookDetailsParticularAmount;
		this.bookDetailsUnit = bookDetailsUnit;
		this.bookDetailsUnitValue = bookDetailsUnitValue;
		this.bookDetailsHsnCode = bookDetailsHsnCode;
		this.bookDetailsTradDiscount = bookDetailsTradDiscount;
		this.bookDetailsTradDiscountAmount = bookDetailsTradDiscountAmount;
	}

	public List<String> getBookDetailsParticular() {
		return bookDetailsParticular;
	}

	public void setBookDetailsParticular(List<String> bookDetailsParticular) {
		this.bookDetailsParticular = bookDetailsParticular;
	}

	public Double getBookDetailsParticularAmount() {
		return bookDetailsParticularAmount;
	}

	public void setBookDetailsParticularAmount(Double bookDetailsParticularAmount) {
		this.bookDetailsParticularAmount = bookDetailsParticularAmount;
	}

	public String getBookDetailsUnit() {
		return bookDetailsUnit;
	}

	public void setBookDetailsUnit(String bookDetailsUnit) {
		this.bookDetailsUnit = bookDetailsUnit;
	}

	public Integer getBookDetailsUnitValue() {
		return bookDetailsUnitValue;
	}

	public void setBookDetailsUnitValue(Integer bookDetailsUnitValue) {
		this.bookDetailsUnitValue = bookDetailsUnitValue;
	}

	public String getBookDetailsHsnCode() {
		return bookDetailsHsnCode;
	}

	public void setBookDetailsHsnCode(String bookDetailsHsnCode) {
		this.bookDetailsHsnCode = bookDetailsHsnCode;
	}

	public Integer getBookDetailsTradDiscount() {
		return bookDetailsTradDiscount;
	}

	public void setBookDetailsTradDiscount(Integer bookDetailsTradDiscount) {
		this.bookDetailsTradDiscount = bookDetailsTradDiscount;
	}

	public Double getBookDetailsTradDiscountAmount() {
		return bookDetailsTradDiscountAmount;
	}

	public void setBookDetailsTradDiscountAmount(Double bookDetailsTradDiscountAmount) {
		this.bookDetailsTradDiscountAmount = bookDetailsTradDiscountAmount;
	}

//	private Integer bookDetailsCgst;
//	private Integer bookDetailsSgst;
//	private Integer bookDetailsIgst;
//
//	private Double bookDetailsCgstAmount;
//	private Double bookDetailsSgstAmount;
//	private Double bookDetailsIgstAmount;

}
