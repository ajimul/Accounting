package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.InventoryLocation;

public interface InventoryLocationRepo extends JpaRepository<InventoryLocation, Long> {

}
