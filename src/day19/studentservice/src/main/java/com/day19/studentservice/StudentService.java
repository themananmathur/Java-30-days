package com.day19.studentservice;


import java.util.Optional;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String getStudentName(int id) {
        Optional<Student> student = repository.findById(id);
        return student.map(Student::getName).orElse("Not Found");
    }
}

