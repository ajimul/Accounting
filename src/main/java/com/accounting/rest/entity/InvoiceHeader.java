package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InvoiceHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_InvoiceHeader", allocationSize = 1)
	private Long id;

	private String organizationName;
	private String contactDetails; // Renamed from addressingAndContactDetails

	public InvoiceHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceHeader(Long id, String organizationName, String contactDetails) {
		super();
		this.id = id;
		this.organizationName = organizationName;
		this.contactDetails = contactDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

}