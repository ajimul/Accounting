package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.BooksDetailsDTO;
import com.accounting.rest.dto.GenericsInventoryItems;
import com.accounting.rest.dto.InventoryItemsDTO;
import com.accounting.rest.entity.InventoryItems;
import com.accounting.rest.repository.InventoryItemsRepo;

@Service
@Transactional
public class InventoryItemsService {
	private final InventoryItemsRepo inventoryItemsRepo;

	@Autowired
	public InventoryItemsService(InventoryItemsRepo inventoryItemsRepo) {
		super();
		this.inventoryItemsRepo = inventoryItemsRepo;
	}

//
////	 Add  InventoryItems
//	public void addInventoryItems(InventoryItems items) {
//		inventoryItemsRepo.save(items);
//	}
//
////	 Add List Of InventoryItems
	public List<InventoryItems> addInventoryItemsList(List<InventoryItems> items) {
		return inventoryItemsRepo.saveAll(items);
	}

//
// get InventoryItems By id
	public InventoryItems getInventoryItemByiiId(Long iiId) {
		return inventoryItemsRepo.getInventoryItemsById(iiId);
	}

	public InventoryItemsDTO getInventoryItemDTOByiiId(Long iiId) {
		InventoryItems newItems = new InventoryItems();
		newItems = inventoryItemsRepo.getInventoryItemsById(iiId);

		InventoryItemsDTO newItemDTO = new InventoryItemsDTO();
		newItemDTO.setIiId(newItems.getIiId());
		newItemDTO.setIi_ilId(newItems.getIi_ilId());
		newItemDTO.setIiQty(newItems.getIiQty());
		newItemDTO.setIiMrp(newItems.getIiMrp());
		newItemDTO.setIiPurchaseAmount(newItems.getIiPurchaseAmount());
		newItemDTO.setIiSalesAmount(newItems.getIiSalesAmount());
		newItemDTO.setIiTDPercent(newItems.getIiTDPercent());
		newItemDTO.setIiParticular(newItems.getIiParticular());
		newItemDTO.setIiHsn(newItems.getIiHsn());
		newItemDTO.setIiModelNo(newItems.getIiModelNo());
		newItemDTO.setIiUnitName(newItems.getIiUnitName());
		newItemDTO.setIiCgstPercent(newItems.getIiCgstPercent());
		newItemDTO.setIiSgstPercent(newItems.getIiSgstPercent());
		newItemDTO.setIiSgstPercent(newItems.getIiSgstPercent());
		newItemDTO.setIiSgstPercent(newItems.getIiSgstPercent());
		newItemDTO.setIiMonthOfWarranty(newItems.getIiMonthOfWarranty());

		return newItemDTO;
	}

	public InventoryItemsDTO updateInventory(InventoryItemsDTO item) {
		inventoryItemsRepo.UpdateInventoryItems(item.getIi_ilId(), item.getIiQty(), item.getIiMrp(),
				item.getIiPurchaseAmount(), item.getIiSalesAmount(), item.getIiTDPercent(), item.getIiParticular(),
				item.getIiHsn(), item.getIiModelNo(), item.getIiUnitName(), item.getIiCgstPercent(),
				item.getIiSgstPercent(), item.getIiIgstPercent(), item.getIiNoOfService(), item.getIiMonthOfWarranty(),
				item.getIiId());
		return item;
	}

	public List<GenericsInventoryItems> getInventoryItems() {
		List<InventoryItems> items = new ArrayList<InventoryItems>(inventoryItemsRepo.findAll());
		List<GenericsInventoryItems> newItems = new ArrayList<GenericsInventoryItems>();
		for (int i = 0; i < items.size(); i++) {
			GenericsInventoryItems item = new GenericsInventoryItems();
			item.setIiId(items.get(i).getIiId());
			item.setIi_ilId(items.get(i).getIi_ilId());
			item.setIiQty(items.get(i).getIiQty());
			item.setIiMrp(items.get(i).getIiMrp());
			item.setIiPurchaseAmount(items.get(i).getIiPurchaseAmount());
			item.setIiSalesAmount(items.get(i).getIiSalesAmount());
			item.setIiTDPercent(items.get(i).getIiTDPercent());
			item.setIiParticular(items.get(i).getIiParticular());
			item.setIiHsn(items.get(i).getIiHsn());
			item.setIiModelNo(items.get(i).getIiModelNo());
			item.setIiUnitName(items.get(i).getIiUnitName());
			item.setIiCgstPercent(items.get(i).getIiCgstPercent());
			item.setIiSgstPercent(items.get(i).getIiSgstPercent());
			item.setIiIgstPercent(items.get(i).getIiIgstPercent());
			item.setIiNoOfService(items.get(i).getIiNoOfService());
			item.setIiMonthOfWarranty(items.get(i).getIiMonthOfWarranty());
			newItems.add(item);
		}

		return newItems;

	}

	public List<BooksDetailsDTO> getbookDetailsByBookInfoId(Long bookInfoId) {
		List<BooksDetailsDTO> booksDetailsDTO = new ArrayList<BooksDetailsDTO>(
				inventoryItemsRepo.getInventoryItemsByBookInfoId(bookInfoId));
		return booksDetailsDTO;

	}

}
