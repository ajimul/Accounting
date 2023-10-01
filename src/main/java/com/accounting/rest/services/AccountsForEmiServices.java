package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForEmi;
import com.accounting.rest.repository.AccountsForEmiRepo;

@Service
@Transactional

public class AccountsForEmiServices {

	private final AccountsForEmiRepo accountsForEmiRepo;
	private final AccountsServices accountsServices;

	@Autowired
	public AccountsForEmiServices(AccountsForEmiRepo accountsForEmiRepo, AccountsServices accountsServices) {
		this.accountsForEmiRepo = accountsForEmiRepo;
		this.accountsServices = accountsServices;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForEmi> acList = new ArrayList<AccountsForEmi>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForEmi> optionalAc = Optional.ofNullable(new AccountsForEmi());
			optionalAc = getAccounts(preeAccounts.get(i));
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

	// Find Accounts By Name
	public Optional<AccountsForEmi> getAccounts(String typeName) {
		AccountsForEmi ac = new AccountsForEmi();
		ac = accountsForEmiRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForEmi> opt = Optional.ofNullable(ac);
		return opt;

	}

	public List<TransactionalAccountDTO> getAccountForEmi() {
		List<AccountsForEmi> getAc = new ArrayList<AccountsForEmi>();
		getAc = accountsForEmiRepo.findAll();
		List<TransactionalAccountDTO> newGenericsAccounts = new ArrayList<TransactionalAccountDTO>();
		for (AccountsForEmi emiAccount : getAc) {
			TransactionalAccountDTO genericsAccounts = new TransactionalAccountDTO();
			genericsAccounts = accountsServices.getTransactionalAccount(emiAccount.getAccountName());
			newGenericsAccounts.add(genericsAccounts);
		}

		return newGenericsAccounts;
	}

}
