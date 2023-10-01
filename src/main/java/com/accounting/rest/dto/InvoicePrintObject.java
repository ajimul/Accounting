package com.accounting.rest.dto;

import java.util.List;

public class InvoicePrintObject {
	private String accountName;
	private List<InvoiceJRBeanDataSource> invoiceJRBeanDataSources;

	public InvoicePrintObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoicePrintObject(String accountName, List<InvoiceJRBeanDataSource> invoiceJRBeanDataSources) {
		super();
		this.accountName = accountName;
		this.invoiceJRBeanDataSources = invoiceJRBeanDataSources;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<InvoiceJRBeanDataSource> getInvoiceJRBeanDataSources() {
		return invoiceJRBeanDataSources;
	}

	public void setInvoiceJRBeanDataSources(List<InvoiceJRBeanDataSource> invoiceJRBeanDataSources) {
		this.invoiceJRBeanDataSources = invoiceJRBeanDataSources;
	}

}
