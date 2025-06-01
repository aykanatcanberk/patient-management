package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PatientRequestDTO {

    @NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Name cannot be more that 100 characters.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required.")
    private String address;

    @NotBlank(message = "Birth date is required.")
    private String birthDate;

    @NotNull(message = "Register date is required.")
    private String registeredDate;
}
