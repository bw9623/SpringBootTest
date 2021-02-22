package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.repository.UserRepository;
import com.spring.boot.vo.Role;
import com.spring.boot.vo.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		// password 암호화
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		// enable 값 세팅
		user.setEnabled(true);
		// role 넣기
		Role role = new Role();
		role.setId(1l);
		user.getRoles().add(role);
		
		return userRepository.save(user);
	}
	
	
}
