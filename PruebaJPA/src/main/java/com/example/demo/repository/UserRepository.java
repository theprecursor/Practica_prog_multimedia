package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public List<User> findByEmail(String email);
	
}

