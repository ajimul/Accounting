package com.accounting.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.entity.Users;
import com.accounting.rest.services.UsersServices;

@RestController
//@CrossOrigin(origins = "https://spotsolution.store")
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UsersServices usersServices;

	// Add User
	@PostMapping("/add")
	public ResponseEntity<String> add_User(@RequestBody Users users) {
		return new ResponseEntity<>(usersServices.createOrUpdateUser(users), HttpStatus.CREATED);
	}

}
