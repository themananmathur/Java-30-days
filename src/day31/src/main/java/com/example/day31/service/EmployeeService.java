package com.example.day31.service;

import com.example.day31.dto.CreateEmployeeRequest;
import com.example.day31.dto.EmployeeDTO;
import com.example.day31.entity.Employee;
import com.example.day31.exception.ResourceNotFoundException;
import com.example.day31.mapper.EmployeeMapper;
import com.example.day31.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeDTO create(CreateEmployeeRequest req) {
        Employee e = new Employee();
        e.setFirstName(req.getFirstName());
        e.setLastName(req.getLastName());
        e.setEmail(req.getEmail());
        e.setDepartment(req.getDepartment());
        e.setJoinDate(req.getJoinDate());
        e.setJobLocation(req.getJobLocation());
        repository.save(e);
        return mapper.toDto(e);
    }

    public EmployeeDTO getById(Long id) {
        Employee e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return mapper.toDto(e);
    }

    public List<EmployeeDTO> listAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public EmployeeDTO update(Long id, CreateEmployeeRequest req) {
        Employee e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        e.setFirstName(req.getFirstName());
        e.setLastName(req.getLastName());
        e.setDepartment(req.getDepartment());
        e.setJoinDate(req.getJoinDate());
        e.setJobLocation(req.getJobLocation());
        repository.save(e);
        return mapper.toDto(e);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Employee not found with id: " + id);
        repository.deleteById(id);
    }
}
