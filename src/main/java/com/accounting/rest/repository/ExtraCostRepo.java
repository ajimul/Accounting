package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.ExtraCost;

public interface ExtraCostRepo extends JpaRepository<ExtraCost, Long> {

}
