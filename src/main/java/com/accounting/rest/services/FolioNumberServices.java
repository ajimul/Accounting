package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.dto.FolioDTO;
import com.accounting.rest.dto.GenericsFolioNumber;
import com.accounting.rest.dto.InvoiceDto;
import com.accounting.rest.dto.InvoiceJRBeanDataSource;
import com.accounting.rest.dto.InvoiceJRParameter;
import com.accounting.rest.dto.PartyDetailsDTO;
import com.accounting.rest.entity.FolioNumber;
import com.accounting.rest.entity.InventoryItems;
import com.accounting.rest.repository.FolioNumberRepo;

@Service
public class FolioNumberServices {

	private final AccountsServices accountsServices;
	private final InventoryItemsService inventoryItemsService;
	private final FolioNumberRepo folioNumberRepo;

	@Autowired
	public FolioNumberServices(FolioNumberRepo folioNumberRepo, AccountsServices accountsServices,
			InventoryItemsService inventoryItemsService) {
		this.folioNumberRepo = folioNumberRepo;
		this.accountsServices = accountsServices;
		this.inventoryItemsService = inventoryItemsService;
	}

//Add FolioNumber

	public FolioNumber addFolioNumber(FolioNumber folioNumber) {
		return folioNumberRepo.save(folioNumber);
	}

	public void addFolio(FolioNumber folio) {
		folioNumberRepo.save(folio);
	}

//Find All FolioNumber 
	public List<GenericsFolioNumber> findAllFolioNumber() {
		List<GenericsFolioNumber> folioNumber = new ArrayList<GenericsFolioNumber>();
		List<FolioNumber> folioNumberList = folioNumberRepo.findAll();
		for (FolioNumber folioNumbers : folioNumberList) {
			GenericsFolioNumber newFolio = new GenericsFolioNumber();
			newFolio.setFolioId(folioNumbers.getFolioId());
			newFolio.setFolioNarration(folioNumbers.getFolioNarration());
			folioNumber.add(newFolio);
		}
		return folioNumber;
	}

	// Join Table Response(Accounts+PartyDetails+BookInfo+BookDetails+Emi)
	public List<FolioDTO> getEmi() {
		return folioNumberRepo.getEmi();

	}

//Find Customer Invoice/Bill By FolioNumber Id (invoiceNo.)
	public InvoiceDto getInvoiceByFolioId(Long folioId) {

		Optional<FolioNumber> folio = Optional.ofNullable(new FolioNumber());
		folio = folioNumberRepo.findById(folioId);

		InvoiceDto invoiceDto = new InvoiceDto();

		List<InvoiceJRBeanDataSource> BeanDataSourceList = new ArrayList<InvoiceJRBeanDataSource>();

		InvoiceJRParameter invoiceJRParameter = new InvoiceJRParameter();

		Double totalAmount = 0.0;

		Optional<PartyDetailsDTO> partyDetails = Optional.ofNullable(new PartyDetailsDTO());

		if (folio.isPresent()) {

			/**
			 * Here Bookinfo Is Use As A List But Actually Bookinfo Is Use Instance Of
			 * Bookinfo Because Bookinfo List Have Only One Record At A Time For Each
			 * Transaction Its The Project Requirement
			 */
			for (int i = 0; i < folio.get().getBookInfos().size(); i++) {
				partyDetails = accountsServices
						.getPartyDetailsById(folio.get().getBookInfos().get(i).getBookInfoAccount_Ref());
				invoiceJRParameter.setFolioId(folioId);
				invoiceJRParameter.setPartyId(partyDetails.get().getAccountId());
				invoiceJRParameter.setPartyName(partyDetails.get().getAccountName());
				invoiceJRParameter.setPartyBillingAddress(partyDetails.get().getPartyBillingAddress());
				invoiceJRParameter.setPartyShipingAddress(partyDetails.get().getPartyShipingAddress());
				invoiceJRParameter.setInvoiceDate(folio.get().getBookInfos().get(i).getBookInfoDate());

				for (int j = 0; j < folio.get().getBookInfos().get(i).getBookDetails().size(); j++) {
					List<String> items_ItemsSerialNo = new ArrayList<String>();
					StringBuilder items_WithSerialNo = new StringBuilder();
					InventoryItems inventoryItems = new InventoryItems();
					inventoryItems = inventoryItemsService.getInventoryItemByiiId(folio.get().getBookInfos().get(i)
							.getBookDetails().get(j).getBookDetailsInventoryItems_Ref());
					String bookParticular = inventoryItems.getIiParticular();
					String hsn = inventoryItems.getIiHsn();
					items_WithSerialNo.append(bookParticular + " \n");
					for (int k = 0; k < folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookItemsSerialNo()
							.size(); k++) {
						items_WithSerialNo.append(folio.get().getBookInfos().get(i).getBookDetails().get(j)
								.getBookItemsSerialNo().get(k).getSerialNo() + " \n");
					}

					items_ItemsSerialNo.add(items_WithSerialNo.toString());
					InvoiceJRBeanDataSource invoiceJRBeanDataSource = new InvoiceJRBeanDataSource();
					invoiceJRBeanDataSource.setBookDetailsParticular(items_ItemsSerialNo);

					invoiceJRBeanDataSource.setBookDetailsParticularAmount(folio.get().getBookInfos().get(i)
							.getBookDetails().get(j).getBookDetailsParticularAmount()
							+ folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsSgstAmount()
							+ folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsCgstAmount()
							+ folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsIgstAmount());
					totalAmount += invoiceJRBeanDataSource.getBookDetailsParticularAmount();
					invoiceJRBeanDataSource.setBookDetailsUnit(
							folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsUnit());
					invoiceJRBeanDataSource.setBookDetailsUnitValue(
							folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsUnitValue());
					invoiceJRBeanDataSource.setBookDetailsHsnCode(hsn);
					invoiceJRBeanDataSource.setBookDetailsTradDiscount(
							folio.get().getBookInfos().get(i).getBookDetails().get(j).getBookDetailsTradDiscount());
					invoiceJRBeanDataSource.setBookDetailsTradDiscountAmount(folio.get().getBookInfos().get(i)
							.getBookDetails().get(j).getBookDetailsTradDiscountAmount());
					BeanDataSourceList.add(invoiceJRBeanDataSource);

				}
				invoiceJRParameter.setTotalAmount(totalAmount);
				invoiceDto.setInvoiceJRParameter(invoiceJRParameter);
				invoiceDto.setInvoiceJRBeanDataSource(BeanDataSourceList);
			}

		}
		return invoiceDto;

	}

//Update FolioNumber

//Delete FolioNumber By Id
	public void deleteFolioNumberById(Long id) {

		folioNumberRepo.deleteById(id);

	}

}
