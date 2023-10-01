package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.ItemsGroupList;
import com.accounting.rest.repository.ItemsGroupListRepo;

@Service
public class ItemsGroupListService {

	private final ItemsGroupListRepo itemsGroupListRepo;

	@Autowired
	public ItemsGroupListService(ItemsGroupListRepo itemsGroupListRepo) {
		super();
		this.itemsGroupListRepo = itemsGroupListRepo;
	}

	public List<ItemsGroupList> getItemsGroupList() {
		return itemsGroupListRepo.findAll();
	}

	public void addItemGroup(String groupName) {
		ItemsGroupList newGroup = new ItemsGroupList();
		newGroup.setIgName(groupName);
		itemsGroupListRepo.save(newGroup);
	}

}
