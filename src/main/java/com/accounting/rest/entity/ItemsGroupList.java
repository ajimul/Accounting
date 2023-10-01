package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemsGroupList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_Items_group", allocationSize = 1)
	private long igId;
	private String igName;

	public ItemsGroupList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsGroupList(long igId, String igName) {
		super();
		this.igId = igId;
		this.igName = igName;
	}

	public long getIgId() {
		return igId;
	}

	public void setIgId(long igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

}
