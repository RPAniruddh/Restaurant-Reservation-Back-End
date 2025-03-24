package com.reservationapp.security.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int restauanatId;

	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	@Column(nullable = false)
	private String name;

	@NotNull(message = "Email is mandatory")
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true, nullable = false)
	private String email;

	@NotNull(message = "Phone number is mandatory")
	@Column(nullable = false)
	private long phoneNumber;

	@NotNull(message = "Address is mandatory")
	@NotBlank(message = "Address is mandatory")
	@Column(nullable = false)
	private String address;

	@NotNull(message = "City is mandatory")
	@NotBlank(message = "City is mandatory")
	@Column(nullable = false)
	private String city;

	@NotNull(message = "PostalCode is mandatory")
	@Column(nullable = false)
	private int postalCode;
}
