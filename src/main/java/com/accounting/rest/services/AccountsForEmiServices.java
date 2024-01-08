package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForEmi;
import com.accounting.rest.post.service.PostAccountAMC;
import com.accounting.rest.repository.AccountsForEmiRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant

public class AccountsForEmiServices {
	@Autowired
	private AccountsForEmiRepo accountsForEmiRepo;
	@Autowired
	private AccountsServices accountsServices;
	@Autowired
	private PostAccountAMC postAccountAMC;

	@PostConstruct
	public void EMIAccountList() {
		postAccountAMC.AccountAMCList();
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
