package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.GenericsAccountsType;
import com.accounting.rest.entity.AccountType;
import com.accounting.rest.exception.AccountTypeNotFoundException;
import com.accounting.rest.repository.AccountTypeRepo;

@Service
public class AccountsTypeServices {

	private final AccountTypeRepo accountTypeRepo;

	@Autowired
	public AccountsTypeServices(AccountTypeRepo accountTypeRepo) {
		this.accountTypeRepo = accountTypeRepo;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccountTypes = new ArrayList<String>();
		preeAccountTypes.add("Direct Expenses");
		preeAccountTypes.add("Indirect Expenses");
		preeAccountTypes.add("Direct Income");
		preeAccountTypes.add("Indirect Income");
		preeAccountTypes.add("Current Assets");
		preeAccountTypes.add("Fixed Assets");
		preeAccountTypes.add("Current Liability");
		preeAccountTypes.add("Sundry Debtors");
		preeAccountTypes.add("Non Current Liability");
		preeAccountTypes.add("Capital Account");

		List<AccountType> acTypeList = new ArrayList<AccountType>();
		for (int i = 0; i < preeAccountTypes.size(); i++) {
			Optional<AccountType> optionalAcType = Optional.ofNullable(new AccountType());
			optionalAcType = Optional.ofNullable(getAccTypeId_ByName(preeAccountTypes.get(i)));
			if (!optionalAcType.isPresent()) {
				AccountType acType = new AccountType();
				acType.setAccountTypeName(preeAccountTypes.get(i));
				acType.setAccountTypeDebitAmount(null);
				acType.setAccountTypeCreditAmount(null);
				acTypeList.add(acType);
			}

		}

		if (acTypeList.size() != 0) {
			accountTypeRepo.saveAll(acTypeList);
		}

	}

//	public Optional<AccountType> getAccTypeId_ByName(String typeName) {
//		AccountType ac = new AccountType();
//		ac = accountTypeRepo.getAccTypeId_ByName(typeName);
//		Optional<AccountType> opt = Optional.ofNullable(ac);
//		return opt;
//
//	}

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
