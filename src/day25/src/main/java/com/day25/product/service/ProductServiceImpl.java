package com.day25.product.service;

import com.day25.product.dto.ProductDto;
import com.day25.product.entity.Product;
import com.day25.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    private ProductDto toDto(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }

    private Product toEntity(ProductDto dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        return p;
    }

    @Override
    public ProductDto create(ProductDto dto) {
        Product p = toEntity(dto);
        Product saved = repo.save(p);
        return toDto(saved);
    }

    @Override
    public List<ProductDto> listAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getById(Long id) {
        return repo.findById(id).map(this::toDto);
    }

    @Override
    public Optional<ProductDto> update(Long id, ProductDto dto) {
        return repo.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setPrice(dto.getPrice());
            Product saved = repo.save(existing);
            return toDto(saved);
        });
    }

    @Override
    public boolean delete(Long id) {
        return repo.findById(id).map(p -> {
            repo.deleteById(id);
            return true;
        }).orElse(false);
    }
}
