package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.ItemsLocationList;
import com.accounting.rest.repository.ItemsLocationListRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class ItemsLocationService {
	private final ItemsLocationListRepo itemsLocationListRepo;

	@Autowired
	public ItemsLocationService(ItemsLocationListRepo itemsLocationListRepo) {
		super();
		this.itemsLocationListRepo = itemsLocationListRepo;
	}

	public List<ItemsLocationList> getItemsLocation() {
		return itemsLocationListRepo.findAll();

	}

	public void addItemGroup(String locationName) {
		ItemsLocationList newLocation = new ItemsLocationList();
		newLocation.setIlName(locationName);
		itemsLocationListRepo.save(newLocation);
	}

}
