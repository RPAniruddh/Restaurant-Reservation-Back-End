package com.reservationapp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservationapp.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	User findByEmail(String email);

}
