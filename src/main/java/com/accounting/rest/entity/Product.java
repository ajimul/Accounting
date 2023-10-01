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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_p", allocationSize = 1)
	private Long psId;
	private Long folio_Id;
	private Long ps_AccountId;
	private Long ps_AuthorId;
	private String psProductName;
	private String psProductModel;
	private String psProductSerialNo;
	private Integer psProductAge;
	private Double psProductValue;
	private String psType;
	private Integer psMonthOfWarranty;
	private Integer psTotalService;

	@OneToMany(targetEntity = ProductServices.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ps_Id", referencedColumnName = "psId")
	private List<ProductServices> productServices;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long psId, Long folio_Id, Long ps_AccountId, Long ps_AuthorId, String psProductName,
			String psProductModel, String psProductSerialNo, Integer psProductAge, Double psProductValue, String psType,
			Integer psMonthOfWarranty, Integer psTotalService, List<ProductServices> productServices) {
		super();
		this.psId = psId;
		this.folio_Id = folio_Id;
		this.ps_AccountId = ps_AccountId;
		this.ps_AuthorId = ps_AuthorId;
		this.psProductName = psProductName;
		this.psProductModel = psProductModel;
		this.psProductSerialNo = psProductSerialNo;
		this.psProductAge = psProductAge;
		this.psProductValue = psProductValue;
		this.psType = psType;
		this.psMonthOfWarranty = psMonthOfWarranty;
		this.psTotalService = psTotalService;
		this.productServices = productServices;
	}

	public Long getPsId() {
		return psId;
	}

	public void setPsId(Long psId) {
		this.psId = psId;
	}

	public Long getFolio_Id() {
		return folio_Id;
	}

	public void setFolio_Id(Long folio_Id) {
		this.folio_Id = folio_Id;
	}

	public Long getPs_AccountId() {
		return ps_AccountId;
	}

	public void setPs_AccountId(Long ps_AccountId) {
		this.ps_AccountId = ps_AccountId;
	}

	public Long getPs_AuthorId() {
		return ps_AuthorId;
	}

	public void setPs_AuthorId(Long ps_AuthorId) {
		this.ps_AuthorId = ps_AuthorId;
	}

	public String getPsProductName() {
		return psProductName;
	}

	public void setPsProductName(String psProductName) {
		this.psProductName = psProductName;
	}

	public String getPsProductModel() {
		return psProductModel;
	}

	public void setPsProductModel(String psProductModel) {
		this.psProductModel = psProductModel;
	}

	public String getPsProductSerialNo() {
		return psProductSerialNo;
	}

	public void setPsProductSerialNo(String psProductSerialNo) {
		this.psProductSerialNo = psProductSerialNo;
	}

	public Integer getPsProductAge() {
		return psProductAge;
	}

	public void setPsProductAge(Integer psProductAge) {
		this.psProductAge = psProductAge;
	}

	public Double getPsProductValue() {
		return psProductValue;
	}

	public void setPsProductValue(Double psProductValue) {
		this.psProductValue = psProductValue;
	}

	public String getPsType() {
		return psType;
	}

	public void setPsType(String psType) {
		this.psType = psType;
	}

	public Integer getPsMonthOfWarranty() {
		return psMonthOfWarranty;
	}

	public void setPsMonthOfWarranty(Integer psMonthOfWarranty) {
		this.psMonthOfWarranty = psMonthOfWarranty;
	}

	public Integer getPsTotalService() {
		return psTotalService;
	}

	public void setPsTotalService(Integer psTotalService) {
		this.psTotalService = psTotalService;
	}

	public List<ProductServices> getProductServices() {
		return productServices;
	}

	public void setProductServices(List<ProductServices> productServices) {
		this.productServices = productServices;
	}

}
