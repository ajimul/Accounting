package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.ProductServices;

public interface ProductServicesRepo extends JpaRepository<ProductServices, Long> {

}
