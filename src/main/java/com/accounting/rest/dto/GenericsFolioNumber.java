package com.accounting.rest.dto;

public class GenericsFolioNumber {

	private Long folioId;
	private String folioNarration;

	public GenericsFolioNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericsFolioNumber(Long folioId, String folioNarration) {
		super();
		this.folioId = folioId;
		this.folioNarration = folioNarration;
	}

	public GenericsFolioNumber(String folioNarration) {
		super();
		this.folioNarration = folioNarration;
	}

	public Long getFolioId() {
		return folioId;
	}

	public void setFolioId(Long folioId) {
		this.folioId = folioId;
	}

	public String getFolioNarration() {
		return folioNarration;
	}

	public void setFolioNarration(String folioNarration) {
		this.folioNarration = folioNarration;
	}

}
