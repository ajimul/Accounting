package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.BooksDetailsDTO;
import com.accounting.rest.dto.GenericsInventoryItems;
import com.accounting.rest.services.InventoryItemsService;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/inven/items")
public class InventoryItemsController {

	private final InventoryItemsService inventoryItemsService;

	@Autowired
	public InventoryItemsController(InventoryItemsService inventoryItemsService) {
		super();

		this.inventoryItemsService = inventoryItemsService;
	}

	@GetMapping("/")
	public ResponseEntity<List<GenericsInventoryItems>> getInventoryItems() {
		return new ResponseEntity<>(inventoryItemsService.getInventoryItems(), HttpStatus.OK);

	}

	@GetMapping("/books/{bookinfoId}")
	public ResponseEntity<List<BooksDetailsDTO>> getInventoryItems(@PathVariable Long bookinfoId) {
		return new ResponseEntity<>(inventoryItemsService.getbookDetailsByBookInfoId(bookinfoId), HttpStatus.OK);

	}

}
