package com.accounting.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.services.JournalServices;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/journal")
public class JournalController {
	private final JournalServices journalServices;

	@Autowired
	public JournalController(JournalServices journalServices) {
		this.journalServices = journalServices;
	}

	@GetMapping("/bookof:{bookName}")
	public ResponseEntity<byte[]> Print(@PathVariable("bookName") String bookName) throws JRException {

		JasperPrint jasperPrint = journalServices.GetJournalByBookName(bookName);

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

//		JasperExportManager.exportReportToPdfFile(jasperPrint, System.currentTimeMillis() + ".pdf");//a copy will be saved in src target directory

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

//	@GetMapping("/printbyid:{Id}")
//	public ResponseEntity<byte[]> PrintById(@PathVariable("Id") Long Id) throws JRException {
//
//		JasperPrint jasperPrint = ledgerServices.PrintLadgerById(Id);
////		JasperExportManager.exportReportToPdfFile(jasperPrint, System.currentTimeMillis() + ".pdf");//a copy will be saved in src target directory
//
//		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);
//
//		System.err.println(data);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
//
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
//	}

}
