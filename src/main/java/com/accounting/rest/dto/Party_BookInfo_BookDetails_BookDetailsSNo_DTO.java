package com.accounting.rest.dto;

import java.time.LocalDate;

public class Party_BookInfo_BookDetails_BookDetailsSNo_DTO {
	private Long folioId;
	private String folioNarration;
	private long bookInfoId;
	private long bookInfoType_Ref;
	private Long bookInfoFolio_Ref;
	private long bookInfoUser_Ref;
	private long bookInfoAccount_Ref;
	private String bookInfoNarration;
	private String invoiceNo;
	private LocalDate invoiceDate;
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
	private Long sId;
	private Long bd_Id;
	private String serialNo;

	public Party_BookInfo_BookDetails_BookDetailsSNo_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Party_BookInfo_BookDetails_BookDetailsSNo_DTO(Long folioId, String folioNarration, long bookInfoId,
			long bookInfoType_Ref, Long bookInfoFolio_Ref, long bookInfoUser_Ref, long bookInfoAccount_Ref,
			String bookInfoNarration, String invoiceNo, LocalDate invoiceDate, LocalDate bookInfoDate,
			Long bookDetailsId, Long bookDetailsBookInfo_Ref, Long bookDetailsInventoryItems_Ref,
			Double bookDetailsParticularAmount, String bookDetailsUnit, Integer bookDetailsUnitValue,
			String bookDetailsMolelNo, Integer bookDetailsTradDiscount, Double bookDetailsTradDiscountAmount,
			Integer bookDetailsCgst, Integer bookDetailsSgst, Integer bookDetailsIgst, Double bookDetailsCgstAmount,
			Double bookDetailsSgstAmount, Double bookDetailsIgstAmount, Long sId, Long bd_Id, String serialNo) {
		super();
		this.folioId = folioId;
		this.folioNarration = folioNarration;
		this.bookInfoId = bookInfoId;
		this.bookInfoType_Ref = bookInfoType_Ref;
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
		this.bookInfoUser_Ref = bookInfoUser_Ref;
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
		this.bookInfoNarration = bookInfoNarration;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
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
		this.sId = sId;
		this.bd_Id = bd_Id;
		this.serialNo = serialNo;
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

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public Long getBd_Id() {
		return bd_Id;
	}

	public void setBd_Id(Long bd_Id) {
		this.bd_Id = bd_Id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}
