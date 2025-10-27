package com.day28.product.service;

import com.day28.product.model.Product;
import com.day28.product.repo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;   // assertEquals, assertTrue, etc.
import static org.mockito.Mockito.*;               // when, verify, doNothing, etc.


class ProductServiceTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_shouldReturnSavedProduct() {
        Product p = new Product("S", 1.0);
        when(repo.save(p)).thenReturn(p);

        Product r = service.save(p);
        assertEquals(p, r);
        verify(repo).save(p);
    }

    @Test
    void findAll_shouldReturnList() {
        Product p = new Product("S", 1.0);
        when(repo.findAll()).thenReturn(List.of(p));
        List<Product> all = service.findAll();
        assertEquals(1, all.size());
        verify(repo).findAll();
    }

    @Test
    void findById_whenPresent() {
        Product p = new Product("S", 1.0);
        p.setId(7L);
        when(repo.findById(7L)).thenReturn(Optional.of(p));
        Optional<Product> o = service.findById(7L);
        assertTrue(o.isPresent());
        assertEquals(7L, o.get().getId());
    }

    @Test
    void deleteById_invokesRepo() {
        doNothing().when(repo).deleteById(4L);
        service.deleteById(4L);
        verify(repo).deleteById(4L);
    }
}
