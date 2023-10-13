package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.Bom;

public interface BomRepo extends JpaRepository<Bom, Long> {

}
