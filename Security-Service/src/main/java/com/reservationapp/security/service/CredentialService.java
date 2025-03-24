package com.reservationapp.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationapp.security.models.Credentials;
import com.reservationapp.security.repository.CredentialRepository;

@Service
public class CredentialService {
    private final CredentialRepository repository;

    public CredentialService(CredentialRepository repository) {
        this.repository = repository;
    }

    public List<Credentials> allUsers() {
        List<Credentials> users = new ArrayList<>();

        repository.findAll().forEach(users::add);

        return users;
    }
}
