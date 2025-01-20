package com.example.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StudentDto {

    private Long id;
    @NotEmpty(message = "Student First Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Student Last Name should not be empty")
    private String lastName;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Student Phone Number should not be empty")
    private String phoneNumber;
    @NotEmpty(message = "Student Email should not be empty")
    @Email
    private String email;

    public StudentDto(Long id, String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public StudentDto() {
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
