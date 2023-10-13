package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.Bomlist;

public interface BomlistRepo extends JpaRepository<Bomlist, Long> {

}
