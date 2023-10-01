package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.InventoryJournal;
import com.accounting.rest.repository.InventoryJournalRepo;

@Service
public class Inventory_JournalService {
	private final InventoryJournalRepo inventoryJournalRepo;

	@Autowired
	public Inventory_JournalService(InventoryJournalRepo inventoryJournalRepo) {
		super();
		this.inventoryJournalRepo = inventoryJournalRepo;
	}

	public List<InventoryJournal> getInventoryJournal_ByVoucherId(Long VoucherNo) {
		List<InventoryJournal> newInventoryJournal = new ArrayList<InventoryJournal>();
		newInventoryJournal = inventoryJournalRepo.getInventoryJournal_ByVoucherId(VoucherNo);
		return newInventoryJournal;

	}

	public void deleteInventoryJournalById(Long id) {
		inventoryJournalRepo.deleteById(id);
	}

//	public List<InventoryJournal> addInventoryjournal(List<InventoryJournal> inventoryJournal) {
//		for (int i = 0; i < inventoryJournal.size(); i++) {
//			InventoryItems item = new InventoryItems();
//			item = inventoryItemsService.getInventoryByiiId(inventoryJournal.get(i).getIj_iiId());
//			Integer qualtity = item.getIiQty();
//			item.setIiQty(qualtity + inventoryJournal.get(i).getIjInwardQty());
//			inventoryItemsService.addInventoryItems(item);
//		}
//		return inventoryJournalRepo.saveAll(inventoryJournal);
//	}
}