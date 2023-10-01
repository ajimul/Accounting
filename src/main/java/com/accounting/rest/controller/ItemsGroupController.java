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

import com.accounting.rest.entity.ItemsGroupList;
import com.accounting.rest.services.ItemsGroupListService;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/items/group")
public class ItemsGroupController {
	private final ItemsGroupListService itemsGroupListService;

	@Autowired
	public ItemsGroupController(ItemsGroupListService itemsGroupListService) {
		super();
		this.itemsGroupListService = itemsGroupListService;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addItemsGroup(@RequestBody String groupName) {
		itemsGroupListService.addItemGroup(groupName);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<ItemsGroupList>> getItemsGroupList() {
		return new ResponseEntity<>(itemsGroupListService.getItemsGroupList(), HttpStatus.OK);

	}
}
