package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForPurchase;
import com.accounting.rest.repository.AccountsForPurchaseRepo;

@Service
@Transactional

public class AccountsForPurchaseServices {

	private final AccountsForPurchaseRepo accountsForPurchaseRepo;
	private final AccountsServices accountsServices;

	@Autowired
	public AccountsForPurchaseServices(AccountsForPurchaseRepo accountsForPurchaseRepo,
			AccountsServices accountsServices) {
		super();
		this.accountsForPurchaseRepo = accountsForPurchaseRepo;
		this.accountsServices = accountsServices;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Creditors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForPurchase> acList = new ArrayList<AccountsForPurchase>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForPurchase> optionalAc = Optional.ofNullable(new AccountsForPurchase());
			optionalAc = getAccounts(preeAccounts.get(i));
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

	// Find Accounts By Name
	public Optional<AccountsForPurchase> getAccounts(String typeName) {
		AccountsForPurchase ac = new AccountsForPurchase();
		ac = accountsForPurchaseRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForPurchase> opt = Optional.ofNullable(ac);
		return opt;

	}

	public List<TransactionalAccountDTO> getAccountForPurchase() {
		List<AccountsForPurchase> getAc = new ArrayList<AccountsForPurchase>();
		getAc = accountsForPurchaseRepo.findAll();
		List<TransactionalAccountDTO> newGenericsAccounts = new ArrayList<TransactionalAccountDTO>();
		for (AccountsForPurchase purchaseAccount : getAc) {
			TransactionalAccountDTO genericsAccounts = new TransactionalAccountDTO();
			genericsAccounts = accountsServices.getTransactionalAccount(purchaseAccount.getAccountName());
			newGenericsAccounts.add(genericsAccounts);
		}

		return newGenericsAccounts;
	}

}
