package com.reservationapp.security.service;

import org.springframework.stereotype.Service;

import com.reservationapp.security.exception.DuplicateEmailException;
import com.reservationapp.security.exception.UserNotFoundException;
import com.reservationapp.security.models.Individual;
import com.reservationapp.security.repository.IndividualRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService {

	private final IndividualRepository repository;

	@Override
	public Individual addIndividual(Individual individual) {
		if (repository.existsByEmail(individual.getEmail())) {
			throw new DuplicateEmailException("Given email already exists");
		}
		return repository.save(individual);
	}

	@Override
	public void deleteIndividual(int id) {
		if (!repository.existsById(id)) {
			throw new UserNotFoundException("Individual not found with id:-" + id);
		}
		repository.deleteById(id);
	}

	@Override
	public Individual updateIndividual(Individual individualDetails) {
		Individual individual = repository.findByEmail(individualDetails.getEmail());
		individual.setName(individualDetails.getName());
		individual.setAge(individualDetails.getAge());
		individual.setPhoneNumber(individualDetails.getPhoneNumber());
		individual.setDateOfBirth(individualDetails.getDateOfBirth());
		return repository.save(individual);
	}

	@Override
	public Individual individualDetails(String email) {
		if (!repository.existsByEmail(email)) {
			throw new UserNotFoundException("Individual not found with email:-" + email);
		}
		return repository.findByEmail(email);
	}

}
