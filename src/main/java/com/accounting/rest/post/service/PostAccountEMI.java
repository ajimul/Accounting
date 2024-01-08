package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.AccountsForEmi;
import com.accounting.rest.repository.AccountsForEmiRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccountEMI {
	@Autowired
	private AccountsForEmiRepo accountsForEmiRepo;

	public void AccountEMIList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForEmi> acList = new ArrayList<AccountsForEmi>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForEmi> optionalAc = Optional.ofNullable(new AccountsForEmi());
			optionalAc = getAccountsEMI(preeAccounts.get(i));
			if (!optionalAc.isPresent()) {
				AccountsForEmi ac = new AccountsForEmi();
				ac.setAccountName(preeAccounts.get(i));
				acList.add(ac);
			}

		}

		if (acList.size() != 0) {
			accountsForEmiRepo.saveAll(acList);
		}

	}

	public Optional<AccountsForEmi> getAccountsEMI(String typeName) {
		AccountsForEmi ac = new AccountsForEmi();
		ac = accountsForEmiRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForEmi> opt = Optional.ofNullable(ac);
		return opt;
	}
}
