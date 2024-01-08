package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.Emi;
import com.accounting.rest.repository.EmiRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class EmiService {

	private final EmiRepo installmentRepo;

	@Autowired
	public EmiService(EmiRepo installmentRepo) {
		this.installmentRepo = installmentRepo;
	}

	public List<Emi> addEmi(List<Emi> installment) {
		return installmentRepo.saveAll(installment);
	}

	public List<Emi> getEmi_ByVoucherId(Long voucherId) {
		return installmentRepo.getEmi_ByVoucherId(voucherId);
	}

	public void addEmi(Emi emi) {
		installmentRepo.save(emi);

	}

	public List<Emi> getEmi() {
		return installmentRepo.findAll();
	}

	public void deleteEmi(Long id) {
		installmentRepo.deleteById(id);
	}

	public Emi updateEmi(Emi emi) {
		return installmentRepo.save(emi);
	}

}
