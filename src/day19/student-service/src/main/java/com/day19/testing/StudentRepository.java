package com.day19.testing;


import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);
}
