package com.reservationapp.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reservationapp.security.dtos.LoginUserDto;
import com.reservationapp.security.dtos.RegisterUserDto;
import com.reservationapp.security.models.Credentials;
import com.reservationapp.security.repository.CredentialRepository;

@Service
public class AuthenticationService {
	private final CredentialRepository credentialRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(CredentialRepository credentialRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.credentialRepository = credentialRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Credentials signup(RegisterUserDto input) {
		Credentials user = new Credentials().setUserName(input.getUserName()).setEmail(input.getEmail())
				.setPassword(passwordEncoder.encode(input.getPassword()));

		return credentialRepository.save(user);
	}

	public Credentials authenticate(LoginUserDto input) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

		return credentialRepository.findByEmail(input.getEmail()).orElseThrow();
	}
}
