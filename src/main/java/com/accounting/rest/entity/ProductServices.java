package com.accounting.rest.entity;

import java.time.LocalDate;
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
public class ProductServices {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ps", allocationSize = 1)
	private Long psId;
	private Long ps_Id;
	private String psEngineerName;
	private Integer psNo;
	private LocalDate psDate;
	private String psStatus;
	private String psMessage;
	private boolean psSmsStatus;

	@OneToMany(targetEntity = ServiceProductSerialNo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ps_Id", referencedColumnName = "psId")
	private List<ServiceProductSerialNo> serviceProductSerialNo;

	public ProductServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServices(Long psId, Long ps_Id, String psEngineerName, Integer psNo, LocalDate psDate,
			String psStatus, String psMessage, boolean psSmsStatus,
			List<ServiceProductSerialNo> serviceProductSerialNo) {
		super();
		this.psId = psId;
		this.ps_Id = ps_Id;
		this.psEngineerName = psEngineerName;
		this.psNo = psNo;
		this.psDate = psDate;
		this.psStatus = psStatus;
		this.psMessage = psMessage;
		this.psSmsStatus = psSmsStatus;
		this.serviceProductSerialNo = serviceProductSerialNo;
	}

	public Long getPsId() {
		return psId;
	}

	public void setPsId(Long psId) {
		this.psId = psId;
	}

	public Long getPs_Id() {
		return ps_Id;
	}

	public void setPs_Id(Long ps_Id) {
		this.ps_Id = ps_Id;
	}

	public String getPsEngineerName() {
		return psEngineerName;
	}

	public void setPsEngineerName(String psEngineerName) {
		this.psEngineerName = psEngineerName;
	}

	public Integer getPsNo() {
		return psNo;
	}

	public void setPsNo(Integer psNo) {
		this.psNo = psNo;
	}

	public LocalDate getPsDate() {
		return psDate;
	}

	public void setPsDate(LocalDate psDate) {
		this.psDate = psDate;
	}

	public String getPsStatus() {
		return psStatus;
	}

	public void setPsStatus(String psStatus) {
		this.psStatus = psStatus;
	}

	public String getPsMessage() {
		return psMessage;
	}

	public void setPsMessage(String psMessage) {
		this.psMessage = psMessage;
	}

	public boolean isPsSmsStatus() {
		return psSmsStatus;
	}

	public void setPsSmsStatus(boolean psSmsStatus) {
		this.psSmsStatus = psSmsStatus;
	}

	public List<ServiceProductSerialNo> getServiceProductSerialNo() {
		return serviceProductSerialNo;
	}

	public void setServiceProductSerialNo(List<ServiceProductSerialNo> serviceProductSerialNo) {
		this.serviceProductSerialNo = serviceProductSerialNo;
	}

}
