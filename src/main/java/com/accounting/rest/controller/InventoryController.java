package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.GenericsInventoryItems;
import com.accounting.rest.dto.InventoryItemsDTO;
import com.accounting.rest.entity.InventoryGroup;
import com.accounting.rest.services.InventoryGroupService;
import com.accounting.rest.services.InventoryItemsService;

@RestController
//@CrossOrigin
@RequestMapping("api/inventory")
public class InventoryController {

	private final InventoryGroupService inventoryGroupService;
	private final InventoryItemsService inventoryItemsService;

	@Autowired
	public InventoryController(InventoryGroupService inventoryGroupService,
			InventoryItemsService inventoryItemsService) {
		super();
		this.inventoryGroupService = inventoryGroupService;
		this.inventoryItemsService = inventoryItemsService;
	}

	// Add Inventory
	@PostMapping("/add")
	public ResponseEntity<InventoryGroup> addInventory(@RequestBody InventoryGroup inventoryGroup) {
		return new ResponseEntity<>(inventoryGroupService.addInventory(inventoryGroup), HttpStatus.OK);

	}

	// Update Inventory
	@PutMapping("/update")

	public ResponseEntity<InventoryItemsDTO> updateInventory(@RequestBody InventoryItemsDTO items) {
		return new ResponseEntity<>(inventoryItemsService.updateInventory(items), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<GenericsInventoryItems>> getInventoryItems() {
		return new ResponseEntity<>(inventoryItemsService.getInventoryItems(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<InventoryItemsDTO> getInventoryItemDTOById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(inventoryItemsService.getInventoryItemDTOByiiId(id), HttpStatus.OK);

	}

}
