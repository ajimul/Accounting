package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accounting.rest.entity.InvoiceHeader;

@Repository
public interface InvoiceHeaderRepo extends JpaRepository<InvoiceHeader, Long> {
	// You can add custom query methods here if needed
}