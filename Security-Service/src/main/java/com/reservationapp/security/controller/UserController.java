package com.reservationapp.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservationapp.security.models.User;
import com.reservationapp.security.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.ok(service.addUser(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return ResponseEntity.ok(service.updateUser(user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body("The user was deleted succefully");
	}
	
	@GetMapping("/getUserDetails/{email}")
	public ResponseEntity<User> getUserDetails(@PathVariable String email){
		return ResponseEntity.ok(service.userDetails(email));
	}
}
