package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForSales;
import com.accounting.rest.post.service.PostAccountSales;
import com.accounting.rest.repository.AccountsForSalesRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant

public class AccountsForSalesServices {

	@Autowired
	private AccountsForSalesRepo accountsForSalesRepo;
	@Autowired
	private AccountsServices accountsServices;

	@Autowired
	public PostAccountSales postAccountSales;

	@PostConstruct
	public void SalesAccountList() {
		postAccountSales.AccountsSalesList();
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
