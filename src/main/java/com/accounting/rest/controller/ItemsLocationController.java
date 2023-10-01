package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.entity.ItemsLocationList;
import com.accounting.rest.services.ItemsLocationService;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/items/location")
public class ItemsLocationController {
	private final ItemsLocationService itemsLocationService;

	@Autowired
	public ItemsLocationController(ItemsLocationService itemsLocationService) {
		super();
		this.itemsLocationService = itemsLocationService;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addItemsLocation(@RequestBody String locationName) {
		itemsLocationService.addItemGroup(locationName);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<ItemsLocationList>> getItemsLocationList() {
		return new ResponseEntity<>(itemsLocationService.getItemsLocation(), HttpStatus.OK);

	}
}
