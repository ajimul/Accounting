package com.accounting.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.InventoryGroup;
import com.accounting.rest.repository.InventoryGroupRepo;

@Service
public class InventoryGroupService {
	private final InventoryGroupRepo inventoryGroupRepo;

	@Autowired
	public InventoryGroupService(InventoryGroupRepo inventoryGroupRepo) {
		super();
		this.inventoryGroupRepo = inventoryGroupRepo;
	}

	public InventoryGroup addInventory(InventoryGroup inventoryGroup) {
		return inventoryGroupRepo.save(inventoryGroup);

	}

}
