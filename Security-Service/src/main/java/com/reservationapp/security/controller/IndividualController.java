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

import com.reservationapp.security.models.Individual;
import com.reservationapp.security.service.IndividualService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/individual")
@RequiredArgsConstructor
public class IndividualController {
	private final IndividualService service;
	
	@PostMapping("/add")
	public ResponseEntity<Individual> addIndividual(@RequestBody Individual user) {
		return ResponseEntity.ok(service.addIndividual(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Individual> updateIndividual(@RequestBody Individual user){
		return ResponseEntity.ok(service.updateIndividual(user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteIndividual(@PathVariable int id) {
		service.deleteIndividual(id);
		return ResponseEntity.status(HttpStatus.OK).body("The user was deleted succefully");
	}
	
	@GetMapping("/getIndividualDetails/{email}")
	public ResponseEntity<Individual> getIndividualDetails(@PathVariable String email){
		return ResponseEntity.ok(service.individualDetails(email));
	}
}
