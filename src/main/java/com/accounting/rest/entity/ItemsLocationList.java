package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemsLocationList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_Items_Location", allocationSize = 1)
	private Long ilId;
	private String ilName;

	public ItemsLocationList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsLocationList(Long ilId, String ilName) {
		super();
		this.ilId = ilId;
		this.ilName = ilName;
	}

	public Long getIlId() {
		return ilId;
	}

	public void setIlId(Long ilId) {
		this.ilId = ilId;
	}

	public String getIlName() {
		return ilName;
	}

	public void setIlName(String ilName) {
		this.ilName = ilName;
	}

}
