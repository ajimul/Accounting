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

import com.accounting.rest.dto.PurchaseModel;
import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.entity.BookInfo;
import com.accounting.rest.entity.Books;
import com.accounting.rest.entity.FolioNumber;
import com.accounting.rest.entity.InventoryItems;
import com.accounting.rest.entity.Ledger;
import com.accounting.rest.entity.LedgerDetails;
import com.accounting.rest.services.AccountsServices;
import com.accounting.rest.services.AccountsTypeServices;
import com.accounting.rest.services.BookTypeServices;
import com.accounting.rest.services.FolioNumberServices;
import com.accounting.rest.services.InventoryItemsService;

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
@Transactional
@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/sales/return")
@Scope("prototype")
public class SalesReturnController {
	private final FolioNumberServices folioNumberServices;
	private final AccountsTypeServices accountsTypeServices;
	private final AccountsServices accountsServices;
	private final BookTypeServices bookTypeServices;
	private final InventoryItemsService inventoryItemsService;

	@Autowired
	public SalesReturnController(FolioNumberServices folioNumberServices, AccountsTypeServices accountsTypeServices,
			AccountsServices accountsServices, BookTypeServices bookTypeServices,
			InventoryItemsService inventoryItemsService) {
		super();
		this.folioNumberServices = folioNumberServices;
		this.accountsTypeServices = accountsTypeServices;
		this.accountsServices = accountsServices;
		this.bookTypeServices = bookTypeServices;
		this.inventoryItemsService = inventoryItemsService;
	}

	Double ocgst = 0d;
	Double osgst = 0d;
	Double igst = 0d;
	Double totalDebitAmount = 0d;

	@PostMapping("/add")
	public ResponseEntity<String> addBooks(@RequestBody PurchaseModel books) {

		/**
		 * GST Separation
		 */

		for (BookDetails bookDetails : books.getBookDetails()) {
			// The Line Of Code Used For The Sum Of The ocgst Amount For All Purchase Goods
			ocgst += bookDetails.getBookDetailsCgstAmount();

			// The Line Of Code Used For The Sum Of The osgst Amount For All Purchase Goods
			osgst += bookDetails.getBookDetailsSgstAmount();

			// The Line Of Code Used For The Sum Of The igst Amount For All Purchase Goods
			igst += bookDetails.getBookDetailsIgstAmount();

			// The Line Of Code Used For The Sum Of The Cost Amount For All Purchase Goods
			totalDebitAmount += bookDetails.getBookDetailsParticularAmount();

		}

		/**
		 * 1. Debit Book Initialization
		 */

		List<Books> listBooks = new ArrayList<Books>();

		Books Debit_Account_1 = new Books();
		// Here "Sales Return Account" Is The Default Debited Transactional Accounts
		Debit_Account_1.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("Sales Return Account"));

		// Here "Direct Expenses" Is The Category Of "Purchase Account"
		Debit_Account_1
				.setBooksAccountType_Ref(accountsTypeServices.getAccTypeId_ByName("Direct Income").getAccountTypeId());

		Debit_Account_1.setBooksDate(books.getTransectionDate());
		Debit_Account_1.setBooksCreditAmount(0d);
		Debit_Account_1.setBooksDebitAmount(totalDebitAmount);

		listBooks.add(Debit_Account_1);

		if (ocgst != 0) {
			Books Debit_Account_2 = new Books();
			// Here "OUTPUT CGST" Will Be The 2nd Debited Transaction Account If Its Applied
			Debit_Account_2.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT CGST"));

			// Here "Current Liability" Is The Category Of "Input cgst" Account
			Debit_Account_2.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
			Debit_Account_2.setBooksDate(books.getTransectionDate());
			Debit_Account_2.setBooksCreditAmount(0d);
			Debit_Account_2.setBooksDebitAmount(ocgst);

			listBooks.add(Debit_Account_2);

		}
		if (osgst != 0) {
			Books Debit_Account_3 = new Books();

			// Here "OUTPUT SGST" Will Be The 2nd Debited Transaction Account If Its Applied
			Debit_Account_3.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT SGST"));

			// Here "Current Liability" Is The Category Of "INPUT SGST" Account
			Debit_Account_3.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
//			booksOfDebit.setBookInfo_Ref(bookInfo.getBookInfo_Ref());
			Debit_Account_3.setBooksDate(books.getTransectionDate());
			Debit_Account_3.setBooksCreditAmount(0d);
			Debit_Account_3.setBooksDebitAmount(osgst);

			listBooks.add(Debit_Account_3);
		}
		if (igst != 0) {
			Books Debit_Account_4 = new Books();

			// Here "OUTPUT IGST" Will Be The 2nd Debited Transaction Account If Its Applied
			Debit_Account_4.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName("OUTPUT IGST"));

