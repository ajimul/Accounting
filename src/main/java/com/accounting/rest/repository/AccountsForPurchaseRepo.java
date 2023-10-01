
package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.AccountsForPurchase;

public interface AccountsForPurchaseRepo extends JpaRepository<AccountsForPurchase, Long> {
	@Query("select u from AccountsForPurchase u where u.accountName = :accountName")
	AccountsForPurchase GetAccountIdByAccountName(@Param("accountName") String accountName);
}