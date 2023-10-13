package com.accounting.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class Bom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bom_sequence")
	@SequenceGenerator(name = "bom_sequence", sequenceName = "SequenceGenerator_bom", allocationSize = 1)
	private Long bomId;

	@OneToOne(targetEntity = InventoryItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bomItemsId_Ref", referencedColumnName = "iiId")
	private Long bomItemsId_Ref;
	private int qty;
	private String status;

	@OneToMany(targetEntity = Bomlist.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bomListBomId_Ref", referencedColumnName = "bomId")
	private List<Bomlist> bomList;

	@OneToMany(targetEntity = ExtraCost.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "etraCostBomId_Ref", referencedColumnName = "bomId")
	private List<ExtraCost> extraCost;

	public Bom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bom(Long bomId, Long bomItemsId_Ref, int qty, String status, List<Bomlist> bomList,
			List<ExtraCost> extraCost) {
		super();
		this.bomId = bomId;
		this.bomItemsId_Ref = bomItemsId_Ref;
		this.qty = qty;
		this.status = status;
		this.bomList = bomList;
		this.extraCost = extraCost;
	}

	public Long getBomId() {
		return bomId;
	}

	public void setBomId(Long bomId) {
		this.bomId = bomId;
	}

	public Long getBomItemsId_Ref() {
		return bomItemsId_Ref;
	}

	public void setBomItemsId_Ref(Long bomItemsId_Ref) {
		this.bomItemsId_Ref = bomItemsId_Ref;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Bomlist> getBomList() {
		return bomList;
	}

	public void setBomList(List<Bomlist> bomList) {
		this.bomList = bomList;
	}

	public List<ExtraCost> getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(List<ExtraCost> extraCost) {
		this.extraCost = extraCost;
	}

}
