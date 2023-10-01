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
	private final UsersServices usersServices;

	@Autowired
	public UserController(UsersServices usersServices) {
		this.usersServices = usersServices;
	}

//	@GetMapping("/")
//	public ResponseEntity<List<Users>> getUser() {
//		return new ResponseEntity<>(usersServices.getUser(), HttpStatus.OK);
//
//	}

	// Add User
	@PostMapping("/add")
	public ResponseEntity<Users> add_User(@RequestBody Users users) {
		return new ResponseEntity<>(usersServices.add_User(users), HttpStatus.CREATED);

	}

	// Update User
//	@PutMapping("/update/{userName}/{password}")
//	public ResponseEntity<Users> updateUser(@RequestBody Users users, String userName, String password) {
//
//		return new ResponseEntity<Users>(usersServices.update_User(users, userName, password), HttpStatus.OK);
//
//	}

}
