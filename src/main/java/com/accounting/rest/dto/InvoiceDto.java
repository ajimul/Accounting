package com.accounting.rest.dto;

import java.util.List;

public class InvoiceDto {

	private InvoiceJRParameter invoiceJRParameter;
	private List<InvoiceJRBeanDataSource> invoiceJRBeanDataSource;

	public InvoiceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDto(InvoiceJRParameter invoiceJRParameter, List<InvoiceJRBeanDataSource> invoiceJRBeanDataSource) {
		super();
		this.invoiceJRParameter = invoiceJRParameter;
		this.invoiceJRBeanDataSource = invoiceJRBeanDataSource;
	}

	public InvoiceJRParameter getInvoiceJRParameter() {
		return invoiceJRParameter;
	}

	public void setInvoiceJRParameter(InvoiceJRParameter invoiceJRParameter) {
		this.invoiceJRParameter = invoiceJRParameter;
	}

	public List<InvoiceJRBeanDataSource> getInvoiceJRBeanDataSource() {
		return invoiceJRBeanDataSource;
	}

	public void setInvoiceJRBeanDataSource(List<InvoiceJRBeanDataSource> invoiceJRBeanDataSource) {
		this.invoiceJRBeanDataSource = invoiceJRBeanDataSource;
	}

}