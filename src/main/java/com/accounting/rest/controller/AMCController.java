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

import com.accounting.rest.dto.AmcModel;
import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.entity.BookInfo;
import com.accounting.rest.entity.Books;
import com.accounting.rest.entity.FolioNumber;
import com.accounting.rest.entity.Ledger;
import com.accounting.rest.entity.LedgerDetails;
import com.accounting.rest.services.AccountsServices;
import com.accounting.rest.services.AccountsTypeServices;
import com.accounting.rest.services.BookTypeServices;
import com.accounting.rest.services.FolioNumberServices;

/**
 * Implementation For... 1. Folio No. 2. BooksInfo 3. Books 4. BooksDetails 5.
 * Ledgers 6. LedgersDetails 7.!product 8.!product service 9.!product service so
 * 10.!emi
 * 
 * Relationship Of Schema: Folio Is The Parent Of BookInfo And Relationship
 * Is(1:1) BookInfo Is The Parent Of Books And Relationship Is (1:N) Again
 * 
 * BookInfo Is The Parent Of BooksDetails And Relationship Is (1:N) Again
 * BooksDetails Is The Parent Of TradingItemsSerialNo And Relationship Is (1:N)
 * Again
 * 
 * BookInfo Is The Parent Of Emi And Relationship Is (1:N) Again
 * 
 * Folio Is The Parent Of Ledger And Relationship Is (1:1) Ledger Is The Parent
 * Of LedgerDetails And Relationship Is (1:N)
 * 
 * Folio Is The Parent Of Product And Relationship Is (1:1) Product is the
 * Parent of ProductService And Relationship Is (1:N) ProductService is the
 * Parent of ProductServiceSerialNo And Relationship Is (1:N)
 * 
 * Description For Implementation: Prerequisite:( Needs Proper Knowledge Of
 * Accountancy)
 * 
 * Folio Is The common Number Help To Find Out The Transaction Of Books And
 * Ledgers
 * 
 * Books Are The Record For All The Debit And Credit Accounts And Ledger Are The
 * Record For Each Single Accounts Whether Accounts Are Debit Or Credit
 * 
 * According To Books Each Accounts Should Be Post On The Ledger And Each
 * Ledgers Accounts May Have Different Roll For Each To Others Accounts A Single
 * Credit Account May Have Effect On Multiple Debit Accounts Depend On
 * Transaction Or Vice Versa To Others Accounts.
 * 
 * Every Transaction Must Be 1. Debit Account To Credit Account (Recommended) 2.
 * List<Debit> Account To Credit Account (Recommended) 3. List<Debit> Accounts
 * To List<Credit> Accounts
 * 
 * In This Package I Will Implement The Second One( 2. List<Debit> Accounts To
 * Credit Account (Recommended) ) Every Transaction Should Be Two Part 1. Books
 * (Books Of Original Entry) 2. After Books Entry Is Complete Then Its Should Be
 * Post On Ledgers
 * 
 * 
 * @author admin
 *
 */

@RestController
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/amc/service")
@Scope("prototype")
public class AMCController {

	private final FolioNumberServices folioNumberServices;
	private final AccountsTypeServices accountsTypeServices;
	private final AccountsServices accountsServices;
	private final BookTypeServices bookTypeServices;

	@Autowired
	public AMCController(FolioNumberServices folioNumberServices, AccountsTypeServices accountsTypeServices,
			AccountsServices accountsServices, BookTypeServices bookTypeServices) {
		super();
		this.folioNumberServices = folioNumberServices;
		this.accountsTypeServices = accountsTypeServices;
		this.accountsServices = accountsServices;
		this.bookTypeServices = bookTypeServices;
	}

	Double ocgst = 0d;
	Double osgst = 0d;
	Double igst = 0d;
	Double totalCreditAmount = 0d;

	@PostMapping("/add")
	public ResponseEntity<String> addBooks(@RequestBody AmcModel books) {

		/**
		 * GST Separation
		 */

		for (BookDetails bookDetails : books.getBookDetails()) {
			// The Line Of Code Used For The Sum Of The ocgst Amount For All sold Goods
			ocgst += bookDetails.getBookDetailsCgstAmount();

			// The Line Of Code Used For The Sum Of The osgst Amount For All sold Goods
			osgst += bookDetails.getBookDetailsSgstAmount();

			// The Line Of Code Used For The Sum Of The igst Amount For All sold Goods
			igst += bookDetails.getBookDetailsIgstAmount();

			// The Line Of Code Used For The Sum Of The Cost Amount For All sold Goods
			totalCreditAmount += bookDetails.getBookDetailsParticularAmount();

		}

		/**
		 * 1. Credit Book Initialization
		 */

		List<Books> listBooks = new ArrayList<Books>();

		Books credit_Account_1 = new Books();

		// Here "Amc Account" Is The Default Credit Transactional Accounts
		credit_Account_1.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("Amc Account"));

		// Here "Direct Income" Is The Category Of "Amc Account"
		credit_Account_1
				.setBooksAccountType_Ref(accountsTypeServices.getAccTypeId_ByName("Direct Income").getAccountTypeId());
		credit_Account_1.setBooksDate(books.getTransectionDate());
		credit_Account_1.setBooksCreditAmount(totalCreditAmount);
		credit_Account_1.setBooksDebitAmount(0d);

