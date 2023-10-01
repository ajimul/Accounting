package com.accounting.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.dto.SMSModel;
import com.accounting.rest.services.SMS_Service;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/sms")
public class SMSController {
	private final SMS_Service sms_Service;

	@Autowired
	public SMSController(SMS_Service sms_Service) {
		super();
		this.sms_Service = sms_Service;
	}

// Send SMS
	@PostMapping("/send")
	public ResponseEntity<?> sendSMS(@RequestBody SMSModel smsModel) {
		sms_Service.sendSms(smsModel);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
