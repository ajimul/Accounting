package com.accounting.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "inventory_location")
public class InventoryLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_inventory_location", allocationSize = 1)
	private Long ilId;
	private String ilName;
	private Long il_igId;

	@OneToMany(targetEntity = InventoryItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ii_ilId", referencedColumnName = "ilId")
	private List<InventoryItems> inventoryItems;

	public InventoryLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryLocation(Long ilId, String ilName, Long il_igId, List<InventoryItems> inventoryItems) {
		super();
		this.ilId = ilId;
		this.ilName = ilName;
		this.il_igId = il_igId;
		this.inventoryItems = inventoryItems;
	}

	public InventoryLocation(String ilName, Long il_igId, List<InventoryItems> inventoryItems) {
		super();
		this.ilName = ilName;
		this.il_igId = il_igId;
		this.inventoryItems = inventoryItems;
	}

	public InventoryLocation(String ilName, List<InventoryItems> inventoryItems) {
		super();
		this.ilName = ilName;
		this.inventoryItems = inventoryItems;
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

	public Long getIl_igId() {
		return il_igId;
	}

	public void setIl_igId(Long il_igId) {
		this.il_igId = il_igId;
	}

	public List<InventoryItems> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItems> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

}
