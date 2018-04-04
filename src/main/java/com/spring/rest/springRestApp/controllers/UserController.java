package com.spring.rest.springRestApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.springRestApp.Repository.UserRepository;
import com.spring.rest.springRestApp.entity.User;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users")
	public User addUser( @RequestBody User user) {
	    return userRepository.save(user);
	}
	
	@RequestMapping("/users")
	public List<User> getUsers() {
				
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User userById(@PathVariable(value = "id") Long id) {
	    return userRepository.findById(id).orElseThrow(null);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody User uname) {

	    User user = userRepository.findById(id).orElseThrow(null);
	    user.setName(uname.getName());

	    User updateUser = userRepository.save(user);
	    return updateUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
	    User user = userRepository.findById(id).orElseThrow(null);
	    userRepository.delete(user);
	    return ResponseEntity.ok().build();
	}
	
}
