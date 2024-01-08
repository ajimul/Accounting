package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.EmiListDTO;
import com.accounting.rest.dto.EmiSmsConfig;
import com.accounting.rest.dto.EmployeeDetailsDTO;
import com.accounting.rest.dto.InvoiceDataDTO;
import com.accounting.rest.dto.InvoiceJRBeanDataSource;
import com.accounting.rest.dto.InvoicePrintObject;
import com.accounting.rest.dto.PartyDetailsDTO;
import com.accounting.rest.dto.PartyModel;
import com.accounting.rest.dto.ProductServiceSmsConfig;
import com.accounting.rest.dto.TransactionalAccountDTO;
import com.accounting.rest.entity.Accounts;
import com.accounting.rest.entity.EmployeeDetails;
import com.accounting.rest.entity.PartyDetails;
import com.accounting.rest.post.service.PostAccounts;
import com.accounting.rest.repository.AccountsRepo;
import com.accounting.rest.repository.EmployeeDetailsRepo;
import com.accounting.rest.repository.PartyDetailsRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager") // Use For Multitenant

public class AccountsServices {
	@Autowired
	private AccountsRepo accountsRepo;
	@Autowired
	private PartyDetailsRepo partyDetailsRepo;
	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepo;
	@Autowired
	public PostAccounts postAccounts;

	@PostConstruct
	public void AccountList() {
		postAccounts.AccountsList();
	}

	public String getAccountByName(String accountName) {
		String ac = null;
		Optional<Accounts> account = Optional.ofNullable(new Accounts());
		account = accountsRepo.findByAccountName(accountName);
		if (account.isPresent()) {
			ac = account.get().getAccountName();

		} else {
			ac = "Account Not Exist";
		}
		return ac;

	}

//Add Accounts

	public Accounts addAccounts(Accounts accounts) {
		return accountsRepo.save(accounts);

	}

//Add Employee
	public void addEmployee(EmployeeDetailsDTO emp) {
		Accounts ac = new Accounts();
		List<EmployeeDetails> empList = new ArrayList<EmployeeDetails>();
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setEmpContactNo1(emp.getEmpContactNo1());
		empDetails.setEmpContactNo2(emp.getEmpContactNo2());
		empDetails.setEmpEmailId(emp.getEmpEmailId());
		empDetails.setEmpGstNo(emp.getEmpGstNo());
		empDetails.setEmpBillingAddress(emp.getEmpBillingAddress());
		empDetails.setEmpShipingAddress(emp.getEmpShipingAddress());
		empDetails.setEmpOpeningBalance(emp.getEmpOpeningBalance());
		empDetails.setEmpAreaCode(emp.getEmpAreaCode());

		empDetails.setEmpDob(emp.getEmpDob());

		empDetails.setEmpBloodGroup(emp.getEmpBloodGroup());
		empDetails.setEmpJobeDesignation(emp.getEmpJobeDesignation());

		empDetails.setEmpJoiningDate(emp.getEmpJoiningDate());

		empDetails.setEmpSalaryPackage(emp.getEmpSalaryPackage());
		empDetails.setEmpAadharNo(emp.getEmpAadharNo());
		empDetails.setEmpPanNo(emp.getEmpPanNo());
		empList.add(empDetails);
		ac.setAccountId(emp.getAccountId());
		ac.setAccountName(emp.getAccountName());
		ac.setEmployeeDetails(empList);
		accountsRepo.save(ac);

	}

//Add Party
	public void addParty(PartyModel party) {
		Accounts ac = new Accounts();
		List<PartyDetails> partyList = new ArrayList<PartyDetails>();
		PartyDetails partyDetails = new PartyDetails();
		partyDetails.setPartyContactNo1(party.getPartyContactNo1());
		partyDetails.setPartyContactNo2(party.getPartyContactNo2());
		partyDetails.setPartyEmailId(party.getPartyEmailId());
		partyDetails.setPartyGstNo(party.getPartyGstNo());
		partyDetails.setPartyBillingAddress(party.getPartyBillingAddress());
		partyDetails.setPartyShipingAddress(party.getPartyShipingAddress());
		partyDetails.setPartyOpeningBalance(party.getPartyOpeningBalance());
		partyDetails.setPartyAreaCode(party.getPartyAreaCode());

		partyDetails.setPartyDob(party.getPartyDob());

		partyDetails.setPartyBloodGroup(party.getPartyBloodGroup());
		partyDetails.setPartyAadharNo(party.getPartyAadharNo());
		partyDetails.setPartyPanNo(party.getPartyPanNo());
		partyList.add(partyDetails);
		ac.setAccountId(party.getAccountId());
		ac.setAccountName(party.getAccountName());
		ac.setPartyDetails(partyList);
		accountsRepo.save(ac);

	}

