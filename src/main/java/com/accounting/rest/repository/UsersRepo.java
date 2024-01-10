package com.accounting.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

	@Query("select u from Users u where u.userId = :userId")
	Users GetUserNameById(@Param("userId") Long userId);

@Query("select u from Users u where u.userName = :userName")
	Optional<Users> findBy_UserName(@Param("userName") String userName);

	Users findByUserName(String userName);

	@Query("select u from Users u where u.userName = :userName and u.password = :password")
	Optional<Users> find_userName_password(@Param("userName") String userName, @Param("password") String password);


}
