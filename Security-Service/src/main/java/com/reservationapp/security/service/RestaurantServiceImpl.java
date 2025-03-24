package com.reservationapp.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservationapp.security.exception.DuplicateEmailException;
import com.reservationapp.security.exception.UserNotFoundException;
import com.reservationapp.security.models.Restaurant;
import com.reservationapp.security.repository.RestaurantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository repository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		if (repository.existsByEmail(restaurant.getEmail())) {
			throw new DuplicateEmailException("Given email already exists");
		}
		return repository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurantDetails) {
		Restaurant restaurant = repository.getByEmail(restaurantDetails.getEmail());
		restaurant.setName(restaurantDetails.getName());
		restaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
		restaurant.setAddress(restaurantDetails.getAddress());
		restaurant.setCity(restaurantDetails.getCity());
		restaurant.setPostalCode(restaurantDetails.getPostalCode());
		return repository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int id) {
		if (!repository.existsById(id)) {
			throw new UserNotFoundException("User not found with id:-" + id);
		}
		repository.deleteById(id);

	}

	@Override
	public Optional<Restaurant> restaurantDetails(String email) {
		if (!repository.existsByEmail(email)) {
			throw new UserNotFoundException("Restaurant not found with email:-" + email);
		}
		return repository.findByEmail(email);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return repository.findAll();
	}

}
