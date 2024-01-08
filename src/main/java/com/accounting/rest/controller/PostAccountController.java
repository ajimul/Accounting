package com.accounting.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.multitenant.tenant.post.service.PostAccountAMC;
import com.accounting.rest.multitenant.tenant.post.service.PostAccountEMI;
import com.accounting.rest.multitenant.tenant.post.service.PostAccountPurchase;
import com.accounting.rest.multitenant.tenant.post.service.PostAccountSalary;
import com.accounting.rest.multitenant.tenant.post.service.PostAccountSales;
import com.accounting.rest.multitenant.tenant.post.service.PostAccounts;
import com.accounting.rest.multitenant.tenant.post.service.PostAccountsType;
import com.accounting.rest.multitenant.tenant.post.service.PostBookType;

@RestController
@RequestMapping("/api/pree/ac")
public class PostAccountController {
	@Autowired
	private PostAccountAMC postAccountAMC;
	@Autowired
	private PostAccountEMI postAccountEMI;
	@Autowired
	private PostAccountPurchase postAccountPurchase;
	@Autowired
	private PostAccounts postAccounts;
	@Autowired
	private PostAccountSalary postAccountSalary;
	@Autowired
	private PostAccountSales postAccountSales;
	@Autowired
	private PostAccountsType postAccountsType;
	@Autowired
	private PostBookType postBookType;

	@GetMapping
	public ResponseEntity<?> add_User() {
		postAccountAMC.AccountAMCList();
		postAccountEMI.AccountEMIList();
		postAccountPurchase.AccountsPurchaseList();
		postAccounts.AccountsList();
		postAccountSalary.AccountSalaryList();
		postAccountSales.AccountsSalesList();
		postAccountsType.AccountTypeAccountsList();
		postBookType.BookAccountsList();
		return new ResponseEntity<>("Operation successful. Please log out and log in again", HttpStatus.CREATED);

	}
}
