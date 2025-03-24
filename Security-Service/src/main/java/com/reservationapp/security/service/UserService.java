package com.reservationapp.security.service;

import com.reservationapp.security.models.User;

public interface UserService {
	User addUser(User user);

	void deleteUser(int id);
	
	User updateUser(User user);

	User userDetails(String email);
}
