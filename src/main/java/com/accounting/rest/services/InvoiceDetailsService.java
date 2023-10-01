package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.BooksDetailsDTO;
import com.accounting.rest.dto.PartyBookInfoDto;
import com.accounting.rest.dto_maper.InvoiceDetailsDto;
import com.accounting.rest.repository.AccountsRepo;
import com.accounting.rest.repository.InventoryItemsRepo;

@Service
public class InvoiceDetailsService {

	private final AccountsRepo accountsRepo;
	private final InventoryItemsRepo inventoryItemsRepo;

	@Autowired
	public InvoiceDetailsService(AccountsRepo accountsRepo, InventoryItemsRepo inventoryItemsRepo) {
		this.accountsRepo = accountsRepo;
		this.inventoryItemsRepo = inventoryItemsRepo;
	}

//	public List<InvoiceDetailsDto> getInvoiceDetails(Long acId, Long bookInfoId) {
//
//		List<PartyBookInfoDto> partyBookInfo = new ArrayList<PartyBookInfoDto>();
//		partyBookInfo = accountsRepo.getPartyBookInfoByPartyId(acId).stream()
//				.filter(t -> t.getBookInfoId().equals(bookInfoId)).collect(Collectors.toList());
//		List<InvoiceDetailsDto> invoiceDetailsList = new ArrayList<InvoiceDetailsDto>();
//		for (PartyBookInfoDto party : partyBookInfo) {
//			BooksDetailsDTO booksDetails = new BooksDetailsDTO();
//			InvoiceDetailsDto invoiceDetail = new InvoiceDetailsDto();
//			booksDetails = inventoryItemsRepo.getInventoryItemsById(party.getBookDetailsInventoryItems_Ref());
//			invoiceDetail.setAccountId(party.getAccountId());
//			invoiceDetail.setAccountName(party.getAccountName());
//			invoiceDetail.setPartyContactNo1(party.getPartyContactNo1());
//			invoiceDetail.setPartyContactNo2(party.getPartyContactNo2());
//			invoiceDetail.setPartyEmailId(party.getPartyEmailId());
//			invoiceDetail.setPartyGstNo(party.getPartyGstNo());
//			invoiceDetail.setPartyBillingAddress(party.getPartyBillingAddress());
//			invoiceDetail.setPartyShipingAddress(party.getPartyShipingAddress());
//			invoiceDetail.setBookInfoId(party.getBookInfoId());
//			invoiceDetail.setBookInfoNarration(party.getBookInfoNarration());
//			invoiceDetail.setBookInfoDate(party.getBookInfoDate());
//			invoiceDetail.setIiParticular(booksDetails.getIiParticular());
//			invoiceDetail.setIiHsn(booksDetails.getIiHsn());
//			invoiceDetail.setBookDetailsId(booksDetails.getBookDetailsId());
//			invoiceDetail.setBookDetailsBookInfo_Ref(booksDetails.getBookDetailsBookInfo_Ref());
//			invoiceDetail.setBookDetailsInventoryItems_Ref(booksDetails.getBookDetailsInventoryItems_Ref());
//			invoiceDetail.setBookDetailsParticularAmount(booksDetails.getBookDetailsParticularAmount());
//			invoiceDetail.setBookDetailsUnit(booksDetails.getBookDetailsUnit());
//			invoiceDetail.setBookDetailsUnitValue(booksDetails.getBookDetailsUnitValue());
//			invoiceDetail.setBookDetailsMolelNo(booksDetails.getBookDetailsMolelNo());
//			invoiceDetail.setBookDetailsTradDiscount(booksDetails.getBookDetailsTradDiscount());
//			invoiceDetail.setBookDetailsTradDiscountAmount(booksDetails.getBookDetailsTradDiscountAmount());
//			invoiceDetail.setBookDetailsCgst(booksDetails.getBookDetailsCgst());
//			invoiceDetail.setBookDetailsSgst(booksDetails.getBookDetailsSgst());
//			invoiceDetail.setBookDetailsIgst(booksDetails.getBookDetailsIgst());
//			invoiceDetail.setBookDetailsCgstAmount(booksDetails.getBookDetailsCgstAmount());
//			invoiceDetail.setBookDetailsSgstAmount(booksDetails.getBookDetailsSgstAmount());
//			invoiceDetail.setBookDetailsIgstAmount(booksDetails.getBookDetailsIgstAmount());
//			invoiceDetailsList.add(invoiceDetail);
//		}
//
//		return invoiceDetailsList;
//
//	}

