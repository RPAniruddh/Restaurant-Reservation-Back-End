package com.reservationapp.security.controller;

import java.util.List;
import java.util.Optional;

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

import com.reservationapp.security.models.Restaurant;
import com.reservationapp.security.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
	private final RestaurantService service;

	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return service.addRestaurant(restaurant);
	}

	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
		return ResponseEntity.ok(service.updateRestaurant(restaurant));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int id) {
		service.deleteRestaurant(id);
		return ResponseEntity.status(HttpStatus.OK).body("The user was deleted succefully");
	}

	@GetMapping("/getRestaurantDetails/{email}")
	public ResponseEntity<Optional<Restaurant>> getRestaurantDetails(@PathVariable String email) {
		return ResponseEntity.ok(service.restaurantDetails(email));
	}

	@GetMapping("/getAllRestaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
		return ResponseEntity.ok(service.getAllRestaurants());
	}

}
