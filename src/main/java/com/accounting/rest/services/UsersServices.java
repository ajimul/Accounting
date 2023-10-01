package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.Users;
import com.accounting.rest.repository.UsersRepo;

@Service
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

	public Users add_User(Users entity) {
		Users user = new Users();
		user.setUserName("harri");
//		user.setUserName(entity.getUserName());
//		user.setPassword(passwordEncoder.encode(entity.getPassword()));
//		user.setPassword(passwordEncoder.encode("stupid420"));
		user.setPassword(passwordEncoder.encode("admin"));
		user.setRoles(entity.getRoles());
		user.setClientId(entity.getClientId());
		user.setActive(entity.isActive());
		user.setDbName(entity.getDbName());
		return usersRepo.save(user);

	}

	public Users update_User(Users entity, String userName, String password) {
		Users newEntity = usersRepo.find_userName_password(userName, passwordEncoder.encode(password)).get();
		newEntity.setUserName(entity.getUserName());
		newEntity.setClientId(entity.getClientId());
		newEntity.setDbName(entity.getDbName());
		newEntity.setPassword(passwordEncoder.encode(entity.getPassword()));
		newEntity.setActive(entity.isActive());
		newEntity.setRoles(entity.getRoles());
		return usersRepo.save(newEntity);

	}

//
////Find All User 
//	public List<GenericsUser> findAllUser() {
//		List<GenericsUser> typeUser = new ArrayList<GenericsUser>();
//		List<Users> userList = usersRepo.findAll();
//		for (Users users : userList) {
//			GenericsUser newUser = new GenericsUser();
//			newUser.setUserId(users.getUserId());
//			newUser.setUserName(users.getUserName());
//			typeUser.add(newUser);
//
//		}
//
//		return typeUser;
//
//	}
//
////Find User By Id
//	public Users findUserById(Long id) {
//		return usersRepo.findById(id).orElseThrow(() -> new UserNotFoundException(""));
//
//	}
//
////Update User
//
////Delete User By Id
//	public void deleteUserById(Long id) {
//
//		usersRepo.deleteById(id);
//
//	}

}
