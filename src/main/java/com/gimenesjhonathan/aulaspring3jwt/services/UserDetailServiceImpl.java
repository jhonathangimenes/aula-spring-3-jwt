package com.gimenesjhonathan.aulaspring3jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gimenesjhonathan.aulaspring3jwt.entities.User;
import com.gimenesjhonathan.aulaspring3jwt.repositories.UserRepository;
import com.gimenesjhonathan.aulaspring3jwt.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = repository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getPerfis());
	}

}
