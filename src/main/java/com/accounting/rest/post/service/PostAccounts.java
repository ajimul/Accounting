package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.Accounts;
import com.accounting.rest.repository.AccountsRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostAccounts {
	@Autowired
	private AccountsRepo accountsRepo;

	public void AccountsList() {
		ArrayList<String> preeAccounts = new ArrayList<String>();
		preeAccounts.add("Purchase Account");
		preeAccounts.add("Purchase Return Account");
		preeAccounts.add("Sales Account");
		preeAccounts.add("Sales Return Account");
		preeAccounts.add("Amc Account");
		preeAccounts.add("Sundry Debtors");
		preeAccounts.add("Sundry Creditors");
		preeAccounts.add("Cash Account");
		preeAccounts.add("Bank Account");
		preeAccounts.add("INPUT CGST");
		preeAccounts.add("INPUT SGST");
		preeAccounts.add("INPUT IGST");
		preeAccounts.add("OUTPUT CGST");
		preeAccounts.add("OUTPUT SGST");
		preeAccounts.add("OUTPUT IGST");
		preeAccounts.add("Salary Account");
		preeAccounts.add("Machinery Account");
		preeAccounts.add("Furniture Account");
		preeAccounts.add("Insurance Account");
		preeAccounts.add("Electricity Bill Account");
		preeAccounts.add("Telecom Services Account");
		preeAccounts.add("Rent Account");
		preeAccounts.add("Audit Fees Account");
		preeAccounts.add("Interest on Bank Loan Account");
		preeAccounts.add("Bank loan Account");
		preeAccounts.add("Bank Charges Account");
		preeAccounts.add("Legal Charges Account");
		preeAccounts.add("Printing and Stationery Account");
		preeAccounts.add("Discount Allowed Account");
		preeAccounts.add("Carriage Outwards Account");
		preeAccounts.add("Advertisement Account");
		preeAccounts.add("Bad Debts Account");
		preeAccounts.add("Repair Account");
		preeAccounts.add("Depreciation on Assets Account");
		preeAccounts.add("Commission Received Account");
		preeAccounts.add("Discount Received Account");
		preeAccounts.add("Capital Account");
		preeAccounts.add("Drawings Capital Account");
		preeAccounts.add("Factory Account");
		List<Accounts> acList = new ArrayList<Accounts>();

		for (String accountName : preeAccounts) {
			Optional<Accounts> existingAccount = Optional.ofNullable(new Accounts());

			existingAccount = accountsRepo.findByAccountName(accountName);

			if (existingAccount.isPresent()) {
			} else {
				Accounts newAccount = new Accounts();
				newAccount.setAccountName(accountName);
				acList.add(newAccount);
			}
		}

		if (acList.size() != 0) {
			accountsRepo.saveAll(acList);
		}

	}
}