	public List<PartyBookInfoDto> getPartyBookInfoDtoCheck() {

		List<PartyBookInfoDto> partyBookInfo = new ArrayList<PartyBookInfoDto>();
		partyBookInfo = accountsRepo.getPartyBookInfo();
		return partyBookInfo;
	}

	public List<InvoiceDetailsDto> getInvoiceList() {
		List<InvoiceDetailsDto> filteredInventory = new ArrayList<InvoiceDetailsDto>();

		List<PartyBookInfoDto> partyBookInfo = new ArrayList<PartyBookInfoDto>();
		partyBookInfo = accountsRepo.getPartyBookInfo().stream()
				.filter(t -> t.getBookInfoNarration().equals("Purchase") || t.getBookInfoNarration().equals("Sales"))
				.collect(Collectors.toList());

		List<InvoiceDetailsDto> invoiceDetailsList = new ArrayList<InvoiceDetailsDto>();

		List<BooksDetailsDTO> booksDetails = new ArrayList<BooksDetailsDTO>();
		booksDetails = inventoryItemsRepo.getBooksDetails();

		for (PartyBookInfoDto party : partyBookInfo) {

			for (BooksDetailsDTO bd : booksDetails) {
				if (party.getBookDetailsId().equals(bd.getBookDetailsId())) {
					InvoiceDetailsDto invoiceDetail = new InvoiceDetailsDto();
					invoiceDetail.setAccountId(party.getAccountId());
					invoiceDetail.setAccountName(party.getAccountName());
					invoiceDetail.setPartyContactNo1(party.getPartyContactNo1());
					invoiceDetail.setPartyContactNo2(party.getPartyContactNo2());
					invoiceDetail.setPartyEmailId(party.getPartyEmailId());
					invoiceDetail.setPartyGstNo(party.getPartyGstNo());
					invoiceDetail.setPartyBillingAddress(party.getPartyBillingAddress());
					invoiceDetail.setPartyShipingAddress(party.getPartyShipingAddress());

					invoiceDetail.setBookInfoId(party.getBookInfoId());
					invoiceDetail.setBookInfoNarration(party.getBookInfoNarration());
					invoiceDetail.setBookInfoDate(party.getBookInfoDate());
					invoiceDetail.setBookInfoType_Ref(party.getBookInfoType_Ref());
					invoiceDetail.setBookInfoFolio_Ref(party.getBookInfoFolio_Ref());
					invoiceDetail.setBookInfoUser_Ref(party.getBookInfoUser_Ref());
					invoiceDetail.setBookInfoAccount_Ref(party.getBookInfoAccount_Ref());
					invoiceDetail.setInvoiceNo(party.getInvoiceNo());
					invoiceDetail.setInvoiceDate(party.getInvoiceDate());

					invoiceDetail.setIiParticular(bd.getIiParticular());
					invoiceDetail.setIiHsn(bd.getIiHsn());
					invoiceDetail.setBookDetailsId(bd.getBookDetailsId());
					invoiceDetail.setBookDetailsBookInfo_Ref(bd.getBookDetailsBookInfo_Ref());
					invoiceDetail.setBookDetailsInventoryItems_Ref(bd.getBookDetailsInventoryItems_Ref());
					invoiceDetail.setBookDetailsParticularAmount(bd.getBookDetailsParticularAmount());
					invoiceDetail.setBookDetailsUnit(bd.getBookDetailsUnit());
					invoiceDetail.setBookDetailsUnitValue(bd.getBookDetailsUnitValue());
					invoiceDetail.setBookDetailsMolelNo(bd.getBookDetailsMolelNo());
					invoiceDetail.setBookDetailsTradDiscount(bd.getBookDetailsTradDiscount());
					invoiceDetail.setBookDetailsTradDiscountAmount(bd.getBookDetailsTradDiscountAmount());
					invoiceDetail.setBookDetailsCgst(bd.getBookDetailsCgst());
					invoiceDetail.setBookDetailsSgst(bd.getBookDetailsSgst());
					invoiceDetail.setBookDetailsIgst(bd.getBookDetailsIgst());
					invoiceDetail.setBookDetailsCgstAmount(bd.getBookDetailsCgstAmount());
					invoiceDetail.setBookDetailsSgstAmount(bd.getBookDetailsSgstAmount());
					invoiceDetail.setBookDetailsIgstAmount(bd.getBookDetailsIgstAmount());
					invoiceDetailsList.add(invoiceDetail);
				}

			}
		}
		List<Long> getBookIds = new ArrayList<Long>();

		for (InvoiceDetailsDto data : invoiceDetailsList) {
			getBookIds.add(data.getBookInfoId());

		}
		List<Long> getBookId = getBookIds.stream().distinct().collect(Collectors.toList());

		for (Long data : getBookId) {// main loop

			InvoiceDetailsDto invoiceDetail = new InvoiceDetailsDto();
			boolean flag = true;
			for (InvoiceDetailsDto invoiceList : invoiceDetailsList) {// inner loop

				if (invoiceList.getBookInfoId().equals(data)) {
					if (flag) {

						invoiceDetail.setAccountId(invoiceList.getAccountId());
						invoiceDetail.setAccountName(invoiceList.getAccountName());
						invoiceDetail.setPartyContactNo1(invoiceList.getPartyContactNo1());
						invoiceDetail.setPartyContactNo2(invoiceList.getPartyContactNo2());
						invoiceDetail.setPartyEmailId(invoiceList.getPartyEmailId());
						invoiceDetail.setPartyGstNo(invoiceList.getPartyGstNo());
						invoiceDetail.setPartyBillingAddress(invoiceList.getPartyBillingAddress());
						invoiceDetail.setPartyShipingAddress(invoiceList.getPartyShipingAddress());

						invoiceDetail.setBookInfoId(invoiceList.getBookInfoId());
						invoiceDetail.setBookInfoNarration(invoiceList.getBookInfoNarration());
						invoiceDetail.setBookInfoDate(invoiceList.getBookInfoDate());
						invoiceDetail.setBookInfoType_Ref(invoiceList.getBookInfoType_Ref());
						invoiceDetail.setBookInfoFolio_Ref(invoiceList.getBookInfoFolio_Ref());
						invoiceDetail.setBookInfoUser_Ref(invoiceList.getBookInfoUser_Ref());
						invoiceDetail.setBookInfoAccount_Ref(invoiceList.getBookInfoAccount_Ref());
						invoiceDetail.setInvoiceNo(invoiceList.getInvoiceNo());
						invoiceDetail.setInvoiceDate(invoiceList.getInvoiceDate());

						invoiceDetail.setIi_ilId(invoiceList.getIi_ilId());
						invoiceDetail.setIiParticular(invoiceList.getIiParticular());
						invoiceDetail.setIiHsn(invoiceList.getIiHsn());
						invoiceDetail.setBookDetailsId(invoiceList.getBookDetailsId());
						invoiceDetail.setBookDetailsBookInfo_Ref(invoiceList.getBookDetailsBookInfo_Ref());
						invoiceDetail.setBookDetailsInventoryItems_Ref(invoiceList.getBookDetailsInventoryItems_Ref());
						invoiceDetail.setBookDetailsParticularAmount(0d);
						invoiceDetail.setBookDetailsUnit(invoiceList.getBookDetailsUnit());
						invoiceDetail.setBookDetailsUnitValue(invoiceList.getBookDetailsUnitValue());
						invoiceDetail.setBookDetailsMolelNo(invoiceList.getBookDetailsMolelNo());
						invoiceDetail.setBookDetailsTradDiscount(invoiceList.getBookDetailsTradDiscount());
						invoiceDetail.setBookDetailsTradDiscountAmount(invoiceList.getBookDetailsTradDiscountAmount());
						invoiceDetail.setBookDetailsCgst(invoiceList.getBookDetailsCgst());
						invoiceDetail.setBookDetailsSgst(invoiceList.getBookDetailsSgst());
						invoiceDetail.setBookDetailsIgst(invoiceList.getBookDetailsIgst());
						invoiceDetail.setBookDetailsCgstAmount(invoiceList.getBookDetailsCgstAmount());
						invoiceDetail.setBookDetailsSgstAmount(invoiceList.getBookDetailsSgstAmount());
						invoiceDetail.setBookDetailsIgstAmount(invoiceList.getBookDetailsIgstAmount());

						flag = false;
					}
					invoiceDetail.setBookDetailsParticularAmount(invoiceDetail.getBookDetailsParticularAmount()
							+ invoiceList.getBookDetailsParticularAmount() + invoiceList.getBookDetailsSgstAmount()
							+ invoiceList.getBookDetailsCgstAmount() + invoiceList.getBookDetailsIgstAmount());

				}

			}

			filteredInventory.add(invoiceDetail);

		}

		return filteredInventory;

	}
}
