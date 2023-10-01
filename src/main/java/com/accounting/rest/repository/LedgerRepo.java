package com.accounting.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.Ledger;

public interface LedgerRepo extends JpaRepository<Ledger, Long> {

	@Query("select u from Ledger u where u.ledgerId = :ledgerId")
	List<Ledger> getLadgerId(@Param("ledgerId") Long ledgerId);

	@Query("select u from Ledger u where u.ledgerAccount_Ref = :accountId")
	List<Ledger> getLadgerByAccount_Ref(@Param("accountId") Long accountId);

	@Query("select u from Ledger u where u.ledgerFolio_Ref = :folioId")
	List<Ledger> getLadgerByFolio_Ref(@Param("folioId") Long folioId);

}
