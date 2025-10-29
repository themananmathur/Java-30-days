package com.example.day31.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CreateEmployeeRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    private String department;
    private LocalDate joinDate;
    private String jobLocation;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    public String getJobLocation() { return jobLocation; }
    public void setJobLocation(String jobLocation) { this.jobLocation = jobLocation; }
}
