package com.accounting.rest.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.GenericsJournal;
import com.accounting.rest.dto.GenericsJournalDetails;
import com.accounting.rest.dto.PartyDetailsDTO;
import com.accounting.rest.entity.AccountType;
import com.accounting.rest.entity.BookInfo;
import com.accounting.rest.entity.BookType;
import com.accounting.rest.repository.AccountTypeRepo;
import com.accounting.rest.repository.AccountsRepo;
import com.accounting.rest.repository.BookInfoRepo;
import com.accounting.rest.repository.BookTypeRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JournalServices {

	private final BookInfoRepo bookInfoRepo;
	private final AccountsRepo accountsRepo;
	private final AccountTypeRepo accountTypeRepo;
	private final BookTypeRepo bookTypeRepo;

	@Autowired
	public JournalServices(BookInfoRepo bookInfoRepo, AccountsRepo accountsRepo, AccountTypeRepo accountTypeRepo,
			BookTypeRepo bookTypeRepo) {
		super();
		this.bookInfoRepo = bookInfoRepo;
		this.accountsRepo = accountsRepo;
		this.accountTypeRepo = accountTypeRepo;
		this.bookTypeRepo = bookTypeRepo;
	}

	public JasperPrint GetJournalByBookName(String bookName) {

		JasperPrint print = new JasperPrint();
		BookType bookType = new BookType();
		bookType = bookTypeRepo.getBookByName(bookName);

		try {

			print = Report(Journal(bookType.getBookTypeId()));
		} catch (JRException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return print;

	}

//	public List<BookInfo> getBookByFolio(Long folioNo) {
//		return bookInfoRepo.get(folioNo);
//
//	}

	public List<GenericsJournal> Journal(Long bookId) {
		PartyDetailsDTO accounts = new PartyDetailsDTO();

		AccountType accountType = new AccountType();
		List<GenericsJournal> list_journal = new ArrayList<GenericsJournal>();

		List<GenericsJournalDetails> list_journalDetails = new ArrayList<GenericsJournalDetails>();
		GenericsJournalDetails journalDetails = new GenericsJournalDetails();

		BookType bookType = new BookType();
		List<BookInfo> Lis_bookInfo = new ArrayList<BookInfo>();

//		BookInfo bookInfo = new BookInfo();

		Lis_bookInfo = bookInfoRepo.GetBookByBookTypeId(bookId);
		for (int k = 0; k < Lis_bookInfo.size(); k++) {
			GenericsJournal journal = new GenericsJournal();
			bookType = bookTypeRepo.getById(Lis_bookInfo.get(k).getBookInfoType_Ref());

			journal.setBookName(bookType.getBookTypeName());
			journal.setBookNarration(Lis_bookInfo.get(k).getBookInfoNarration());

			for (int i = 0; i < Lis_bookInfo.get(k).getBookDetails().size(); i++) {
				accounts = accountsRepo
						.getPartyDetailsById(Lis_bookInfo.get(k).getBooks().get(i).getBooksAccount_Ref());
				accountType = accountTypeRepo
						.getAccTypeId_ById(Lis_bookInfo.get(k).getBooks().get(i).getBooksAccountType_Ref());

				journalDetails.setDate(Lis_bookInfo.get(k).getBookInfoDate());
				journalDetails.setAccountName(accounts.getAccountName());
				journalDetails.setAccountTypeName(accountType.getAccountTypeName());
				journalDetails.setFolioNo(Lis_bookInfo.get(k).getBookInfoFolio_Ref());
				journalDetails.setDebitAmount(Lis_bookInfo.get(k).getBooks().get(i).getBooksDebitAmount());
				journalDetails.setCreditAmount(Lis_bookInfo.get(k).getBooks().get(i).getBooksCreditAmount());
				list_journalDetails.add(journalDetails);
			}

			journal.setJournalDetails(list_journalDetails);
			list_journal.add(journal);
		}
		return list_journal;

	}

	public JasperPrint Report(List<GenericsJournal> journal) throws JRException, IOException, ParseException {
		List<GenericsJournalDetails> journalDetails = new ArrayList<GenericsJournalDetails>();
		JasperPrint jasperPrint = new JasperPrint();
		for (int k = 0; k < journal.size(); k++) {

			for (int j = 0; j < journal.get(k).getJournalDetails().size(); j++) {
				journalDetails.add(journal.get(k).getJournalDetails().get(j));
			}
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(journalDetails, false);

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("bookOf", journal.get(k).getBookName());
			parameters.put("narration", journal.get(k).getBookNarration());
			JasperReport compileReport = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/Journal.jrxml"));

			jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
		}

		return jasperPrint;
	}

}
