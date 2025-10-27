package com.day25.product.service;

import com.day25.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto create(ProductDto dto);
    List<ProductDto> listAll();
    Optional<ProductDto> getById(Long id);
    Optional<ProductDto> update(Long id, ProductDto dto);
    boolean delete(Long id);
}
