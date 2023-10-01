package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
