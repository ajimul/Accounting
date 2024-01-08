package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.GenericsAccountsType;
import com.accounting.rest.entity.AccountType;
import com.accounting.rest.exception.AccountTypeNotFoundException;
import com.accounting.rest.post.service.PostAccountsType;
import com.accounting.rest.repository.AccountTypeRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager") // Use For Multitenant
public class AccountsTypeServices {
	@Autowired
	private AccountTypeRepo accountTypeRepo;

	@Autowired
	public PostAccountsType postAccountsType;

	@PostConstruct
	public void AccountsTypeList() {
		postAccountsType.AccountTypeAccountsList();
	}

//Add AccountsType

	public AccountType addAccountsType(AccountType accountType) {
		return accountTypeRepo.save(accountType);

	}

//Find All AccountsType 
	public List<GenericsAccountsType> findAllAccountsType() {
		List<GenericsAccountsType> typeAccounts = new ArrayList<GenericsAccountsType>();
		List<AccountType> accountsTypeList = accountTypeRepo.findAll();
		for (AccountType accountTypes : accountsTypeList) {
			GenericsAccountsType newAccounts = new GenericsAccountsType();
			newAccounts.setAccountTypeId(accountTypes.getAccountTypeId());
			newAccounts.setAccountTypeName(accountTypes.getAccountTypeName());
			newAccounts.setAccountTypeCreditAmount(accountTypes.getAccountTypeCreditAmount());
			newAccounts.setAccountTypeDebitAmount(accountTypes.getAccountTypeDebitAmount());

			typeAccounts.add(newAccounts);

		}

		return typeAccounts;

	}

	// Find AccountTypesName By Id
	public AccountType findAccountsTypeById(Long id) {
		return accountTypeRepo.findById(id).orElseThrow(() -> new AccountTypeNotFoundException(""));

	}

//Find AccountTypesId By Name
	public AccountType getAccTypeId_ByName(String typeName) {
		return accountTypeRepo.getAccTypeId_ByName(typeName);

	}

//Update AccountType By Id
	public AccountType updateAccountsType(AccountType accountType) {
		accountTypeRepo.deleteById(accountType.getAccountTypeId());// if accountType id is !importent -> delete maching
																	// accountTypes // ->insert new accountType
		return accountTypeRepo.save(accountType);

	}

//Delete AccountType By Id
	public void deleteAccountsTypeById(Long id) {

		accountTypeRepo.deleteById(id);

	}

}
