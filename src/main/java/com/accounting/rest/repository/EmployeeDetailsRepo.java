package com.accounting.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting.rest.entity.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Long> {

}
