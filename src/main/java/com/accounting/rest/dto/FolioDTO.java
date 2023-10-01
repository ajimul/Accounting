package com.accounting.rest.dto;

import java.time.LocalDate;

public class FolioDTO {

	private Long folioId;
	private String folioNarration;

	private long bookInfoAccount_Ref;
	private LocalDate bookInfoDate;

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

	private Long emiId;
	private Long emi_BiId;
	private Long emiNo;
	private Double emiAmount;
	private String emiStatus;
	private LocalDate emiDate;
	private String emiMessage;
	private boolean emiSmsStatus;

	public FolioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FolioDTO(Long folioId, String folioNarration, long bookInfoAccount_Ref, LocalDate bookInfoDate,
			Long bookDetailsId, Long bookDetailsBookInfo_Ref, Long bookDetailsInventoryItems_Ref,
			Double bookDetailsParticularAmount, String bookDetailsUnit, Integer bookDetailsUnitValue,
			String bookDetailsMolelNo, Integer bookDetailsTradDiscount, Double bookDetailsTradDiscountAmount,
			Integer bookDetailsCgst, Integer bookDetailsSgst, Integer bookDetailsIgst, Double bookDetailsCgstAmount,
			Double bookDetailsSgstAmount, Double bookDetailsIgstAmount, Long emiId, Long emi_BiId, Long emiNo,
			Double emiAmount, String emiStatus, LocalDate emiDate, String emiMessage, boolean emiSmsStatus) {
		super();
		this.folioId = folioId;
		this.folioNarration = folioNarration;
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
		this.bookInfoDate = bookInfoDate;
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
		this.emiId = emiId;
		this.emi_BiId = emi_BiId;
		this.emiNo = emiNo;
		this.emiAmount = emiAmount;
		this.emiStatus = emiStatus;
		this.emiDate = emiDate;
		this.emiMessage = emiMessage;
		this.emiSmsStatus = emiSmsStatus;
	}

	public Long getFolioId() {
		return folioId;
	}

	public void setFolioId(Long folioId) {
		this.folioId = folioId;
	}

	public String getFolioNarration() {
		return folioNarration;
	}

	public void setFolioNarration(String folioNarration) {
		this.folioNarration = folioNarration;
	}

	public long getBookInfoAccount_Ref() {
		return bookInfoAccount_Ref;
	}

	public void setBookInfoAccount_Ref(long bookInfoAccount_Ref) {
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
	}

	public LocalDate getBookInfoDate() {
		return bookInfoDate;
	}

	public void setBookInfoDate(LocalDate bookInfoDate) {
		this.bookInfoDate = bookInfoDate;
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

	public Long getEmiId() {
		return emiId;
	}

	public void setEmiId(Long emiId) {
		this.emiId = emiId;
	}

	public Long getEmi_BiId() {
		return emi_BiId;
	}

	public void setEmi_BiId(Long emi_BiId) {
		this.emi_BiId = emi_BiId;
	}

	public Long getEmiNo() {
		return emiNo;
	}

	public void setEmiNo(Long emiNo) {
		this.emiNo = emiNo;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public String getEmiStatus() {
		return emiStatus;
	}

	public void setEmiStatus(String emiStatus) {
		this.emiStatus = emiStatus;
	}

	public LocalDate getEmiDate() {
		return emiDate;
	}

	public void setEmiDate(LocalDate emiDate) {
		this.emiDate = emiDate;
	}

	public String getEmiMessage() {
		return emiMessage;
	}

	public void setEmiMessage(String emiMessage) {
		this.emiMessage = emiMessage;
	}

	public boolean isEmiSmsStatus() {
		return emiSmsStatus;
	}

	public void setEmiSmsStatus(boolean emiSmsStatus) {
		this.emiSmsStatus = emiSmsStatus;
	}

}
