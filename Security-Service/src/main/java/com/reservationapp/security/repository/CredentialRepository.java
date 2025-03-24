package com.reservationapp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservationapp.security.models.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials, Integer> {
    Optional<Credentials> findByEmail(String email);

}
