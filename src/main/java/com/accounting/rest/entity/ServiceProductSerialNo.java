package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ServiceProductSerialNo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "sequence_generator_spSerialNo", allocationSize = 1)
	private Long sId;
	private Long ps_Id;

	private String SerialNo;

	public ServiceProductSerialNo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProductSerialNo(Long sId, Long ps_Id, String serialNo) {
		super();
		this.sId = sId;
		this.ps_Id = ps_Id;
		SerialNo = serialNo;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public Long getPs_Id() {
		return ps_Id;
	}

	public void setPs_Id(Long ps_Id) {
		this.ps_Id = ps_Id;
	}

	public String getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}

}