package com.accounting.rest.dto;

import java.time.LocalDate;

public class InvoiceJRParameter {
	private Long partyId;
	private String PartyName;
	private String partyBillingAddress;
	private String partyShipingAddress;
	private Long folioId;
	private Double totalAmount;
	private LocalDate invoiceDate;

	public InvoiceJRParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceJRParameter(Long partyId, String partyName, String partyBillingAddress, String partyShipingAddress,
			Long folioId, Double totalAmount, LocalDate invoiceDate) {
		super();
		this.partyId = partyId;
		PartyName = partyName;
		this.partyBillingAddress = partyBillingAddress;
		this.partyShipingAddress = partyShipingAddress;
		this.folioId = folioId;
		this.totalAmount = totalAmount;
		this.invoiceDate = invoiceDate;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return PartyName;
	}

	public void setPartyName(String partyName) {
		PartyName = partyName;
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

	public Long getFolioId() {
		return folioId;
	}

	public void setFolioId(Long folioId) {
		this.folioId = folioId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
