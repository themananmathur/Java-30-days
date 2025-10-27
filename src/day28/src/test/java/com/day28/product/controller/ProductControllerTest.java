package com.day28.product.controller;

import com.day28.product.model.Product;
import com.day28.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;        // static import for when(...)
import static org.mockito.Mockito.doNothing;  // static import for doNothing()
import static org.mockito.Mockito.verify;    // static import for verify(...)

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService service;

    @Test
    void getAll_returnsProducts() throws Exception {
        Product p1 = new Product("A", 10.0); p1.setId(1L);
        Product p2 = new Product("B", 20.0); p2.setId(2L);

        when(service.findAll()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("A"));
    }

    @Test
    void getById_found() throws Exception {
        Product p = new Product("X", 99.0); p.setId(5L);
        when(service.findById(5L)).thenReturn(Optional.of(p));

        mockMvc.perform(get("/api/products/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.name").value("X"));
    }

    @Test
    void getById_notFound() throws Exception {
        when(service.findById(100L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/products/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    void create_returnsCreated() throws Exception {
        Product toCreate = new Product("New", 12.5);
        Product saved = new Product("New", 12.5); saved.setId(11L);
        when(service.save(any(Product.class))).thenReturn(saved);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(toCreate)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/products/11"))
                .andExpect(jsonPath("$.id").value(11));
    }

    @Test
    void delete_returnsNoContent() throws Exception {
        doNothing().when(service).deleteById(3L);
        mockMvc.perform(delete("/api/products/3"))
                .andExpect(status().isNoContent());
        verify(service).deleteById(3L);
    }
}
