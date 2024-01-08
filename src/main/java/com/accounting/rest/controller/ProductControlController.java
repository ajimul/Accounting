package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.ProductServiceSmsConfig;
import com.accounting.rest.entity.ProductServices;
import com.accounting.rest.repository.ProductServicesRepo;
import com.accounting.rest.services.AccountsServices;

@RestController
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/product/service")
@Scope("prototype")
public class ProductControlController {

	private final ProductServicesRepo service;
	private final AccountsServices accountsServices;

	@Autowired
	public ProductControlController(ProductServicesRepo service, AccountsServices accountsServices) {
		super();
		this.service = service;
		this.accountsServices = accountsServices;

	}

	@GetMapping("/config")
	public ResponseEntity<List<ProductServiceSmsConfig>> getPservice() {
		return new ResponseEntity<>(accountsServices.getProductServiceSmsConfig(), HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProductSmsConfig(@RequestBody ProductServiceSmsConfig ps) {
		ProductServices ser = new ProductServices();
		ser.setPsId(ps.getPsId());
		ser.setPs_Id(ps.getPs_Id());
		ser.setPsEngineerName(ps.getPsEngineerName());
		ser.setPsNo(ps.getPsNo());
		ser.setPsDate(ps.getPsDate());
		ser.setPsStatus(ps.getPsStatus());
		ser.setPsMessage(ps.getPsMessage());
		ser.setPsSmsStatus(ps.isPsSmsStatus());
		service.save(ser);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
