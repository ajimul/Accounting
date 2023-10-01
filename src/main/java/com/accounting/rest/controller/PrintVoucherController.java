package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto_maper.InvoiceDetailsDto;
import com.accounting.rest.services.InvoiceDetailsService;

@RestController
@RequestMapping("api/invoice")
public class PrintVoucherController {
	private final InvoiceDetailsService invoiceDetailsService;

	@Autowired
	public PrintVoucherController(InvoiceDetailsService invoiceDetailsService) {
		super();
		this.invoiceDetailsService = invoiceDetailsService;

	}

	@GetMapping("/")
	public ResponseEntity<List<InvoiceDetailsDto>> getInvoiceList() {
		return new ResponseEntity<>(invoiceDetailsService.getInvoiceList(), HttpStatus.OK);

	}

}
