package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.AccountsForPurchase;
import com.accounting.rest.post.service.PostAccountPurchase;
import com.accounting.rest.repository.AccountsForPurchaseRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant

public class AccountsForPurchaseServices {
	@Autowired
	private AccountsForPurchaseRepo accountsForPurchaseRepo;
	@Autowired
	private AccountsServices accountsServices;
	@Autowired
	public PostAccountPurchase postAccountPurchase;

	@PostConstruct
	public void PurchaseAccountList() {
		postAccountPurchase.AccountsPurchaseList();
	}

//	 Find Accounts By Name
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
