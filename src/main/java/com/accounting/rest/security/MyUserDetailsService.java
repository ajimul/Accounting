package com.accounting.rest.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.Users;
import com.accounting.rest.repository.UsersRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UsersRepo userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + userName));
		return user.map(MyUserDetails::new).get();

	}
}