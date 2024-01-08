package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.LedgerDetails;
import com.accounting.rest.exception.LedgerDetailsNotFoundException;
import com.accounting.rest.repository.LedgerDetailsRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class LedgerDetailsServices {

	private final LedgerDetailsRepo ledgerDetailsRepo;

	@Autowired
	public LedgerDetailsServices(LedgerDetailsRepo ledgerDetailsRepo) {
		this.ledgerDetailsRepo = ledgerDetailsRepo;
	}

//Add Ledger

	public LedgerDetails addLedgerDetails(LedgerDetails ledgerDetails) {
		return ledgerDetailsRepo.save(ledgerDetails);

	}

	public List<LedgerDetails> addLedgerDetails(List<LedgerDetails> ledgerDetails) {
		return ledgerDetailsRepo.saveAll(ledgerDetails);

	}

//Find All Ledger 
	public List<LedgerDetails> findAllLedgerDetails() {
		return ledgerDetailsRepo.findAll();

	}

//Find Ledger By Id
	public LedgerDetails findLedgerDetailsById(Long id) {
		return ledgerDetailsRepo.findById(id).orElseThrow(() -> new LedgerDetailsNotFoundException(""));

	}

//Update Ledger

//Delete Ledger By Id
	public void deleteLedgerDetailsById(Long id) {
		ledgerDetailsRepo.deleteById(id);

	}

}
