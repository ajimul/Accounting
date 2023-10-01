package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TradingItemsSerialNo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "sequence_generator_iiSerialNo", allocationSize = 1)
	private Long sId;
	private Long bd_Id;
	private String serialNo;

	public TradingItemsSerialNo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradingItemsSerialNo(Long sId, Long bd_Id, String serialNo) {
		super();
		this.sId = sId;
		this.bd_Id = bd_Id;
		this.serialNo = serialNo;
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
