package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.InvoiceDto;
import com.accounting.rest.dto.PartyBookInfoDto;
import com.accounting.rest.repository.InventoryItemsRepo;
import com.accounting.rest.services.AccountsServices;
import com.accounting.rest.services.FolioNumberServices;
import com.accounting.rest.services.InvoiceDetailsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TestController {
	@Autowired
	private AccountsServices AccountsServices;
	@Autowired
	private FolioNumberServices folioNumberServices;
	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@Autowired
	private InventoryItemsRepo inventoryItemsRepo;

//	@GetMapping("/test")
//	public ResponseEntity<String> getData() {
////		String requestOrigin = request.getHeader("Origin");
////
////		// Replace "http://your-allowed-origin.com" with the actual allowed origin
////		if ("http://localhost:4200".equals(requestOrigin)) {
////			// Request is from the same origin, handle it
////			return ResponseEntity.ok("Request from the same origin.");
////		} else {
////			// Request is from a different origin, handle accordingly
////			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cross-origin request not allowed.");
////		}
//		return ResponseEntity.ok("Received Request");
//	}
	@GetMapping("/account/{id}")
	public ResponseEntity<InvoiceDto> getParty(@PathVariable Long id) {
		return new ResponseEntity<>(folioNumberServices.getInvoiceByFolioId(id), HttpStatus.OK);
	}

	@GetMapping("/test")
	public ResponseEntity<List<PartyBookInfoDto>> getInvoiceList() {
		invoiceDetailsService.getPartyBookInfoDtoCheck();
//		return new ResponseEntity<>("I Am Not Work! In Security Group", HttpStatus.OK);
		return new ResponseEntity<>(invoiceDetailsService.getPartyBookInfoDtoCheck(), HttpStatus.OK);

	}

	@GetMapping("/test2")
	public ResponseEntity<InvoiceDto> getBookList() {
		InvoiceDto invoice = new InvoiceDto();
		invoice = folioNumberServices.getInvoiceByFolioId(1l);
		return new ResponseEntity<>(invoice, HttpStatus.OK);

	}
}