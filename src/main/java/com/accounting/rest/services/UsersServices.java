package com.accounting.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.Users;
import com.accounting.rest.repository.UsersRepo;


@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class UsersServices {

	private final UsersRepo usersRepo;

	@Autowired
	public UsersServices(UsersRepo usersRepo) {
		this.usersRepo = usersRepo;
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<Users> getUser() {
		return usersRepo.findAll();

	}
	public String createOrUpdateUser(Users user) {
		Optional<Users> existingUser = usersRepo.findBy_UserName(user.getUserName());
		if (existingUser.isPresent()) {
			// Update existing user
			Users updatedUser = existingUser.get();
			Users newUser = new Users();
			newUser.setUserId(updatedUser.getUserId());
			newUser.setUserName(user.getUserName());
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			newUser.setRoles(user.getRoles());
			newUser.setClientId(user.getClientId());
			newUser.setActive(user.isActive());
			newUser.setDbName(user.getDbName());

			usersRepo.save(newUser);
			return "User Update Success!\nUser:" + newUser.getUserName() + ",\nStatus:"
					+ (newUser.isActive() ? "Active" : "Inactive");
		} else {
			// Create a new user if not exists
			usersRepo.save(user);
			return "User Create Success!\nUser: " + user.getUserName() + ",\nStatus: "
					+ (user.isActive() ? "Active" : "Inactive");

		}
	}

}
