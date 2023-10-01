package com.accounting.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AccountsForSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_ac_salary", allocationSize = 1)

	private Long id;
	private String accountName;

	public AccountsForSalary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountsForSalary(Long id, String accountName) {
		super();
		this.id = id;
		this.accountName = accountName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
