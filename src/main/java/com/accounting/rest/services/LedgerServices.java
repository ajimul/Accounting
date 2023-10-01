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

import com.accounting.rest.dto.GenericsLedger;
import com.accounting.rest.dto.GenericsLedgersDetails;
import com.accounting.rest.dto.PartyDetailsDTO;
import com.accounting.rest.entity.AccountType;
import com.accounting.rest.entity.Accounts;
import com.accounting.rest.entity.Ledger;
import com.accounting.rest.entity.Users;
import com.accounting.rest.repository.AccountTypeRepo;
import com.accounting.rest.repository.AccountsRepo;
import com.accounting.rest.repository.LedgerRepo;
import com.accounting.rest.repository.UsersRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class LedgerServices {

	private final LedgerRepo ledgerRepo;
	private final AccountsRepo accountsRepo;
	private final AccountTypeRepo accountTypeRepo;
	private final UsersRepo userRepo;

	@Autowired
	public LedgerServices(LedgerRepo ledgerRepo, AccountsRepo accountsRepo, AccountTypeRepo accountTypeRepo,
			UsersRepo userRepo) {
		super();
		this.ledgerRepo = ledgerRepo;
		this.accountsRepo = accountsRepo;
		this.accountTypeRepo = accountTypeRepo;
		this.userRepo = userRepo;
	}

//Add Ledger

	public Ledger addLedger(Ledger ledger) {
		return ledgerRepo.save(ledger);

	}

	public List<Ledger> addLedger(List<Ledger> ledger) {
		return ledgerRepo.saveAll(ledger);

	}

//Find All Ledger 
	public List<Ledger> findAllLedger() {
		return ledgerRepo.findAll();

	}

	public List<Ledger> findLedgerByFolioId(Long folioId) {
		return ledgerRepo.getLadgerByFolio_Ref(folioId);

	}

	public GenericsLedger GetLadgerByAccountId(Long Id) {
		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsById(Id);
		return GetLadger(accounts.getAccountName());

	}

	public GenericsLedger GetLadgerByAccountName(String accountName) {
		return GetLadger(accountName);
	}

	public JasperPrint PrintLadgerByName(String accountName) {
		JasperPrint print = new JasperPrint();
		try {
			print = downloadInvoice(GetLadger(accountName));
		} catch (JRException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return print;
	}

	public JasperPrint PrintLadgerById(Long Id) {
		JasperPrint print = new JasperPrint();
		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsById(Id);

		try {
			print = downloadInvoice(GetLadger(accounts.getAccountName()));
		} catch (JRException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return print;
	}

	public List<GenericsLedger> GetAllLadger() {

		List<Accounts> listAccounts = new ArrayList<Accounts>(accountsRepo.findAll());
		List<GenericsLedger> ledgers = new ArrayList<GenericsLedger>();
		for (int i = 0; i < listAccounts.size(); i++) {

			ledgers.add(GetLadger(listAccounts.get(i).getAccountName()));

		}
		return ledgers;
	}

	public GenericsLedger GetLadger(String accountName) {

		GenericsLedger genericsLeders = new GenericsLedger();

		List<GenericsLedgersDetails> listLedgerDetails = new ArrayList<GenericsLedgersDetails>();

		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsByName(accountName);

		AccountType accountType = new AccountType();
		Users user = new Users();

		List<Ledger> listLeders = new ArrayList<Ledger>(ledgerRepo.getLadgerByAccount_Ref(accounts.getAccountId()));
		for (int i = 0; i < listLeders.size(); i++) {
			if (i == 0) {
				accounts = accountsRepo.getPartyDetailsById(listLeders.get(i).getLedgerAccount_Ref());

				accountType = accountTypeRepo.getAccTypeId_ById(listLeders.get(i).getLedgerAccountType_Ref());

				user = userRepo.GetUserNameById(listLeders.get(i).getLedgerUser_Ref());

				genericsLeders.setLedgerId(listLeders.get(i).getLedgerId());
				genericsLeders.setDate(listLeders.get(i).getLedgerDate());
				genericsLeders.setLedgerAccountType(accountType.getAccountTypeName());
				genericsLeders.setLedgerAccountName(accounts.getAccountName());
				genericsLeders.setLedgerFolioNumber(listLeders.get(i).getLedgerFolio_Ref());
				genericsLeders.setLedgerUserName(user.getUserName());
			}
			for (int j = 0; j < listLeders.get(i).getLedgerDetails().size(); j++) {

				GenericsLedgersDetails ld = new GenericsLedgersDetails();

				accounts = accountsRepo.getPartyDetailsById(
						listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsAccountc_Ref());

				accountType = accountTypeRepo.getAccTypeId_ById(
						listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsAccountType_Ref());

				ld.setLedgerAccountName(accounts.getAccountName());
				ld.setLedgerAccountType(accountType.getAccountTypeName());
				ld.setLedgerDetailsDate(listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsDate());
				ld.setLedgerDetailsId(listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsId());
				ld.setLedgerDetailsDebitAmount(
						listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsDebitAmount());
				ld.setLedgerDetailsCreditAmount(
						listLeders.get(i).getLedgerDetails().get(j).getLedgerDetailsCreditAmount());
				listLedgerDetails.add(ld);

			}

		}
		genericsLeders.setLedgersDetails(listLedgerDetails);

		return genericsLeders;

	}

	public JasperPrint downloadInvoice(GenericsLedger getLedgers) throws JRException, IOException, ParseException {
		List<GenericsLedgersDetails> ledgerDetails = new ArrayList<GenericsLedgersDetails>();
		{

			for (int j = 0; j < getLedgers.getLedgersDetails().size(); j++) {
				ledgerDetails.add(getLedgers.getLedgersDetails().get(j));
			}
		}

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ledgerDetails, false);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("ledgerAccountName", getLedgers.getLedgerAccountName());
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/Ledger.jrxml"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

		return jasperPrint;
	}

////Find Ledger By Id
//	public Ledger findLedgerById(Long id) {
//		return ledgerRepo.findById(id).orElseThrow(() -> new LedgerNotFoundException(""));
//
//	}
//
////Update Ledger
//
//Delete Ledger By Id
	public void deleteLedgerByLedgerId(Long id) {

		ledgerRepo.deleteById(id);

	}

}
