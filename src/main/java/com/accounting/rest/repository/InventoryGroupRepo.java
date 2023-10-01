package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.InventoryGroup;

public interface InventoryGroupRepo extends JpaRepository<InventoryGroup, Long> {

}
