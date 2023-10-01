package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "inventory_journal")
public class InventoryJournal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_inventory_journal", allocationSize = 1)
	private Long ijId;
	private Long ij_iiId;
	private LocalDate ijDate;
	private String ijPartyName;
	private String ijVoucherType;
	private Long ijVoucherNo;
	private Integer ijInwardQty;
	private Double ijJInwardAmount;
	private Integer ijJOutwardQty;
	private Double ijJOutwardAmount;

	public InventoryJournal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryJournal(Long ijId, Long ij_iiId, LocalDate ijDate, String ijPartyName, String ijVoucherType,
			Long ijVoucherNo, Integer ijInwardQty, Double ijJInwardAmount, Integer ijJOutwardQty,
			Double ijJOutwardAmount) {
		super();
		this.ijId = ijId;
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

	public Long getIjId() {
		return ijId;
	}

	public void setIjId(Long ijId) {
		this.ijId = ijId;
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

	public Long getIjVoucherNo() {
		return ijVoucherNo;
	}

	public void setIjVoucherNo(Long ijVoucherNo) {
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
