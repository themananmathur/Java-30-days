package com.example.day31.mapper;

import com.example.day31.dto.EmployeeDTO;
import com.example.day31.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDto(Employee e) {
        if (e == null) return null;
        return new EmployeeDTO(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getDepartment(),
                e.getJobLocation()
        );
    }
}
