package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForSales;
import com.accounting.rest.repository.AccountsForSalesRepo;

@Service
@Transactional

public class AccountsForSalesServices {

	private final AccountsForSalesRepo accountsForSalesRepo;
	private final AccountsServices accountsServices;

	@Autowired
	public AccountsForSalesServices(AccountsForSalesRepo accountsForSalesRepo, AccountsServices accountsServices) {
		this.accountsForSalesRepo = accountsForSalesRepo;
		this.accountsServices = accountsServices;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Debtors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForSales> acList = new ArrayList<AccountsForSales>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForSales> optionalAc = Optional.ofNullable(new AccountsForSales());
			optionalAc = getAccounts(preeAccounts.get(i));
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

	// Find Accounts By Name
	public Optional<AccountsForSales> getAccounts(String typeName) {
		AccountsForSales ac = new AccountsForSales();
		ac = accountsForSalesRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForSales> opt = Optional.ofNullable(ac);
		return opt;

	}

	public List<TransactionalAccountDTO> getAccountForSales() {
		List<AccountsForSales> getAc = new ArrayList<AccountsForSales>();
		getAc = accountsForSalesRepo.findAll();
		List<TransactionalAccountDTO> newGenericsAccounts = new ArrayList<TransactionalAccountDTO>();
		for (AccountsForSales salesAccount : getAc) {
			TransactionalAccountDTO genericsAccounts = new TransactionalAccountDTO();
			genericsAccounts = accountsServices.getTransactionalAccount(salesAccount.getAccountName());
			newGenericsAccounts.add(genericsAccounts);
		}

		return newGenericsAccounts;
	}

}
