package com.accounting.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.Emi;

public interface EmiRepo extends JpaRepository<Emi, Long> {
	@Query("select u from Emi u where u.emi_BiId=:voucherId")
	List<Emi> getEmi_ByVoucherId(@Param("voucherId") Long voucherId);
}
