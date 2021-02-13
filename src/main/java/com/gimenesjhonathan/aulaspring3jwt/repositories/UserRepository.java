package com.gimenesjhonathan.aulaspring3jwt.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimenesjhonathan.aulaspring3jwt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional
	User findByEmail(String email);

}
