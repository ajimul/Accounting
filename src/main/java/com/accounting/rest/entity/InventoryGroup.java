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

@Entity(name = "inventory_group")
public class InventoryGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_inventory_group", allocationSize = 1)

	private long igId;
	private String igName;

	@OneToMany(targetEntity = InventoryLocation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "il_igId", referencedColumnName = "igId")
	private List<InventoryLocation> inventoryLocations;

	public InventoryGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryGroup(long igId, String igName, List<InventoryLocation> inventoryLocations) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.inventoryLocations = inventoryLocations;
	}

	public InventoryGroup(String igName, List<InventoryLocation> inventoryLocations) {
		super();
		this.igName = igName;
		this.inventoryLocations = inventoryLocations;
	}

	public InventoryGroup(String igName) {
		super();
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

	public List<InventoryLocation> getInventoryLocations() {
		return inventoryLocations;
	}

	public void setInventoryLocations(List<InventoryLocation> inventoryLocations) {
		this.inventoryLocations = inventoryLocations;
	}

}
