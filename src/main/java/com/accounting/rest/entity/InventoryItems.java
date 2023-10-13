package com.accounting.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "inventory_items")
public class InventoryItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_inventory_items", allocationSize = 1)
	private Long iiId;
	private Long ii_ilId;
	private Integer iiQty;
	private Double iiMrp;
	private Double iiPurchaseAmount;
	private Double iiSalesAmount;
	private Integer iiTDPercent;
	private String iiParticular;
	private String iiHsn;
	private String iiModelNo;
	private String iiUnitName;
	private Integer iiCgstPercent;
	private Integer iiSgstPercent;
	private Integer iiIgstPercent;
	private Integer iiNoOfService;
	private Integer iiMonthOfWarranty;

	@OneToMany(targetEntity = InventoryJournal.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ij_iiId", referencedColumnName = "iiId")
	private List<InventoryJournal> inventoryJournals;

	@OneToMany(targetEntity = BookDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookDetailsInventoryItems_Ref", referencedColumnName = "iiId")
	private List<BookDetails> bookDetails;

	@OneToMany(targetEntity = Bomlist.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bomListItemsId_Ref", referencedColumnName = "iiId")
	private List<Bomlist> bomlist;

	public InventoryItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItems(Long iiId, Long ii_ilId, Integer iiQty, Double iiMrp, Double iiPurchaseAmount,
			Double iiSalesAmount, Integer iiTDPercent, String iiParticular, String iiHsn, String iiModelNo,
			String iiUnitName, Integer iiCgstPercent, Integer iiSgstPercent, Integer iiIgstPercent,
			Integer iiNoOfService, Integer iiMonthOfWarranty, List<InventoryJournal> inventoryJournals,
			List<BookDetails> bookDetails, List<Bomlist> bomlist) {
		super();
		this.iiId = iiId;
		this.ii_ilId = ii_ilId;
		this.iiQty = iiQty;
		this.iiMrp = iiMrp;
		this.iiPurchaseAmount = iiPurchaseAmount;
		this.iiSalesAmount = iiSalesAmount;
		this.iiTDPercent = iiTDPercent;
		this.iiParticular = iiParticular;
		this.iiHsn = iiHsn;
		this.iiModelNo = iiModelNo;
		this.iiUnitName = iiUnitName;
		this.iiCgstPercent = iiCgstPercent;
		this.iiSgstPercent = iiSgstPercent;
		this.iiIgstPercent = iiIgstPercent;
		this.iiNoOfService = iiNoOfService;
		this.iiMonthOfWarranty = iiMonthOfWarranty;
		this.inventoryJournals = inventoryJournals;
		this.bookDetails = bookDetails;
		this.bomlist = bomlist;
	}

	public Long getIiId() {
		return iiId;
	}

	public void setIiId(Long iiId) {
		this.iiId = iiId;
	}

	public Long getIi_ilId() {
		return ii_ilId;
	}

	public void setIi_ilId(Long ii_ilId) {
		this.ii_ilId = ii_ilId;
	}

	public Integer getIiQty() {
		return iiQty;
	}

	public void setIiQty(Integer iiQty) {
		this.iiQty = iiQty;
	}

	public Double getIiMrp() {
		return iiMrp;
	}

	public void setIiMrp(Double iiMrp) {
		this.iiMrp = iiMrp;
	}

	public Double getIiPurchaseAmount() {
		return iiPurchaseAmount;
	}

	public void setIiPurchaseAmount(Double iiPurchaseAmount) {
		this.iiPurchaseAmount = iiPurchaseAmount;
	}

	public Double getIiSalesAmount() {
		return iiSalesAmount;
	}

	public void setIiSalesAmount(Double iiSalesAmount) {
		this.iiSalesAmount = iiSalesAmount;
	}

	public Integer getIiTDPercent() {
		return iiTDPercent;
	}

	public void setIiTDPercent(Integer iiTDPercent) {
		this.iiTDPercent = iiTDPercent;
	}

	public String getIiParticular() {
		return iiParticular;
	}

	public void setIiParticular(String iiParticular) {
		this.iiParticular = iiParticular;
	}

	public String getIiHsn() {
		return iiHsn;
	}

	public void setIiHsn(String iiHsn) {
		this.iiHsn = iiHsn;
	}

	public String getIiModelNo() {
		return iiModelNo;
	}

	public void setIiModelNo(String iiModelNo) {
		this.iiModelNo = iiModelNo;
	}

	public String getIiUnitName() {
		return iiUnitName;
	}

	public void setIiUnitName(String iiUnitName) {
		this.iiUnitName = iiUnitName;
	}

	public Integer getIiCgstPercent() {
		return iiCgstPercent;
	}

	public void setIiCgstPercent(Integer iiCgstPercent) {
		this.iiCgstPercent = iiCgstPercent;
	}

	public Integer getIiSgstPercent() {
		return iiSgstPercent;
	}

	public void setIiSgstPercent(Integer iiSgstPercent) {
		this.iiSgstPercent = iiSgstPercent;
	}

	public Integer getIiIgstPercent() {
		return iiIgstPercent;
	}

	public void setIiIgstPercent(Integer iiIgstPercent) {
		this.iiIgstPercent = iiIgstPercent;
	}

	public Integer getIiNoOfService() {
		return iiNoOfService;
	}

	public void setIiNoOfService(Integer iiNoOfService) {
		this.iiNoOfService = iiNoOfService;
	}

	public Integer getIiMonthOfWarranty() {
		return iiMonthOfWarranty;
	}

	public void setIiMonthOfWarranty(Integer iiMonthOfWarranty) {
		this.iiMonthOfWarranty = iiMonthOfWarranty;
	}

	public List<InventoryJournal> getInventoryJournals() {
		return inventoryJournals;
	}

	public void setInventoryJournals(List<InventoryJournal> inventoryJournals) {
		this.inventoryJournals = inventoryJournals;
	}

	public List<BookDetails> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookDetails> bookDetails) {
		this.bookDetails = bookDetails;
	}

	public List<Bomlist> getBomlist() {
		return bomlist;
	}

	public void setBomlist(List<Bomlist> bomlist) {
		this.bomlist = bomlist;
	}

}