	// Join Table Response(Accounts+PartyDetails+BookInfo+BookDetails+Emi)
	public List<EmiListDTO> getEmi() {
		List<EmiListDTO> getEmiData = new ArrayList<EmiListDTO>();
		getEmiData = accountsRepo.getEmiList();
		return getEmiData;

	}

	public TransactionalAccountDTO getTransactionalAccount(String accountName) {
		TransactionalAccountDTO tadto = new TransactionalAccountDTO();
		Optional<Accounts> existingAccount = accountsRepo.findByAccountName(accountName);
		tadto.setAccountId(existingAccount.get().getAccountId());
		tadto.setAccountName(existingAccount.get().getAccountName());
		return tadto;

	}

	public List<ProductServiceSmsConfig> getProductServiceSmsConfig() {
		return accountsRepo.getServiceSmsConfig();

	}

	public List<EmiSmsConfig> getSmsConfig() {
		return accountsRepo.getSmsConfig();

	}

	// Update Accounts By Id
	public void updateEmployee(EmployeeDetailsDTO getEmp) {
		EmployeeDetails employee = new EmployeeDetails();
		employee.setEmpDetailsId(getEmp.getEmpDetailsId());
		employee.setEmp_ac_refId(getEmp.getEmp_ac_refId());
		employee.setEmpDob(getEmp.getEmpDob());
		employee.setEmpBloodGroup(getEmp.getEmpBloodGroup());
		employee.setEmpAadharNo(getEmp.getEmpAadharNo());
		employee.setEmpPanNo(getEmp.getEmpPanNo());
		employee.setEmpContactNo1(getEmp.getEmpContactNo1());
		employee.setEmpContactNo2(getEmp.getEmpContactNo2());
		employee.setEmpEmailId(getEmp.getEmpEmailId());
		employee.setEmpGstNo(getEmp.getEmpGstNo());
		employee.setEmpBillingAddress(getEmp.getEmpBillingAddress());
		employee.setEmpShipingAddress(getEmp.getEmpShipingAddress());
		employee.setEmpOpeningBalance(getEmp.getEmpOpeningBalance());
		employee.setEmpAreaCode(getEmp.getEmpAreaCode());
		accountsRepo.UpdateAccount(getEmp.getAccountName(), getEmp.getAccountId());
		employeeDetailsRepo.save(employee);

	}

	// Update Party
	public void updateParty(PartyDetailsDTO newParty) {
		PartyDetails party = new PartyDetails();
		party.setPartyDetailsId(newParty.getPartyDetailsId());
		party.setParty_ac_refId(newParty.getParty_ac_refId());
		party.setPartyDob(newParty.getPartyDob());
		party.setPartyBloodGroup(newParty.getPartyBloodGroup());
		party.setPartyAadharNo(newParty.getPartyAadharNo());
		party.setPartyPanNo(newParty.getPartyPanNo());
		party.setPartyContactNo1(newParty.getPartyContactNo1());
		party.setPartyContactNo2(newParty.getPartyContactNo2());
		party.setPartyEmailId(newParty.getPartyEmailId());
		party.setPartyGstNo(newParty.getPartyGstNo());
		party.setPartyBillingAddress(newParty.getPartyBillingAddress());
		party.setPartyShipingAddress(newParty.getPartyShipingAddress());
		party.setPartyOpeningBalance(newParty.getPartyOpeningBalance());
		party.setPartyAreaCode(newParty.getPartyAreaCode());
		accountsRepo.UpdateAccount(newParty.getAccountName(), newParty.getAccountId());
		partyDetailsRepo.save(party);
	}

	public List<PartyDetailsDTO> getPartyDetailsList() {
		List<PartyDetailsDTO> accounts = new ArrayList<PartyDetailsDTO>();
		accounts = accountsRepo.getPartyDetailsList();
		return accounts;
	}

	public Optional<PartyDetailsDTO> getPartyDetailsById(Long accountId) {
		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsById(accountId);
		Optional<PartyDetailsDTO> opt = Optional.ofNullable(accounts);
		return opt;
	}

	public Optional<PartyDetailsDTO> getPartyDetailsByName(String name) {
		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsByName(name);
		Optional<PartyDetailsDTO> opt = Optional.ofNullable(accounts);
		return opt;
	}

	public List<EmployeeDetailsDTO> getEmployeeDetailsList() {
		List<EmployeeDetailsDTO> accounts = new ArrayList<EmployeeDetailsDTO>();
		accounts = accountsRepo.getEmployeeDetailsList();
		return accounts;
	}

