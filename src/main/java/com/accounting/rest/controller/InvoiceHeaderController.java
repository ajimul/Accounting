package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.entity.InvoiceHeader;
import com.accounting.rest.services.InvoiceHeaderService;

@RestController
@RequestMapping("/api/invoice-headers")
public class InvoiceHeaderController {
	private final InvoiceHeaderService invoiceHeaderService;

	@Autowired
	public InvoiceHeaderController(InvoiceHeaderService invoiceHeaderService) {
		this.invoiceHeaderService = invoiceHeaderService;
	}

	@GetMapping("/")
	public List<InvoiceHeader> getAllInvoiceHeaders() {
		return invoiceHeaderService.getAllInvoiceHeaders();
	}

	@PostMapping("/add")
	public void createInvoiceHeader(@RequestBody InvoiceHeader newInvoiceHeader) {
		invoiceHeaderService.saveInvoiceHeader(newInvoiceHeader);
	}
}