package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.GenericsLedger;
import com.accounting.rest.services.LedgerServices;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/ledger")
public class LedgerController {
	private final LedgerServices ledgerServices;

	@Autowired
	public LedgerController(LedgerServices ledgerServices) {
		this.ledgerServices = ledgerServices;
	}

//
//	// Add Ledger
//	@PostMapping("/add")
//	public ResponseEntity<Ledger> addLedger(@RequestBody Ledger ledger) {
//		return new ResponseEntity<>(ledgerServices.addLedger(ledger), HttpStatus.CREATED);
//
//	}
//
//	// Get All Ledger(Parent) Only Fatch Parent Table Data Not Child Table Data
//	@GetMapping("/")
//	public ResponseEntity<List<Ledger>> findAllLedger() {
//		return new ResponseEntity<>(ledgerServices.findAllLedger(), HttpStatus.OK);
//		
//	}
	@GetMapping("/id:{Id}")
	public ResponseEntity<GenericsLedger> GetLadgerByAccountId(@PathVariable("Id") Long Id) {
		return new ResponseEntity<>(ledgerServices.GetLadgerByAccountId(Id), HttpStatus.OK);

	}

	@GetMapping("/name:{accountName}")
	public ResponseEntity<GenericsLedger> GetLadgerByAccountName(@PathVariable("accountName") String accountName) {
		return new ResponseEntity<>(ledgerServices.GetLadgerByAccountName(accountName), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<GenericsLedger>> GetAllLadger() {
		return new ResponseEntity<>(ledgerServices.GetAllLadger(), HttpStatus.OK);
	}

	@GetMapping("/printbyname:{accountName}")
	public ResponseEntity<byte[]> Print(@PathVariable("accountName") String accountName) throws JRException {

		JasperPrint jasperPrint = ledgerServices.PrintLadgerByName(accountName);
//		JasperExportManager.exportReportToPdfFile(jasperPrint, System.currentTimeMillis() + ".pdf");//a copy will be saved in src target directory

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

	@GetMapping("/printbyid:{Id}")
	public ResponseEntity<byte[]> PrintById(@PathVariable("Id") Long Id) throws JRException {

		JasperPrint jasperPrint = ledgerServices.PrintLadgerById(Id);
//		JasperExportManager.exportReportToPdfFile(jasperPrint, System.currentTimeMillis() + ".pdf");//a copy will be saved in src target directory

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

//
//	// Get Ledger By Id
//	@GetMapping("/{id}")
//	public ResponseEntity<Ledger> findLedgerById(@PathVariable("id") Long id) {
//		return new ResponseEntity<>(ledgerServices.findLedgerById(id), HttpStatus.OK);
//
//	}
//
//	// Update Ledger
//	@PutMapping("/update")
//	public ResponseEntity<Ledger> updateLedger(@RequestBody Ledger ledger) {
//
//		return new ResponseEntity<Ledger>(ledgerServices.updateLedger(ledger), HttpStatus.OK);
//
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteLedger(@PathVariable("id") Long id) {
//		ledgerServices.deleteLedgerByLedgerId(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//
//	}
}