			// Here "Current Liability" Is The Category Of "INPUT IGST" Account
			Debit_Account_4.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());
			Debit_Account_4.setBooksDate(books.getTransectionDate());
			Debit_Account_4.setBooksCreditAmount(0d);
			Debit_Account_4.setBooksDebitAmount(igst);

			listBooks.add(Debit_Account_4);
		}

		/**
		 * 1. Credit Book Initialization
		 */

		Books Credit_Account_1 = new Books();

		// Here "Sundry Creditors" Is The Credit Transaction Accounts Used When Goods
		// Are Purchase On Credit
		if (books.getTransectionalAccounts().getTransactionAccountName().equals("Sundry Creditors")) {
			Credit_Account_1.setBooksAccount_Ref(accountsServices.getAccountIdByAccountName(books.getPartyAcName()));

			// Here "Current Liability" Is The Category Of "Sundry Creditors" Accounts Used
			// When Goods Are Purchase On Credit
			Credit_Account_1.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Liability").getAccountTypeId());

		} else {
			// If The Transaction Is Not "Sundry Creditors" Then User Given Account Will Be
			// Treated As Credit Account When Goods Purchase By (Cash A/C Or Bank A/C)
			Credit_Account_1.setBooksAccount_Ref(accountsServices
					.getAccountIdByAccountName(books.getTransectionalAccounts().getTransactionAccountName()));

			// Here "Current Assets" Is The Category Of Cash/Bank Related Transaction Used
			// When Goods Are Purchase By Cash/Bank
			Credit_Account_1.setBooksAccountType_Ref(
					accountsTypeServices.getAccTypeId_ByName("Current Assets").getAccountTypeId());

		}
		Credit_Account_1.setBooksDate(books.getTransectionDate());
		Credit_Account_1.setBooksCreditAmount(books.getTransectionalAccounts().getTransactionAmount());
		Credit_Account_1.setBooksDebitAmount(0d);
		listBooks.add(Credit_Account_1);

		// Books Ready

		/**
		 * creadit and debit book separation for ladger
		 */

		List<Books> debitBooks = new ArrayList<Books>();

		Books creditBook = new Books();

		for (Books filterBook : listBooks) {

			if (filterBook.getBooksDebitAmount() != 0) {
				// _Refentifying The All Debit Ledger
				debitBooks.add(filterBook);

			} else {
				// _Refentifying The All Credit Ledger
				creditBook.setBooksAccount_Ref(filterBook.getBooksAccount_Ref());
				creditBook.setBooksAccountType_Ref(filterBook.getBooksAccountType_Ref());
				creditBook.setBooksDate(filterBook.getBooksDate());
				creditBook.setBooksDebitAmount(filterBook.getBooksDebitAmount());
				creditBook.setBooksCreditAmount(filterBook.getBooksCreditAmount());

			}

		}

		/**
		 * Update InventoryItems 1. Get InventoryItems 1. Update OutwardQty Of
		 * InventoryItems
		 */
		List<InventoryItems> items = new ArrayList<InventoryItems>();
		for (int i = 0; i < books.getInventoryJournal().size(); i++) {
			InventoryItems item = new InventoryItems();
			item = inventoryItemsService.getInventoryItemByiiId(books.getInventoryJournal().get(i).getIj_iiId());
			item.setIiQty(item.getIiQty() + books.getInventoryJournal().get(i).getIjInwardQty());
			items.add(item);
		}
