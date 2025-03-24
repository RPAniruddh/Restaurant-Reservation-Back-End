package com.reservationapp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservationapp.security.models.Individual;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {

	boolean existsByEmail(String email);

	Individual findByEmail(String email);

}
