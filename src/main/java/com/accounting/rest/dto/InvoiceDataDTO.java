package com.accounting.rest.dto;

import java.time.LocalDate;

public class InvoiceDataDTO {
	private Long accountId;
	private String accountName;

	private String partyContactNo1;
	private String partyContactNo2;
	private String partyEmailId;
	private String partyGstNo;
	private String partyBillingAddress;
	private String partyShipingAddress;

	private Long bookInfoId;
	private String bookInfoNarration;
	private LocalDate bookInfoDate;
	private long bookInfoType_Ref;
	private Long bookInfoFolio_Ref;
	private long bookInfoUser_Ref;
	private long bookInfoAccount_Ref;
	private String invoiceNo;
	private LocalDate invoiceDate;

	private Long bookDetailsId;
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

	public InvoiceDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDataDTO(Long accountId, String accountName, String partyContactNo1, String partyContactNo2,
			String partyEmailId, String partyGstNo, String partyBillingAddress, String partyShipingAddress,
			Long bookInfoId, String bookInfoNarration, LocalDate bookInfoDate, long bookInfoType_Ref,
			Long bookInfoFolio_Ref, long bookInfoUser_Ref, long bookInfoAccount_Ref, String invoiceNo,
			LocalDate invoiceDate, Long bookDetailsId, Double bookDetailsParticularAmount, String bookDetailsUnit,
			Integer bookDetailsUnitValue, String bookDetailsMolelNo, Integer bookDetailsTradDiscount,
			Double bookDetailsTradDiscountAmount, Integer bookDetailsCgst, Integer bookDetailsSgst,
			Integer bookDetailsIgst, Double bookDetailsCgstAmount, Double bookDetailsSgstAmount,
			Double bookDetailsIgstAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.partyContactNo1 = partyContactNo1;
		this.partyContactNo2 = partyContactNo2;
		this.partyEmailId = partyEmailId;
		this.partyGstNo = partyGstNo;
		this.partyBillingAddress = partyBillingAddress;
		this.partyShipingAddress = partyShipingAddress;
		this.bookInfoId = bookInfoId;
		this.bookInfoNarration = bookInfoNarration;
		this.bookInfoDate = bookInfoDate;
		this.bookInfoType_Ref = bookInfoType_Ref;
		this.bookInfoFolio_Ref = bookInfoFolio_Ref;
		this.bookInfoUser_Ref = bookInfoUser_Ref;
		this.bookInfoAccount_Ref = bookInfoAccount_Ref;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.bookDetailsId = bookDetailsId;
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
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPartyContactNo1() {
		return partyContactNo1;
	}

	public void setPartyContactNo1(String partyContactNo1) {
		this.partyContactNo1 = partyContactNo1;
	}

	public String getPartyContactNo2() {
		return partyContactNo2;
	}

	public void setPartyContactNo2(String partyContactNo2) {
		this.partyContactNo2 = partyContactNo2;
	}

	public String getPartyEmailId() {
		return partyEmailId;
	}

	public void setPartyEmailId(String partyEmailId) {
		this.partyEmailId = partyEmailId;
	}

	public String getPartyGstNo() {
		return partyGstNo;
	}

	public void setPartyGstNo(String partyGstNo) {
		this.partyGstNo = partyGstNo;
	}

	public String getPartyBillingAddress() {
		return partyBillingAddress;
	}

	public void setPartyBillingAddress(String partyBillingAddress) {
		this.partyBillingAddress = partyBillingAddress;
	}

	public String getPartyShipingAddress() {
		return partyShipingAddress;
	}

	public void setPartyShipingAddress(String partyShipingAddress) {
		this.partyShipingAddress = partyShipingAddress;
	}

	public Long getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(Long bookInfoId) {
		this.bookInfoId = bookInfoId;
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

	public Long getBookDetailsId() {
		return bookDetailsId;
	}

	public void setBookDetailsId(Long bookDetailsId) {
		this.bookDetailsId = bookDetailsId;
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

}
