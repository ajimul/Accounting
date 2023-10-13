package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ExtraCost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "extraCost_sequence")
	@SequenceGenerator(name = "extraCost_sequence", sequenceName = "SequenceGenerator_extraCostList", allocationSize = 1)
	private Long etraCostId;
	private Long etraCostBomId_Ref;
	private String costParticular;
	private Integer sgst;
	private Integer cgst;
	private Integer igst;
	private Double sgstAmount;
	private Double cgstAmount;
	private Double igstAmount;
	private Double costParticularAmount;

	public ExtraCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtraCost(Long etraCostId, Long etraCostBomId_Ref, String costParticular, Integer sgst, Integer cgst,
			Integer igst, Double sgstAmount, Double cgstAmount, Double igstAmount, Double costParticularAmount) {
		super();
		this.etraCostId = etraCostId;
		this.etraCostBomId_Ref = etraCostBomId_Ref;
		this.costParticular = costParticular;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
		this.sgstAmount = sgstAmount;
		this.cgstAmount = cgstAmount;
		this.igstAmount = igstAmount;
		this.costParticularAmount = costParticularAmount;
	}

	public Long getEtraCostId() {
		return etraCostId;
	}

	public void setEtraCostId(Long etraCostId) {
		this.etraCostId = etraCostId;
	}

	public Long getEtraCostBomId_Ref() {
		return etraCostBomId_Ref;
	}

	public void setEtraCostBomId_Ref(Long etraCostBomId_Ref) {
		this.etraCostBomId_Ref = etraCostBomId_Ref;
	}

	public String getCostParticular() {
		return costParticular;
	}

	public void setCostParticular(String costParticular) {
		this.costParticular = costParticular;
	}

	public Integer getSgst() {
		return sgst;
	}

	public void setSgst(Integer sgst) {
		this.sgst = sgst;
	}

	public Integer getCgst() {
		return cgst;
	}

	public void setCgst(Integer cgst) {
		this.cgst = cgst;
	}

	public Integer getIgst() {
		return igst;
	}

	public void setIgst(Integer igst) {
		this.igst = igst;
	}

	public Double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(Double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public Double getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(Double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public Double getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(Double igstAmount) {
		this.igstAmount = igstAmount;
	}

	public Double getCostParticularAmount() {
		return costParticularAmount;
	}

	public void setCostParticularAmount(Double costParticularAmount) {
		this.costParticularAmount = costParticularAmount;
	}

}