	public Optional<EmployeeDetailsDTO> getEmployeeDetailsById(Long accountId) {
		EmployeeDetailsDTO accounts = new EmployeeDetailsDTO();
		accounts = accountsRepo.getEmployeeDetailsById(accountId);
		Optional<EmployeeDetailsDTO> opt = Optional.ofNullable(accounts);
		return opt;
	}

	public Optional<EmployeeDetailsDTO> getEmployeeDetailsByName(String name) {
		EmployeeDetailsDTO accounts = new EmployeeDetailsDTO();
		accounts = accountsRepo.getEmployeeDetailsByName(name);
		Optional<EmployeeDetailsDTO> opt = Optional.ofNullable(accounts);
		return opt;
	}

	// Find Accounts By Name
	public Long getAccountIdByAccountName(String typeName) {
		return accountsRepo.getAccountIdByAccountName(typeName).getAccountId();
	}

	// Find Accounts By Id
	public Long getAccountIdByAccountName(Long id) {
		return accountsRepo.getAccountNameById(id).getAccountId();
	}

//Update Accounts By Id
//	public Accounts updateAccounts(Accounts accounts) {
//		Accounts ac = accountsRepo.getById(accounts.getAccountId());
//		ac.setAccountId(accounts.getAccountId());
//		ac.setAccountName(accounts.getAccountName());
//		return accountsRepo.save(ac);
//	}

//Delete Accounts By Id
//	public void deleteAccountsById(Long id) {
//		accountsRepo.deleteById(id);
//	}

//	public List<InvoiceViewDTO> getPrintViewList() {
//
//		List<InvoiceViewDTO> printViewList = new ArrayList<InvoiceViewDTO>();
//
//		List<InvoiceDataDTO> printDTO = new ArrayList<InvoiceDataDTO>();
//
//		printDTO = accountsRepo.getInvoiceData().stream()
//				.filter(t -> t.getBookInfoNarration().equals("Sales") || t.getBookInfoNarration().equals("Purchase"))
//				.collect(Collectors.toList());
//
//		List<Long> getBookIds = new ArrayList<Long>();
//
//		for (InvoiceDataDTO data : printDTO) {
//			getBookIds.add(data.getBookInfoId());
//		}
//
//		List<Long> getBookId = getBookIds.stream().distinct().collect(Collectors.toList());
//
//		for (Long bid : getBookId) {// main lopp
//
//			InvoiceViewDTO data = new InvoiceViewDTO();
//
//			int flag = 1;
//
//			for (InvoiceDataDTO filterData : printDTO) {// inner loop
//
//				if (filterData.getBookInfoId().equals(bid)) {
//
//					if (flag == 1) {
//						data.setAccountId(filterData.getAccountId());
//						data.setBookInfoId(filterData.getBookInfoId());
//						data.setAccountName(filterData.getAccountName());
//						data.setPartyContactNo1(filterData.getPartyContactNo1());
//						data.setPartyContactNo2(filterData.getPartyContactNo2());
//						data.setPartyEmailId(filterData.getPartyEmailId());
//						data.setVoucherDate(filterData.getBookInfoDate());
//						data.setVoucherAmount(0d);
//						data.setVoucherType(filterData.getBookInfoNarration());
//
//						flag = 0;
//					}
//					Double tempAmount = data.getVoucherAmount();
//					tempAmount = tempAmount + filterData.getBookDetailsParticularAmount()
//							+ filterData.getBookDetailsSgstAmount() + filterData.getBookDetailsCgstAmount()
//							+ filterData.getBookDetailsIgstAmount();
//					data.setVoucherAmount(tempAmount);
//
//				}
//
//			}
//
//			InvoiceViewDTO printView = new InvoiceViewDTO(data.getAccountId(), data.getBookInfoId(),
//					data.getAccountName(), data.getPartyContactNo1(), data.getPartyContactNo2(), data.getPartyEmailId(),
//					data.getVoucherDate(), data.getVoucherAmount(), data.getVoucherType());
//			printViewList.add(printView);
//
//		}
//
//		return printViewList;
//
//	}

