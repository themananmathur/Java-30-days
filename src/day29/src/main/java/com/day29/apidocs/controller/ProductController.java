package com.day29.apidocs.controller;

import com.day29.apidocs.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    private final Map<Long, Product> store = new LinkedHashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @PostConstruct
    public void init() {
        // seed some sample data
        save(new Product(null, "Laptop", 79999.0));
        save(new Product(null, "Headphones", 1999.0));
    }

    private Product save(Product p) {
        long id = idGen.getAndIncrement();
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @GetMapping
    public List<Product> all() {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product p = store.get(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = save(product);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId()))
                .body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Product removed = store.remove(id);
        if (removed == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
