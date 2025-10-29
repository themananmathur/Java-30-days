package com.example.day31.controller;

import com.example.day31.dto.EmployeeDTO;
import com.example.day31.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // mock out the service bean the controller depends on
    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("GET /api/employees -> 200 OK (empty list)")
    void listEndpoint() throws Exception {
        // mock service to return empty list
        when(employeeService.listAll()).thenReturn(emptyList());

        mockMvc.perform(get("/api/employees")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
