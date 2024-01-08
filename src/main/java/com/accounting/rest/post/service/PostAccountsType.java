package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.AccountType;
import com.accounting.rest.repository.AccountTypeRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccountsType {
	@Autowired
	private AccountTypeRepo accountTypeRepo;

	public void AccountTypeAccountsList() {
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

	public AccountType getAccTypeId_ByName(String typeName) {
		return accountTypeRepo.getAccTypeId_ByName(typeName);

	}
}
