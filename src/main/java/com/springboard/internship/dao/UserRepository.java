package com.springboard.internship.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboard.internship.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User,String> {
	User findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
}






















