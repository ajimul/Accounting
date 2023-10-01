package com.accounting.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Emi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_emi", allocationSize = 1)
	private Long emiId;
	private Long emi_BiId;
	private Long emiNo;
	private Double emiAmount;
	private String emiStatus;
	private LocalDate emiDate;
	private String emiMessage;
	private boolean emiSmsStatus;

	public Emi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emi(Long emi_BiId, Long emiNo, Double emiAmount, String emiStatus, LocalDate emiDate, String emiMessage,
			boolean emiSmsStatus) {
		super();

		this.emi_BiId = emi_BiId;
		this.emiNo = emiNo;
		this.emiAmount = emiAmount;
		this.emiStatus = emiStatus;
		this.emiDate = emiDate;
		this.emiMessage = emiMessage;
		this.emiSmsStatus = emiSmsStatus;
	}

	public Emi(Long emiId, Long emi_BiId, Long emiNo, Double emiAmount, String emiStatus, LocalDate emiDate,
			String emiMessage, boolean emiSmsStatus) {
		super();
		this.emiId = emiId;
		this.emi_BiId = emi_BiId;
		this.emiNo = emiNo;
		this.emiAmount = emiAmount;
		this.emiStatus = emiStatus;
		this.emiDate = emiDate;
		this.emiMessage = emiMessage;
		this.emiSmsStatus = emiSmsStatus;
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

	@Override
	public String toString() {
		return "Emi [emiId=" + emiId + ", emi_BiId=" + emi_BiId + ", emiNo=" + emiNo + ", emiAmount=" + emiAmount
				+ ", emiStatus=" + emiStatus + ", emiDate=" + emiDate + ", emiMessage=" + emiMessage + ", emiSmsStatus="
				+ emiSmsStatus + "]";
	}

}
