package com.example.day31.controller;

import com.example.day31.dto.CreateEmployeeRequest;
import com.example.day31.dto.EmployeeDTO;
import com.example.day31.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody CreateEmployeeRequest req) {
        EmployeeDTO dto = service.create(req);
        return ResponseEntity.created(URI.create("/api/employees/" + dto.id())).body(dto);
    }

    @GetMapping
    public List<EmployeeDTO> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Long id, @Valid @RequestBody CreateEmployeeRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
