package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.repository.UserRepository;
import com.spring.boot.vo.Board;
import com.spring.boot.vo.User;

@RestController
@RequestMapping("/api")
public class UserApiController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/user")
	public List<User> all(){
		return repository.findAll();
	}
	
	@PostMapping("/user")
	public User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}
	
	@GetMapping("/user/{id}")
	public User one(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@PutMapping("/user/{id}")
	public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
		return repository.findById(id)
				.map(user -> {
//					user.setBoards(newUser.getBoards());
					user.getBoards().clear();
					user.getBoards().addAll(newUser.getBoards());
					for(Board board : user.getBoards()) {
						board.setUser(user);
					}
					return repository.save(user);
				})
				.orElseGet(() -> {
					newUser.setId(id);
					return repository.save(newUser);
				});
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
