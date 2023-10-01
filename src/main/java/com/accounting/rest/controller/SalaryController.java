package com.accounting.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.PaySalaryModel;
import com.accounting.rest.entity.BookInfo;
import com.accounting.rest.entity.Books;
import com.accounting.rest.entity.FolioNumber;
import com.accounting.rest.entity.Ledger;
import com.accounting.rest.entity.LedgerDetails;
import com.accounting.rest.services.AccountsServices;
import com.accounting.rest.services.AccountsTypeServices;
import com.accounting.rest.services.BookTypeServices;
import com.accounting.rest.services.FolioNumberServices;

//
@RestController
@Transactional
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/salary")
@Scope("prototype")
public class SalaryController {

	private final FolioNumberServices folioNumberServices;
	private final AccountsTypeServices accountsTypeServices;
	private final AccountsServices accountsServices;
	private final BookTypeServices bookTypeServices;

	@Autowired
	public SalaryController(FolioNumberServices folioNumberServices, AccountsTypeServices accountsTypeServices,
			AccountsServices accountsServices, BookTypeServices bookTypeServices) {
		super();
		this.folioNumberServices = folioNumberServices;
		this.accountsTypeServices = accountsTypeServices;
		this.accountsServices = accountsServices;
		this.bookTypeServices = bookTypeServices;

	}

