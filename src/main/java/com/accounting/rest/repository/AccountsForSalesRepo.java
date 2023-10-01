
package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.AccountsForSales;

public interface AccountsForSalesRepo extends JpaRepository<AccountsForSales, Long> {
	@Query("select u from AccountsForSales u where u.accountName = :accountName")
	AccountsForSales GetAccountIdByAccountName(@Param("accountName") String accountName);
}
