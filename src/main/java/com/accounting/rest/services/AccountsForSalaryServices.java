package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForSalary;
import com.accounting.rest.repository.AccountsForSalaryRepo;

@Service
@Transactional

public class AccountsForSalaryServices {

	private final AccountsForSalaryRepo accountsForSalaryRepo;
	private final AccountsServices accountsServices;

	@Autowired
	public AccountsForSalaryServices(AccountsForSalaryRepo accountsForSalaryRepo, AccountsServices accountsServices) {
		this.accountsForSalaryRepo = accountsForSalaryRepo;
		this.accountsServices = accountsServices;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");

		List<AccountsForSalary> acList = new ArrayList<AccountsForSalary>();
		for (int i = 0; i < preeAccounts.size(); i++) {
			Optional<AccountsForSalary> optionalAc = Optional.ofNullable(new AccountsForSalary());
			optionalAc = getAccounts(preeAccounts.get(i));
			if (!optionalAc.isPresent()) {
				AccountsForSalary ac = new AccountsForSalary();
				ac.setAccountName(preeAccounts.get(i));
				acList.add(ac);
			}

		}

		if (acList.size() != 0) {
			accountsForSalaryRepo.saveAll(acList);
		}

	}

	// Find Accounts By Name
	public Optional<AccountsForSalary> getAccounts(String typeName) {
		AccountsForSalary ac = new AccountsForSalary();
		ac = accountsForSalaryRepo.GetAccountIdByAccountName(typeName);
		Optional<AccountsForSalary> opt = Optional.ofNullable(ac);
		return opt;

	}

	public List<TransactionalAccountDTO> getAccountForSalary() {
		List<AccountsForSalary> getAc = new ArrayList<AccountsForSalary>();
		getAc = accountsForSalaryRepo.findAll();

		List<TransactionalAccountDTO> newGenericsAccounts = new ArrayList<TransactionalAccountDTO>();
		for (AccountsForSalary salaryAccount : getAc) {

			TransactionalAccountDTO genericsAccounts = new TransactionalAccountDTO();
			genericsAccounts = accountsServices.getTransactionalAccount(salaryAccount.getAccountName());
			newGenericsAccounts.add(genericsAccounts);
		}

		return newGenericsAccounts;
	}

}
