package com.accounting.rest.dto;

public class SerialNoDto {
	private Long sId;
	private String SerialNo;

	public SerialNoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SerialNoDto(Long sId, String serialNo) {
		super();
		this.sId = sId;
		SerialNo = serialNo;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}

}
