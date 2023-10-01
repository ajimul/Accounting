package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.LedgerDetails;

public interface LedgerDetailsRepo extends JpaRepository<LedgerDetails, Long> {

}
