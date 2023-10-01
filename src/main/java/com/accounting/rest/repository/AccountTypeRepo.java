
package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.AccountType;

public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {

//	@Query(value = "SELECT `acTypeId`,`acType` FROM AcType", nativeQuery = true)
//	List<AcType> find();

	@Query("select u from AccountType u where u.accountTypeName = :accountTypeName")
	AccountType getAccTypeId_ByName(@Param("accountTypeName") String accountTypeName);

	@Query("select u from AccountType u where u.accountTypeId = :accountTypeId")
	AccountType getAccTypeId_ById(@Param("accountTypeId") Long accountTypeId);

}
