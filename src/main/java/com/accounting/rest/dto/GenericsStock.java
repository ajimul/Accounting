package com.accounting.rest.dto;

public class GenericsStock {

	private Long stockId;
	private String particular;
	private String hsn;
	private String qty;
	private String purchaseAmount;
	private String salesAmount;
	private String taxableValue;

	public GenericsStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsStock(Long stockId, String particular, String hsn, String qty, String purchaseAmount,
			String salesAmount, String taxableValue) {
		super();
		this.stockId = stockId;
		this.particular = particular;
		this.hsn = hsn;
		this.qty = qty;
		this.purchaseAmount = purchaseAmount;
		this.salesAmount = salesAmount;
		this.taxableValue = taxableValue;
	}

	public GenericsStock(String particular, String hsn, String qty, String purchaseAmount, String salesAmount,
			String taxableValue) {
		super();
		this.particular = particular;
		this.hsn = hsn;
		this.qty = qty;
		this.purchaseAmount = purchaseAmount;
		this.salesAmount = salesAmount;
		this.taxableValue = taxableValue;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getHsn() {
		return hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(String taxableValue) {
		this.taxableValue = taxableValue;
	}

}
