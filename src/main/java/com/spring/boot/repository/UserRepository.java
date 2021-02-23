package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.vo.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
