package com.java30days.day23.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {
    private Integer id;
    private String name;
    private String role;
    private BigDecimal salary;
    private LocalDateTime joinedAt;

    public Employee() {}

    public Employee(Integer id, String name, String role, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public Employee(String name, String role, BigDecimal salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
