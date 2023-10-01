package com.accounting.rest.dto;

import java.time.LocalDate;

public class InventoryJournalModel {
	private Long ij_iiId;
	private LocalDate ijDate;
	private String ijPartyName;
	private String ijVoucherType;
	private Integer ijVoucherNo;
	private Integer ijInwardQty;
	private Double ijJInwardAmount;
	private Integer ijJOutwardQty;
	private Double ijJOutwardAmount;

	public InventoryJournalModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryJournalModel(Long ij_iiId, LocalDate ijDate, String ijPartyName, String ijVoucherType,
			Integer ijVoucherNo, Integer ijInwardQty, Double ijJInwardAmount, Integer ijJOutwardQty,
			Double ijJOutwardAmount) {
		super();
		this.ij_iiId = ij_iiId;
		this.ijDate = ijDate;
		this.ijPartyName = ijPartyName;
		this.ijVoucherType = ijVoucherType;
		this.ijVoucherNo = ijVoucherNo;
		this.ijInwardQty = ijInwardQty;
		this.ijJInwardAmount = ijJInwardAmount;
		this.ijJOutwardQty = ijJOutwardQty;
		this.ijJOutwardAmount = ijJOutwardAmount;
	}

	public Long getIj_iiId() {
		return ij_iiId;
	}

	public void setIj_iiId(Long ij_iiId) {
		this.ij_iiId = ij_iiId;
	}

	public LocalDate getIjDate() {
		return ijDate;
	}

	public void setIjDate(LocalDate ijDate) {
		this.ijDate = ijDate;
	}

	public String getIjPartyName() {
		return ijPartyName;
	}

	public void setIjPartyName(String ijPartyName) {
		this.ijPartyName = ijPartyName;
	}

	public String getIjVoucherType() {
		return ijVoucherType;
	}

	public void setIjVoucherType(String ijVoucherType) {
		this.ijVoucherType = ijVoucherType;
	}

	public Integer getIjVoucherNo() {
		return ijVoucherNo;
	}

	public void setIjVoucherNo(Integer ijVoucherNo) {
		this.ijVoucherNo = ijVoucherNo;
	}

	public Integer getIjInwardQty() {
		return ijInwardQty;
	}

	public void setIjInwardQty(Integer ijInwardQty) {
		this.ijInwardQty = ijInwardQty;
	}

	public Double getIjJInwardAmount() {
		return ijJInwardAmount;
	}

	public void setIjJInwardAmount(Double ijJInwardAmount) {
		this.ijJInwardAmount = ijJInwardAmount;
	}

	public Integer getIjJOutwardQty() {
		return ijJOutwardQty;
	}

	public void setIjJOutwardQty(Integer ijJOutwardQty) {
		this.ijJOutwardQty = ijJOutwardQty;
	}

	public Double getIjJOutwardAmount() {
		return ijJOutwardAmount;
	}

	public void setIjJOutwardAmount(Double ijJOutwardAmount) {
		this.ijJOutwardAmount = ijJOutwardAmount;
	}

}
