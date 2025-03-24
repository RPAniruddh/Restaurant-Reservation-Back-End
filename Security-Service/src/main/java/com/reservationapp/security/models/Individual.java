package com.reservationapp.security.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
@Entity
public class Individual {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	@Column(nullable = false)
	private String name;

	@NotNull(message = "email is mandatory")
	@NotBlank(message = "email is mandatory")
	@Column(unique = true, nullable = false)
	private String email;

	@NotNull(message = "Date of birth is mandatory")
	@Past(message = "Date of birth must be a past date")
	@Column(nullable = false)
	private LocalDate dateOfBirth;

	private int age;
	private long phoneNumber;

}