	public InvoicePrintObject getSalesInvoicePrintList(Long acId, Long FolioNo) {
		InvoicePrintObject invoicePrintObject = new InvoicePrintObject();

		List<InvoiceJRBeanDataSource> printViewList = new ArrayList<InvoiceJRBeanDataSource>();
		List<InvoiceDataDTO> printDTO = new ArrayList<InvoiceDataDTO>();
		printDTO = accountsRepo
				.getInvoiceData().stream().filter(t -> t.getBookInfoNarration().equals("Sales")
						&& t.getAccountId().equals(acId) && t.getBookInfoFolio_Ref().equals(FolioNo))
				.collect(Collectors.toList());
		if (!printDTO.isEmpty()) {
//			invoicePrintObject.setAccountId(printDTO.get(0).getAccountId());
			invoicePrintObject.setAccountName(printDTO.get(0).getAccountName());
//			invoicePrintObject.setPartyContactNo1(printDTO.get(0).getPartyContactNo1());
//			invoicePrintObject.setPartyContactNo2(printDTO.get(0).getPartyContactNo2());
//			invoicePrintObject.setBookInfoDate(printDTO.get(0).getBookInfoDate());
//			invoicePrintObject.setPartyGstNo(printDTO.get(0).getPartyGstNo());
//			invoicePrintObject.setPartyEmailId(printDTO.get(0).getPartyEmailId());
//			invoicePrintObject.setPartyBillingAddress(printDTO.get(0).getPartyBillingAddress());
//			invoicePrintObject.setPartyShipingAddress(printDTO.get(0).getPartyShipingAddress());
//			invoicePrintObject.setPartyEmailId(printDTO.get(0).getPartyEmailId());
//			for (InvoiceDataDTO data : printDTO) {
			for (int i = 0; i < 2; i++) {
				InvoiceDataDTO data = printDTO.get(0);
				InvoiceJRBeanDataSource printView = new InvoiceJRBeanDataSource();
				List<String> list = new ArrayList<String>();
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx2");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx3");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx4");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx5");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx6");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx7");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx8");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx9");
				list.add("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx10");
				printView.setBookDetailsParticular(list);
				printView.setBookDetailsParticularAmount(data.getBookDetailsParticularAmount());
				printView.setBookDetailsUnit(data.getBookDetailsUnit());
				printView.setBookDetailsUnitValue(data.getBookDetailsUnitValue());
				printView.setBookDetailsHsnCode("##");
				printView.setBookDetailsTradDiscount(data.getBookDetailsTradDiscount());
				printView.setBookDetailsTradDiscountAmount(data.getBookDetailsTradDiscountAmount());

				printViewList.add(printView);

			}
			invoicePrintObject.setInvoiceJRBeanDataSources(printViewList);
		}

		return invoicePrintObject;

	}

	public List<InvoiceDataDTO> getPurchaseInvoicePrintList(Long acId) {
		List<InvoiceDataDTO> printDTO = new ArrayList<InvoiceDataDTO>();
		printDTO = accountsRepo.getInvoiceData().stream()
				.filter(t -> t.getBookInfoNarration().equals("Purchase") && t.getAccountId().equals(acId))
				.collect(Collectors.toList());
		return printDTO;

	}

	public Optional<PartyDetailsDTO> getAccounts(String typeName) {
		PartyDetailsDTO accounts = new PartyDetailsDTO();
		accounts = accountsRepo.getPartyDetailsByName(typeName);
		Optional<PartyDetailsDTO> opt = Optional.ofNullable(accounts);
		return opt;

	}
//	public List<InvoiceDto> getAccountForInvoice() {
//		List<InvoiceDto> invoicedto = new ArrayList<InvoiceDto>();
//		List<Accounts> ac = new ArrayList<Accounts>();
//		ac = accountsRepo.findAll();
//
//		for (Accounts newac : ac) {
//			if (newac.getAccountId() != null) {
//				InvoiceDto newparty = new InvoiceDto();
//				List<BookInfo> newBookinfo = new ArrayList<BookInfo>();
//				newparty.setAccountId(newac.getAccountId());
//				newparty.setAccountName(newac.getAccountName());
//				newparty.setPartyDetails(newac.getPartyDetails());
//				for (BookInfo bi : newac.getBookInfos()) {
//					BookInfo bookInfo = new BookInfo();
////					if (bi != null) {
//					bookInfo.setBookInfoId(bi.getBookInfoId());
//					bookInfo.setBookInfoAccount_Ref(bi.getBookInfoAccount_Ref());
//					bookInfo.setBookInfoDate(bi.getBookInfoDate());
//					bookInfo.setBookInfoFolio_Ref(bi.getBookInfoFolio_Ref());
//					bookInfo.setBookInfoNarration(bi.getBookInfoNarration());
//					bookInfo.setBookInfoType_Ref(bi.getBookInfoType_Ref());
//					bookInfo.setBookInfoUser_Ref(bi.getBookInfoUser_Ref());
//					bookInfo.setBookDetails(bi.getBookDetails());
//
////					}
//					newBookinfo.add(bookInfo);
//				}
//				newparty.setBookInfos(newBookinfo);
//
//				invoicedto.add(newparty);
//			}
//
//		}
//
//		return invoicedto;
//
//	}
}
