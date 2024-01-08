package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForSalary;
import com.accounting.rest.post.service.PostAccountSalary;
import com.accounting.rest.repository.AccountsForSalaryRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager") // Use For Multitenant

public class AccountsForSalaryServices {

	@Autowired
	private AccountsForSalaryRepo accountsForSalaryRepo;
	@Autowired
	private AccountsServices accountsServices;

	@Autowired
	public PostAccountSalary postAccountSalary;

	@PostConstruct
	public void SalaryAccountList() {
		postAccountSalary.AccountSalaryList();
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
