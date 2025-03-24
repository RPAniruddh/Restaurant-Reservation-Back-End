package com.reservationapp.security.service;

import java.util.List;
import java.util.Optional;

import com.reservationapp.security.models.Restaurant;

public interface RestaurantService {
	Restaurant addRestaurant(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurantDetails);

	void deleteRestaurant(int id);

	Optional<Restaurant> restaurantDetails(String email);

	List<Restaurant> getAllRestaurants();
}
