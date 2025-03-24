package com.reservationapp.security.service;

import com.reservationapp.security.models.Individual;

public interface IndividualService {
	Individual addIndividual(Individual individual);

	void deleteIndividual(int id);
	
	Individual updateIndividual(Individual individual);

	Individual individualDetails(String email);
}
