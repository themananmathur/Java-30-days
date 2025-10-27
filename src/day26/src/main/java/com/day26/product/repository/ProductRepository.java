package com.day26.product.repository;

import com.day26.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // add custom queries later if needed
}
