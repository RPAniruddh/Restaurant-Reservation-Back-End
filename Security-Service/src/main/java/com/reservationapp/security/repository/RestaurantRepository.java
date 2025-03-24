package com.reservationapp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservationapp.security.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	boolean existsByEmail(String email);

	Restaurant getByEmail(String email);

 	Optional<Restaurant> findByEmail(String email);

}
