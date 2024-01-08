
package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.AccountsForAMC;

public interface AccountsForAMCRepo extends JpaRepository<AccountsForAMC, Long> {
	@Query("select u from AccountsForAMC u where u.accountName = :accountName")
	AccountsForAMC GetAccountIdByAccountName(@Param("accountName") String accountName);

//
//	@Query(value = "SELECT c FROM #{#entityName} c WHERE  c.accountName = :accountName")
//	AccountsForAMC GetAccountIdByAccountName(@Param("accountName") String accountName);
//	
//	
//	
//    @Query(value = "SELECT c FROM #{#entityName} c WHERE c.accountName = :name")
//    AccountsForAMC GetAMCEntity(@Param("name") String name);

}