package com.example.day31.service;

import com.example.day31.dto.CreateEmployeeRequest;
import com.example.day31.entity.Employee;
import com.example.day31.mapper.EmployeeMapper;
import com.example.day31.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    @Test
    void createEmployee() {
        EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
        EmployeeMapper mapper = new EmployeeMapper();
        when(repo.save(any(Employee.class))).thenAnswer(i -> {
            Employee e = (Employee) i.getArgument(0);
            e.setId(1L);
            return e;
        });

        EmployeeService svc = new EmployeeService(repo, mapper);
        CreateEmployeeRequest req = new CreateEmployeeRequest();
        req.setFirstName("Test");
        req.setLastName("User");
        req.setEmail("test.user@example.com");
        req.setJoinDate(LocalDate.now());

        var dto = svc.create(req);
        assertNotNull(dto.id());
        assertEquals("Test", dto.firstName());
    }
}