	@PostMapping("/add")
	public ResponseEntity<?> addBooks(@RequestBody PaySalaryModel paySalary) {

		/**
		 * 1. Credit Book Initialization
		 */

		List<Books> listBooks = new ArrayList<Books>();
		Books credit_Account_1 = new Books();

		// Here "Amc Account" Is The Default Credit Transactional Accounts
		credit_Account_1.setBooksAccount_Ref(accountsServices
				.getAccountIdByAccountName(paySalary.getTransectionalAccounts().getTransactionAccountName()));

		// Here "Direct Income" Is The Category Of "Amc Account"
		credit_Account_1
				.setBooksAccountType_Ref(accountsTypeServices.getAccTypeId_ByName("Current Assets").getAccountTypeId());
		credit_Account_1.setBooksDate(paySalary.getTransectionDate());
		credit_Account_1.setBooksCreditAmount(paySalary.getTransectionalAccounts().getTransactionAmount());
		credit_Account_1.setBooksDebitAmount(0d);

		listBooks.add(credit_Account_1);
		/**
		 * 1. Debit Book Initialization
		 */
		Books debit_account_1 = new Books();

		debit_account_1.setBooksAccount_Ref(paySalary.getAccountId());
		// Here "Current Assets" Is The Category Of "Sundry Debtors" Accounts Used When
		// Goods Are Sold On Debit
		debit_account_1.setBooksAccountType_Ref(
				accountsTypeServices.getAccTypeId_ByName("Indirect Expenses").getAccountTypeId());

		debit_account_1.setBooksDate(paySalary.getTransectionDate());
		debit_account_1.setBooksCreditAmount(0d);
		debit_account_1.setBooksDebitAmount(paySalary.getTransectionalAccounts().getTransactionAmount());

		listBooks.add(debit_account_1);

		/**
		 * creadit and debit book separation for ladger
		 */
		List<Books> creditBooks = new ArrayList<Books>();

		Books debitBook = new Books();

		for (Books filterBook : listBooks) {
			if (filterBook.getBooksCreditAmount() != 0) {
				// _Refentifying The All Credit Ledger
				creditBooks.add(filterBook);
			} else {
				// _Refentifying The All Debit Ledger
				debitBook.setBooksAccount_Ref(filterBook.getBooksAccount_Ref());
				debitBook.setBooksAccountType_Ref(filterBook.getBooksAccountType_Ref());
				debitBook.setBooksDate(filterBook.getBooksDate());
				debitBook.setBooksDebitAmount(filterBook.getBooksDebitAmount());
				debitBook.setBooksCreditAmount(filterBook.getBooksCreditAmount());

			}

		}
		/**
		 * Initialize BookInfo
		 */
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookInfoType_Ref(bookTypeServices.getBookTypeId("Cash Book").getBookTypeId());
		bookInfo.setBookInfoUser_Ref(paySalary.getUserId());
		bookInfo.setBookInfoAccount_Ref(paySalary.getAccountId());
		bookInfo.setBookInfoNarration("Salary");
		bookInfo.setBookInfoDate(paySalary.getTransectionDate());
		bookInfo.setBooks(listBooks);

		// BookInfo Ready
		/**
		 * Initializing Credit Ledgers for posting
		 */

		List<Ledger> list_Of_Ledger = new ArrayList<Ledger>();

		for (Books tempBook : creditBooks) {

			List<LedgerDetails> list_Of_Credit_Ledger_Details = new ArrayList<LedgerDetails>();

			// All Credit Account Post On Ledger
			Ledger credit_Ledger = new Ledger();

			LedgerDetails credit_Ledger_Details = new LedgerDetails();

			credit_Ledger.setLedgerAccount_Ref(tempBook.getBooksAccount_Ref());
			credit_Ledger.setLedgerAccountType_Ref(tempBook.getBooksAccountType_Ref());
			credit_Ledger.setLedgerDate(paySalary.getTransectionDate());
			credit_Ledger.setLedgerUser_Ref(paySalary.getUserId());

			credit_Ledger_Details.setLedgerDetailsDate(tempBook.getBooksDate());
			credit_Ledger_Details.setLedgerDetailsAccount_Ref(debitBook.getBooksAccount_Ref());// from debit account
			credit_Ledger_Details.setLedgerDetailsAccountType_Ref(debitBook.getBooksAccountType_Ref());// from debit
			// account
			credit_Ledger_Details.setLedgerDetailsDebitAmount(0d);
			credit_Ledger_Details.setLedgerDetailsCreditAmount(tempBook.getBooksCreditAmount());

			list_Of_Credit_Ledger_Details.add(credit_Ledger_Details);

			credit_Ledger.setLedgerDetails(list_Of_Credit_Ledger_Details);

			list_Of_Ledger.add(credit_Ledger);

		}

		/**
		 * Initializing Debit Ledgers for posting
		 */

		List<LedgerDetails> list_Of_Debit_Ledger_Details = new ArrayList<LedgerDetails>();

		{
			// All Debit Account Post On Ledger
			Ledger debit_Ledger = new Ledger();

			debit_Ledger.setLedgerAccount_Ref(debitBook.getBooksAccount_Ref());
			debit_Ledger.setLedgerAccountType_Ref(debitBook.getBooksAccountType_Ref());
			debit_Ledger.setLedgerDate(paySalary.getTransectionDate());
			debit_Ledger.setLedgerUser_Ref(paySalary.getUserId());

			for (Books tempBook : creditBooks) {

				LedgerDetails credit_Ledger_Details = new LedgerDetails();

				credit_Ledger_Details.setLedgerDetailsDate(tempBook.getBooksDate());// from credit account
				credit_Ledger_Details.setLedgerDetailsAccount_Ref(tempBook.getBooksAccount_Ref());// from debit account
				credit_Ledger_Details.setLedgerDetailsAccountType_Ref(tempBook.getBooksAccountType_Ref());// from debit
				// account
				credit_Ledger_Details.setLedgerDetailsDebitAmount(tempBook.getBooksCreditAmount());
				credit_Ledger_Details.setLedgerDetailsCreditAmount(0d);

				list_Of_Debit_Ledger_Details.add(credit_Ledger_Details);

			}
			debit_Ledger.setLedgerDetails(list_Of_Debit_Ledger_Details);
			list_Of_Ledger.add(debit_Ledger);
		}

		List<BookInfo> newBookInfo = new ArrayList<BookInfo>();
		newBookInfo.add(bookInfo);
		FolioNumber folioNo = new FolioNumber();
		folioNo.setFolioNarration(paySalary.getNarration());
		folioNo.setBookInfos(newBookInfo);// Add BookInfo
		folioNo.setLedger(list_Of_Ledger);// Add Leaser
		folioNumberServices.addFolio(folioNo);// adding folio
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
