package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.AccountsForSales;
import com.accounting.rest.repository.AccountsForSalesRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccountSales {
	@Autowired
	private AccountsForSalesRepo accountsForSalesRepo;

	public void AccountsSalesList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Debtors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForSales> acList = new ArrayList<AccountsForSales>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForSales> optionalAc = Optional.ofNullable(new AccountsForSales());
			optionalAc = getAccountsSales(preeAccounts.get(i));
			if (!optionalAc.isPresent()) {
				AccountsForSales ac = new AccountsForSales();
				ac.setAccountName(preeAccounts.get(i));
				acList.add(ac);
			}

		}

		if (acList.size() != 0) {
			accountsForSalesRepo.saveAll(acList);
		}

	}

	public Optional<AccountsForSales> getAccountsSales(String typeName) {
		AccountsForSales ac = new AccountsForSales();
		ac = accountsForSalesRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForSales> opt = Optional.ofNullable(ac);
		return opt;

	}
}
