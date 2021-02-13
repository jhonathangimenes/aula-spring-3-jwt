package com.gimenesjhonathan.aulaspring3jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimenesjhonathan.aulaspring3jwt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
