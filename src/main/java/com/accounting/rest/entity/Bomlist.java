package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Bomlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bomList_sequence")
	@SequenceGenerator(name = "bomList_sequence", sequenceName = "SequenceGenerator_bomList", allocationSize = 1)
	private Long bomListId;
	private Long bomListBomId_Ref;
	private Long bomListItemsId_Ref;

	public Bomlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bomlist(Long bomListId, Long bomListBomId_Ref, Long bomListItemsId_Ref) {
		super();
		this.bomListId = bomListId;
		this.bomListBomId_Ref = bomListBomId_Ref;
		this.bomListItemsId_Ref = bomListItemsId_Ref;
	}

	public Long getBomListId() {
		return bomListId;
	}

	public void setBomListId(Long bomListId) {
		this.bomListId = bomListId;
	}

	public Long getBomListBomId_Ref() {
		return bomListBomId_Ref;
	}

	public void setBomListBomId_Ref(Long bomListBomId_Ref) {
		this.bomListBomId_Ref = bomListBomId_Ref;
	}

	public Long getBomListItemsId_Ref() {
		return bomListItemsId_Ref;
	}

	public void setBomListItemsId_Ref(Long bomListItemsId_Ref) {
		this.bomListItemsId_Ref = bomListItemsId_Ref;
	}

}
