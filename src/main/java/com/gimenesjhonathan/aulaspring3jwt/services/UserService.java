package com.gimenesjhonathan.aulaspring3jwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gimenesjhonathan.aulaspring3jwt.entities.User;
import com.gimenesjhonathan.aulaspring3jwt.exceptions.ResourceNotFoundException;
import com.gimenesjhonathan.aulaspring3jwt.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		return repository.save(obj);
	}
}
