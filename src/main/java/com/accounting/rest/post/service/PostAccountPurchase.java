package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.AccountsForPurchase;
import com.accounting.rest.repository.AccountsForPurchaseRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccountPurchase {
	@Autowired
	private AccountsForPurchaseRepo accountsForPurchaseRepo;

	public void AccountsPurchaseList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Creditors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForPurchase> acList = new ArrayList<AccountsForPurchase>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForPurchase> optionalAc = Optional.ofNullable(new AccountsForPurchase());
			optionalAc = getAccountsPurchase(preeAccounts.get(i));
			if (!optionalAc.isPresent()) {
				AccountsForPurchase ac = new AccountsForPurchase();
				ac.setAccountName(preeAccounts.get(i));
				acList.add(ac);
			}

		}

		if (acList.size() != 0) {
			accountsForPurchaseRepo.saveAll(acList);
		}
	}

	public Optional<AccountsForPurchase> getAccountsPurchase(String typeName) {
		AccountsForPurchase ac = new AccountsForPurchase();
		ac = accountsForPurchaseRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForPurchase> opt = Optional.ofNullable(ac);
		return opt;

	}
}
