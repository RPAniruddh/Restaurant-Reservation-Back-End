package com.reservationapp.security.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservationapp.security.models.Credentials;
import com.reservationapp.security.service.CredentialService;

@RequestMapping("/users")
@RestController
public class CredentialsController {
	private final CredentialService service ;

    public CredentialsController(CredentialService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public ResponseEntity<Credentials> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Credentials currentUser = (Credentials) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<Credentials>> allUsers() {
        List <Credentials> users = service.allUsers();

        return ResponseEntity.ok(users);
    }
}
