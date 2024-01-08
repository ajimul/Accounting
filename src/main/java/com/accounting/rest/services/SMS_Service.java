package com.accounting.rest.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.dto.SMSModel;
import com.accounting.rest.entity.SMS;
import com.accounting.rest.repository.AccountsRepo;
import com.accounting.rest.repository.SMSRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class SMS_Service {
	private final SMSRepo SMSrepo;
	private final AccountsRepo accountsRepo;

	@Autowired
	public SMS_Service(SMSRepo SMSrepo, AccountsRepo accountsRepo) {
		super();
		this.SMSrepo = SMSrepo;
		this.accountsRepo = accountsRepo;
	}

//	@Scheduled(cron = "0 51 19 ? * *")
//	@Scheduled(cron = "0 15 10 ? * *")
//	@PostConstruct
	public void AddTodayEmiContactListForSMS() {
//		List<EmiModel> emiModels = new ArrayList<EmiModel>();
//		emiModels = accountsRepo.getEmiForSms(LocalDate.now());
//		List<SMS> smsList = new ArrayList<SMS>();
//		for (EmiModel emiModel : emiModels) {
//			SMS sms = new SMS();
//			sms.setPartyId(emiModel.getAccountId());
//			sms.setPartyName(emiModel.getAccountName());
//			sms.setPartyDetailsId(emiModel.getPartyDetailsId());
//			sms.setPartyContactNo1(emiModel.getPartyContactNo1());
//			sms.setPartyContactNo2(emiModel.getPartyContactNo2());
//			sms.setPartyEmailId(emiModel.getPartyEmailId());
//			sms.setPartyEmiAmount(emiModel.getEmiAmount());
//			sms.setPartyEmiDate(emiModel.getEmiDate());
//			sms.setPartyEmiMessage(emiModel.getEmiMessage());
//			sms.setPartyEmiNo(emiModel.getEmiNo());
//			sms.setPartyEmiStatus(emiModel.getEmiStatus());
//			smsList.add(sms);
//		}
//		SMSrepo.truncateTable();
//		AddSMS(smsList);
	}

	public void AddSMS(List<SMS> smsList) {

		SMSrepo.saveAll(smsList);
	}

//	@PostConstruct
	public String sendSms(SMSModel smsModel) {

//		def sendSMS(apikey, numbers, sender, message):

		try {
			// Construct data
			String apiKey = "apikey=" + "MzI2YjRiMzc2ODMwNzY0NjU1NGYzOTRlNGU3ODY0Nzc=";
			String message = "&message=" + smsModel.getMessage().toString();
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + smsModel.getContactNo().toString();

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " + line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}
}
