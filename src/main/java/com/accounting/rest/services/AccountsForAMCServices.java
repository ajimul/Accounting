package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForAMC;
import com.accounting.rest.repository.AccountsForAMCRepo;

@Service
@Transactional

public class AccountsForAMCServices {

	private final AccountsForAMCRepo accountsForAMCRepo;
	private final AccountsServices accountsServices;

	@Autowired
	public AccountsForAMCServices(AccountsForAMCRepo accountsForAMCRepo, AccountsServices accountsServices) {
		this.accountsForAMCRepo = accountsForAMCRepo;
		this.accountsServices = accountsServices;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Sundry Debtors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForAMC> acList = new ArrayList<AccountsForAMC>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForAMC> optionalAc = Optional.ofNullable(new AccountsForAMC());
			optionalAc = getAccounts(preeAccounts.get(i));
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

	// Find Accounts By Name
	public Optional<AccountsForAMC> getAccounts(String typeName) {
		AccountsForAMC ac = new AccountsForAMC();
		ac = accountsForAMCRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForAMC> opt = Optional.ofNullable(ac);
		return opt;

	}

	public List<TransactionalAccountDTO> getAccountForAMC() {
		List<AccountsForAMC> getAc = new ArrayList<AccountsForAMC>();
		getAc = accountsForAMCRepo.findAll();
		List<TransactionalAccountDTO> newGenericsAccounts = new ArrayList<TransactionalAccountDTO>();
		for (AccountsForAMC amcAccount : getAc) {
			TransactionalAccountDTO genericsAccounts = new TransactionalAccountDTO();
			genericsAccounts = accountsServices.getTransactionalAccount(amcAccount.getAccountName());
			newGenericsAccounts.add(genericsAccounts);
		}

		return newGenericsAccounts;
	}

}
