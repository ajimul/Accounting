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

@Entity
public class FolioNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_folio", allocationSize = 1)

	private Long folioId;
	private String folioNarration;

	@OneToMany(targetEntity = Ledger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgerFolio_Ref", referencedColumnName = "folioId")
	private List<Ledger> ledger;

	/**
	 * Here Bookinfo Is Use As A List But Actually Bookinfo Is Use Instance Of
	 * Bookinfo Because Bookinfo List Have Only One Record At A Time For Each
	 * Transaction Its The Project Requirement
	 */
	@OneToMany(targetEntity = BookInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookInfoFolio_Ref", referencedColumnName = "folioId")
	private List<BookInfo> bookInfos;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "folio_Id", referencedColumnName = "folioId")
	private List<Product> product;

	public FolioNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FolioNumber(Long folioId, String folioNarration, List<Ledger> ledger, List<BookInfo> bookInfos,
			List<Product> product) {
		super();
		this.folioId = folioId;
		this.folioNarration = folioNarration;
		this.ledger = ledger;
		this.bookInfos = bookInfos;
		this.product = product;
	}

	public Long getFolioId() {
		return folioId;
	}

	public void setFolioId(Long folioId) {
		this.folioId = folioId;
	}

	public String getFolioNarration() {
		return folioNarration;
	}

	public void setFolioNarration(String folioNarration) {
		this.folioNarration = folioNarration;
	}

	public List<Ledger> getLedger() {
		return ledger;
	}

	public void setLedger(List<Ledger> ledger) {
		this.ledger = ledger;
	}

	public List<BookInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
