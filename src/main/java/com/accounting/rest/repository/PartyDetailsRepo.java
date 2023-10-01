package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.PartyDetails;

public interface PartyDetailsRepo extends JpaRepository<PartyDetails, Long> {

}
