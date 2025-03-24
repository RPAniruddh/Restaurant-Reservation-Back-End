package com.reservationapp.security.service;

import org.springframework.stereotype.Service;

import com.reservationapp.security.exception.DuplicateEmailException;
import com.reservationapp.security.exception.UserNotFoundException;
import com.reservationapp.security.models.User;
import com.reservationapp.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public User addUser(User user) {
		if (repository.existsByEmail(user.getEmail())) {
			throw new DuplicateEmailException("Given email already exists");
		}
		return repository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		if (!repository.existsById(id)) {
			throw new UserNotFoundException("User not found with id:-" + id);
		}
		repository.deleteById(id);
	}

	@Override
	public User updateUser(User userDetails) {
		User user = repository.findByEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setAge(userDetails.getAge());
		user.setPhoneNumber(userDetails.getPhoneNumber());
		user.setDateOfBirth(userDetails.getDateOfBirth());
		return repository.save(user);
	}

	@Override
	public User userDetails(String email) {
		if (!repository.existsByEmail(email)) {
			throw new UserNotFoundException("User not found with email:-" + email);
		}
		return repository.findByEmail(email);
	}

}
