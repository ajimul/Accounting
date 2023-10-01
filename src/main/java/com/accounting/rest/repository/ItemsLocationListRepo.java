package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.ItemsLocationList;

public interface ItemsLocationListRepo extends JpaRepository<ItemsLocationList, Long> {

}
