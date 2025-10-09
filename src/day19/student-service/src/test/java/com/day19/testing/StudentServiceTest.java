package com.day19.testing;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testGetStudentName_Found() {
        StudentRepository mockRepo = Mockito.mock(StudentRepository.class);
        Mockito.when(mockRepo.findById(1))
               .thenReturn(Optional.of(new Student(1, "Manan")));

        StudentService service = new StudentService(mockRepo);
        String result = service.getStudentName(1);
        System.out.println("[TEST] Found student name: " + result);
        assertEquals("Manan", result);
    }

    @Test
    void testGetStudentName_NotFound() {
        StudentRepository mockRepo = Mockito.mock(StudentRepository.class);
        Mockito.when(mockRepo.findById(2)).thenReturn(Optional.empty());

        StudentService service = new StudentService(mockRepo);
        String result = service.getStudentName(2);
        System.out.println("[TEST] Student not found, got: " + result);
        assertEquals("Not Found", result);
    }
}