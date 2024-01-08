package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.AccountsForAMC;
import com.accounting.rest.repository.AccountsForAMCRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccountAMC {
	@Autowired
	private AccountsForAMCRepo accountsForAMCRepo;

	public void AccountAMCList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Debtors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForAMC> acList = new ArrayList<AccountsForAMC>();

		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForAMC> optionalAc = Optional.ofNullable(new AccountsForAMC());
			optionalAc = getAccountsAMC(preeAccounts.get(i));
			if (!optionalAc.isPresent()) {
				AccountsForAMC ac = new AccountsForAMC();
				ac.setAccountName(preeAccounts.get(i));
				acList.add(ac);
			}

		}

		if (acList.size() != 0) {
			accountsForAMCRepo.saveAll(acList);
		}

	}

	public Optional<AccountsForAMC> getAccountsAMC(String typeName) {
		AccountsForAMC ac = new AccountsForAMC();
		ac = accountsForAMCRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForAMC> opt = Optional.ofNullable(ac);
		return opt;

	}
}
