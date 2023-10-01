package com.accounting.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.report.DataBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/subreport")
public class SubReportController {
	@GetMapping("/")
	public ResponseEntity<byte[]> Print() throws JRException {
		String masterReportFileName = "src/main/resources/Ledger.jrxml";
		String subreport = "src/main/resources/";
		ArrayList<DataBean> dataList = new ArrayList<DataBean>();
		DataBean data1 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data2 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data3 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data4 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data5 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data6 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data7 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data8 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data9 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data10 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data11 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data12 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data13 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data14 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data15 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data16 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data17 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data18 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data19 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data20 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data21 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data22 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data23 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data24 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data25 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data26 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data27 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data28 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data29 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data30 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data31 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data32 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data33 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data34 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data35 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data36 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data37 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data38 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data39 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data40 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data41 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data42 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data43 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data44 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data45 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data46 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data47 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data48 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data49 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data50 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data51 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data52 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data53 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data54 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data55 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data56 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data57 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);
		DataBean data58 = new DataBean("Ajimul", "AccountType", "Date", 1000l, 1000l, 100l);

		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);
		dataList.add(data4);
		dataList.add(data5);
		dataList.add(data6);
		dataList.add(data7);
		dataList.add(data8);
		dataList.add(data9);
		dataList.add(data10);
		dataList.add(data11);
		dataList.add(data12);
		dataList.add(data13);
		dataList.add(data14);
		dataList.add(data15);
		dataList.add(data16);
		dataList.add(data17);
		dataList.add(data18);
		dataList.add(data19);
		dataList.add(data20);
		dataList.add(data21);
		dataList.add(data22);
		dataList.add(data23);
		dataList.add(data24);
		dataList.add(data25);
		dataList.add(data26);
		dataList.add(data27);
		dataList.add(data28);
		dataList.add(data29);
		dataList.add(data30);
		dataList.add(data31);
		dataList.add(data32);
		dataList.add(data33);
		dataList.add(data34);
		dataList.add(data35);
		dataList.add(data36);
		dataList.add(data37);
		dataList.add(data38);
		dataList.add(data39);
		dataList.add(data40);
		dataList.add(data41);
		dataList.add(data42);
		dataList.add(data43);
		dataList.add(data44);
		dataList.add(data45);
		dataList.add(data46);
		dataList.add(data47);
		dataList.add(data48);
		dataList.add(data49);
		dataList.add(data50);
		dataList.add(data51);
		dataList.add(data52);
		dataList.add(data53);
		dataList.add(data54);
		dataList.add(data55);
		dataList.add(data56);
		dataList.add(data57);
		dataList.add(data58);

		JRBeanCollectionDataSource subReportBeanList = new JRBeanCollectionDataSource(dataList);
		JasperPrint jasperPrint = new JasperPrint();

		try {
			JasperReport compailReport = JasperCompileManager.compileReport(masterReportFileName);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("bookOf", "bookOf");
			parameters.put("narration", "narration");
			parameters.put("SUBREPORT_DIR", subreport);
			parameters.put("listParam", subReportBeanList);
			jasperPrint = JasperFillManager.fillReport(compailReport, parameters, subReportBeanList);

		} catch (JRException e) {
			System.out.println(e);

			e.printStackTrace();
		}

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}