//InventoryItems Ready

		/**
		 * Initialize BookInfo
		 */

		BookInfo bookInfo = new BookInfo();
		// The Line Of Code Used For _Refentifying The Book Type
		if (books.getTransectionalAccounts().getTransactionAccountName().equals("Sundry Creditors")) {
			bookInfo.setBookInfoType_Ref(bookTypeServices.getBookTypeId("Sales Return Book").getBookTypeId());
		} else {
			// The Line Of Code Used For _Refentifying The Book Type
			bookInfo.setBookInfoType_Ref(bookTypeServices.getBookTypeId("Cash Book").getBookTypeId());
		}
		bookInfo.setBookInfoUser_Ref(books.getUserId());
		bookInfo.setBookInfoAccount_Ref(books.getAccountId());
		bookInfo.setBookInfoNarration("Sales Return");

		bookInfo.setBookInfoDate(books.getInvoiceDate());
		bookInfo.setBooks(listBooks);
		bookInfo.setBookDetails(books.getBookDetails());
		bookInfo.setInventoryJournals(books.getInventoryJournal());

		/**
		 * Initializing Debit Ledgers for posting
		 */

		/**
		 * Initializing Debit Ledgers for posting
		 */

		List<Ledger> list_Of_Ledger = new ArrayList<Ledger>();
		// All Debit Account Post On Ledger
		for (Books tempBook : debitBooks) {

			List<LedgerDetails> list_Of_Debit_Ledger_Details = new ArrayList<LedgerDetails>();

			Ledger debit_Ledger = new Ledger();

			LedgerDetails debit_Ledger_Details = new LedgerDetails();

			debit_Ledger.setLedgerAccount_Ref(tempBook.getBooksAccount_Ref());
			debit_Ledger.setLedgerAccountType_Ref(tempBook.getBooksAccountType_Ref());
			debit_Ledger.setLedgerDate(books.getTransectionDate());
			debit_Ledger.setLedgerUser_Ref(books.getUserId());

			debit_Ledger_Details.setLedgerDetailsDate(tempBook.getBooksDate());// from debit account
			debit_Ledger_Details.setLedgerDetailsAccount_Ref(creditBook.getBooksAccount_Ref());// from credit account
			debit_Ledger_Details.setLedgerDetailsAccountType_Ref(creditBook.getBooksAccountType_Ref());// from credit
																										// account
			debit_Ledger_Details.setLedgerDetailsDebitAmount(tempBook.getBooksDebitAmount());
			debit_Ledger_Details.setLedgerDetailsCreditAmount(0d);

			list_Of_Debit_Ledger_Details.add(debit_Ledger_Details);

			debit_Ledger.setLedgerDetails(list_Of_Debit_Ledger_Details);

			list_Of_Ledger.add(debit_Ledger);

		}

		/**
		 * Initializing Credit Ledgers for posting
		 */
//		6. Add Credit  Ledger With Ledgersdetails (Ledger Posting)
		List<LedgerDetails> list_Of_Credit_Ledger_Details = new ArrayList<LedgerDetails>();

		{
			// All Credit Account Post On Ledger
			Ledger credit_Ledger = new Ledger();

			credit_Ledger.setLedgerAccount_Ref(creditBook.getBooksAccount_Ref());
			credit_Ledger.setLedgerAccountType_Ref(creditBook.getBooksAccountType_Ref());
			credit_Ledger.setLedgerDate(books.getTransectionDate());
			credit_Ledger.setLedgerUser_Ref(books.getUserId());

			for (Books tempBook : debitBooks) {

				LedgerDetails credit_Ledger_Details = new LedgerDetails();

				credit_Ledger_Details.setLedgerDetailsDate(tempBook.getBooksDate());// from debit account
				credit_Ledger_Details.setLedgerDetailsAccount_Ref(tempBook.getBooksAccount_Ref());// from credit account
				credit_Ledger_Details.setLedgerDetailsAccountType_Ref(tempBook.getBooksAccountType_Ref());// from credit
																											// account
				credit_Ledger_Details.setLedgerDetailsDebitAmount(0d);
				credit_Ledger_Details.setLedgerDetailsCreditAmount(tempBook.getBooksDebitAmount());

				list_Of_Credit_Ledger_Details.add(credit_Ledger_Details);

			}
			credit_Ledger.setLedgerDetails(list_Of_Credit_Ledger_Details);
			list_Of_Ledger.add(credit_Ledger);
		}

		// Ledger Ready
//***********what about product service and emi activitywhen a product return????
		List<BookInfo> newBookInfo = new ArrayList<BookInfo>();
		newBookInfo.add(bookInfo);
		FolioNumber folioNo = new FolioNumber();
		folioNo.setFolioNarration(books.getNaration());
		folioNo.setBookInfos(newBookInfo);// Add BookInfo
		folioNo.setLedger(list_Of_Ledger);// Add Leaser
		inventoryItemsService.addInventoryItemsList(items);// update inventory items qty
		folioNumberServices.addFolio(folioNo);// adding folio
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	public FolioNumber addFolio(FolioNumber folioNumber) {
		return folioNumberServices.addFolioNumber(folioNumber);
	}

}