		listBooks.add(credit_Account_1);

		if (ocgst != 0) {
			Books credit_Account_2 = new Books();
			// Here "OUTPUT CGST" Will Be The 2nd Credit Transaction Account If Its Applied
			credit_Account_2.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT CGST"));
			credit_Account_2.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
			credit_Account_2.setBooksDate(books.getTransectionDate());
			credit_Account_2.setBooksCreditAmount(ocgst);
			credit_Account_2.setBooksDebitAmount(0d);

			listBooks.add(credit_Account_2);

		}
		if (osgst != 0) {
			Books credit_Account_3 = new Books();

			// Here "OUTPUT SGST" Will Be The 3rd Credit Transaction Account If Its Applied
			credit_Account_3.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT SGST"));
			// Here "Direct Income" Is The Category Of "OUTPUT SGST" Account
			credit_Account_3.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
			credit_Account_3.setBooksDate(books.getTransectionDate());
			credit_Account_3.setBooksCreditAmount(osgst);
			credit_Account_3.setBooksDebitAmount(0d);

			listBooks.add(credit_Account_3);
		}
		if (igst != 0) {
			Books credit_Account_4 = new Books();

			// Here "OUTPUT CGST" Will Be The 3rd Credit Transaction Account If Its Applied
			credit_Account_4.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT IGST"));

			// Here "Direct Income" Is The Category Of "OUTPUT IGST" Account
			credit_Account_4.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
			credit_Account_4.setBooksDate(books.getTransectionDate());
			credit_Account_4.setBooksCreditAmount(igst);
			credit_Account_4.setBooksDebitAmount(0d);

			listBooks.add(credit_Account_4);
		}

		/**
		 * 2. Debit Book Initialization
		 */
		Books debit_account_1 = new Books();

		// Here "Sundry Debtors" Is The Debit Transaction Accounts Used When Goods Are
		// Sales On Debit
		if (books.getTransectionalAccounts().getTransactionAccountName().equals("Sundry Debtors")) {
			debit_account_1.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName(books.getPartyAcName()));
			// Here "Current Assets" Is The Category Of "Sundry Debtors" Accounts Used When
			// Goods Are Sold On Debit
			debit_account_1.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Assets").getAccountTypeId());

		} else {
			// If The Transaction Is Not "Sundry Debtors" Then User Given Account Will Be
			// Treated As Debit Account When Goods Are Sold By (Cash A/C Or Bank A/C)
			debit_account_1.setBooksAccount_Ref(accountsServices
					.getAccountIdByAccountName(books.getTransectionalAccounts().getTransactionAccountName()));
			// Here "Direct Income" Is The Category Of Cash/Bank Related Transaction Used
			// When Goods Are Sold By Cash/Bank
			debit_account_1.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Assets").getAccountTypeId());

		}

		debit_account_1.setBooksDate(books.getTransectionDate());
		debit_account_1.setBooksCreditAmount(0d);
		debit_account_1.setBooksDebitAmount(books.getTransectionalAccounts().getTransactionAmount());

		listBooks.add(debit_account_1);

		// Books Ready
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
		// The Line Of Code Used For _Refentifying The Book Type
		if (books.getTransectionalAccounts().getTransactionAccountName().equals("Sundry Debtors")) {
			bookInfo.setBookInfoType_Ref(bookTypeServices.getBookTypeId("Amc Service Book").getBookTypeId());
		} else {
			// The Line Of Code Used For _Refentifying The Book Type
			bookInfo.setBookInfoType_Ref(bookTypeServices.getBookTypeId("Cash Book").getBookTypeId());
		}
		bookInfo.setBookInfoUser_Ref(books.getUserId());
		bookInfo.setBookInfoAccount_Ref(books.getAccountId());
		bookInfo.setBookInfoNarration("AMC Services");
		bookInfo.setBookInfoDate(books.getTransectionDate());
		bookInfo.setBooks(listBooks);
//		bookInfo.setBookDetails(books.getBookDetails());
		if (books.getEmi().size() != 0) {
			bookInfo.setEmi(books.getEmi());
		}
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
			credit_Ledger.setLedgerDate(books.getTransectionDate());
			credit_Ledger.setLedgerUser_Ref(books.getUserId());

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

			Ledger debit_Ledger = new Ledger();

			debit_Ledger.setLedgerAccount_Ref(debitBook.getBooksAccount_Ref());
			debit_Ledger.setLedgerAccountType_Ref(debitBook.getBooksAccountType_Ref());
			debit_Ledger.setLedgerDate(books.getTransectionDate());
			debit_Ledger.setLedgerUser_Ref(books.getUserId());

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
		folioNo.setFolioNarration(books.getNaration());
		if (books.getProduct().size() != 0) {
			folioNo.setProduct(books.getProduct());// Add Product
		}
		folioNo.setBookInfos(newBookInfo);// Add BookInfo
		folioNo.setLedger(list_Of_Ledger);// Add Leaser
		folioNumberServices.addFolio(folioNo);// adding folio

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	public FolioNumber addFolio(FolioNumber folioNumber) {
		return folioNumberServices.addFolioNumber(folioNumber);
	}

}
