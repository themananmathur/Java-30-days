package com.day19.studentservice;


import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);
}

