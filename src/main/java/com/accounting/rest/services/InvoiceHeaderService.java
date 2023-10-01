package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.InvoiceHeader;
import com.accounting.rest.repository.InvoiceHeaderRepository;

@Service
public class InvoiceHeaderService {
	private final InvoiceHeaderRepository invoiceHeaderRepository;

	@Autowired
	public InvoiceHeaderService(InvoiceHeaderRepository invoiceHeaderRepository) {
		this.invoiceHeaderRepository = invoiceHeaderRepository;
	}

	public void saveInvoiceHeader(InvoiceHeader newInvoiceHeader) {
		// You can add validation or additional logic as needed
		invoiceHeaderRepository.save(newInvoiceHeader);
	}

	public void editInvoiceHeader(InvoiceHeader updatedInvoiceHeader) {
		// You can add validation or additional logic as needed
		invoiceHeaderRepository.save(updatedInvoiceHeader);
	}

	public List<InvoiceHeader> getAllInvoiceHeaders() {

		return invoiceHeaderRepository.findAll();
	}
}
