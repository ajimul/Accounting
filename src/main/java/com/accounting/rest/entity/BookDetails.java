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
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_book_detail", allocationSize = 1)
	private Long bookDetailsId;
	private Long bookDetailsBookInfo_Ref;
	private Long bookDetailsInventoryItems_Ref;
	private Double bookDetailsParticularAmount;
	private String bookDetailsUnit;
	private Integer bookDetailsUnitValue;
	private String bookDetailsMolelNo;
	private Integer bookDetailsTradDiscount;
	private Double bookDetailsTradDiscountAmount;

	private Integer bookDetailsCgst;
	private Integer bookDetailsSgst;
	private Integer bookDetailsIgst;

	private Double bookDetailsCgstAmount;
	private Double bookDetailsSgstAmount;
	private Double bookDetailsIgstAmount;

	@OneToMany(targetEntity = TradingItemsSerialNo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bd_Id", referencedColumnName = "bookDetailsId")
	private List<TradingItemsSerialNo> bookItemsSerialNo;

	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDetails(Long bookDetailsId, Long bookDetailsBookInfo_Ref, Long bookDetailsInventoryItems_Ref,
			Double bookDetailsParticularAmount, String bookDetailsUnit, Integer bookDetailsUnitValue,
			String bookDetailsMolelNo, Integer bookDetailsTradDiscount, Double bookDetailsTradDiscountAmount,
			Integer bookDetailsCgst, Integer bookDetailsSgst, Integer bookDetailsIgst, Double bookDetailsCgstAmount,
			Double bookDetailsSgstAmount, Double bookDetailsIgstAmount, List<TradingItemsSerialNo> bookItemsSerialNo) {
		super();
		this.bookDetailsId = bookDetailsId;
		this.bookDetailsBookInfo_Ref = bookDetailsBookInfo_Ref;
		this.bookDetailsInventoryItems_Ref = bookDetailsInventoryItems_Ref;
		this.bookDetailsParticularAmount = bookDetailsParticularAmount;
		this.bookDetailsUnit = bookDetailsUnit;
		this.bookDetailsUnitValue = bookDetailsUnitValue;
		this.bookDetailsMolelNo = bookDetailsMolelNo;
		this.bookDetailsTradDiscount = bookDetailsTradDiscount;
		this.bookDetailsTradDiscountAmount = bookDetailsTradDiscountAmount;
		this.bookDetailsCgst = bookDetailsCgst;
		this.bookDetailsSgst = bookDetailsSgst;
		this.bookDetailsIgst = bookDetailsIgst;
		this.bookDetailsCgstAmount = bookDetailsCgstAmount;
		this.bookDetailsSgstAmount = bookDetailsSgstAmount;
		this.bookDetailsIgstAmount = bookDetailsIgstAmount;
		this.bookItemsSerialNo = bookItemsSerialNo;
	}

	public Long getBookDetailsId() {
		return bookDetailsId;
	}

	public void setBookDetailsId(Long bookDetailsId) {
		this.bookDetailsId = bookDetailsId;
	}

	public Long getBookDetailsBookInfo_Ref() {
		return bookDetailsBookInfo_Ref;
	}

	public void setBookDetailsBookInfo_Ref(Long bookDetailsBookInfo_Ref) {
		this.bookDetailsBookInfo_Ref = bookDetailsBookInfo_Ref;
	}

	public Long getBookDetailsInventoryItems_Ref() {
		return bookDetailsInventoryItems_Ref;
	}

	public void setBookDetailsInventoryItems_Ref(Long bookDetailsInventoryItems_Ref) {
		this.bookDetailsInventoryItems_Ref = bookDetailsInventoryItems_Ref;
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

	public String getBookDetailsMolelNo() {
		return bookDetailsMolelNo;
	}

	public void setBookDetailsMolelNo(String bookDetailsMolelNo) {
		this.bookDetailsMolelNo = bookDetailsMolelNo;
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

	public Integer getBookDetailsCgst() {
		return bookDetailsCgst;
	}

	public void setBookDetailsCgst(Integer bookDetailsCgst) {
		this.bookDetailsCgst = bookDetailsCgst;
	}

	public Integer getBookDetailsSgst() {
		return bookDetailsSgst;
	}

	public void setBookDetailsSgst(Integer bookDetailsSgst) {
		this.bookDetailsSgst = bookDetailsSgst;
	}

	public Integer getBookDetailsIgst() {
		return bookDetailsIgst;
	}

	public void setBookDetailsIgst(Integer bookDetailsIgst) {
		this.bookDetailsIgst = bookDetailsIgst;
	}

	public Double getBookDetailsCgstAmount() {
		return bookDetailsCgstAmount;
	}

	public void setBookDetailsCgstAmount(Double bookDetailsCgstAmount) {
		this.bookDetailsCgstAmount = bookDetailsCgstAmount;
	}

	public Double getBookDetailsSgstAmount() {
		return bookDetailsSgstAmount;
	}

	public void setBookDetailsSgstAmount(Double bookDetailsSgstAmount) {
		this.bookDetailsSgstAmount = bookDetailsSgstAmount;
	}

	public Double getBookDetailsIgstAmount() {
		return bookDetailsIgstAmount;
	}

	public void setBookDetailsIgstAmount(Double bookDetailsIgstAmount) {
		this.bookDetailsIgstAmount = bookDetailsIgstAmount;
	}

	public List<TradingItemsSerialNo> getBookItemsSerialNo() {
		return bookItemsSerialNo;
	}

	public void setBookItemsSerialNo(List<TradingItemsSerialNo> bookItemsSerialNo) {
		this.bookItemsSerialNo = bookItemsSerialNo;
	}

}