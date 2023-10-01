package com.accounting.rest.dto;

import java.util.List;

public class ProductModel {
	private Long ps_AccountId;
	private Long ps_AuthorId;
	private String psProductName;
	private String psProductModel;
	private String psProductSerialNo;
	private Long psProductAge;
	private Long psProductValue;
	private String psType;
	private Long psMonthOfWarranty;
	private Long psTotalService;
	private Long psTotalAmount;
	private List<ProductServiceModel> productServices;

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

	public Long getPsProductAge() {
		return psProductAge;
	}

	public void setPsProductAge(Long psProductAge) {
		this.psProductAge = psProductAge;
	}

	public Long getPsProductValue() {
		return psProductValue;
	}

	public void setPsProductValue(Long psProductValue) {
		this.psProductValue = psProductValue;
	}

	public String getPsType() {
		return psType;
	}

	public void setPsType(String psType) {
		this.psType = psType;
	}

	public Long getPsMonthOfWarranty() {
		return psMonthOfWarranty;
	}

	public void setPsMonthOfWarranty(Long psMonthOfWarranty) {
		this.psMonthOfWarranty = psMonthOfWarranty;
	}

	public Long getPsTotalService() {
		return psTotalService;
	}

	public void setPsTotalService(Long psTotalService) {
		this.psTotalService = psTotalService;
	}

	public Long getPsTotalAmount() {
		return psTotalAmount;
	}

	public void setPsTotalAmount(Long psTotalAmount) {
		this.psTotalAmount = psTotalAmount;
	}

	public List<ProductServiceModel> getProductServices() {
		return productServices;
	}

	public void setProductServices(List<ProductServiceModel> productServices) {
		this.productServices = productServices;
	}

	public ProductModel(Long ps_AccountId, Long ps_AuthorId, String psProductName, String psProductModel,
			String psProductSerialNo, Long psProductAge, Long psProductValue, String psType, Long psMonthOfWarranty,
			Long psTotalService, Long psTotalAmount, List<ProductServiceModel> productServices) {
		super();
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
		this.psTotalAmount = psTotalAmount;
		this.productServices = productServices;
	}

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ModelProduct [ps_AccountId=" + ps_AccountId + ", ps_AuthorId=" + ps_AuthorId + ", psProductName="
				+ psProductName + ", psProductModel=" + psProductModel + ", psProductSerialNo=" + psProductSerialNo
				+ ", psProductAge=" + psProductAge + ", psProductValue=" + psProductValue + ", psType=" + psType
				+ ", psMonthOfWarranty=" + psMonthOfWarranty + ", psTotalService=" + psTotalService + ", psTotalAmount="
				+ psTotalAmount + ", productServices=" + productServices + "]";
	}

}
