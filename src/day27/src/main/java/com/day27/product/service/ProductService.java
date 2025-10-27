package com.day27.product.service;

import com.day27.product.dto.ProductRequest;
import com.day27.product.dto.ProductResponse;
import com.day27.product.exception.NotFoundException;
import com.day27.product.model.Product;
import com.day27.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) { this.repo = repo; }

    public ProductResponse create(ProductRequest req) {
        if (repo.existsBySku(req.getSku())) {
            throw new IllegalArgumentException("SKU already exists: " + req.getSku());
        }
        Product p = new Product(req.getSku(), req.getName(), req.getDescription(), req.getPrice());
        p = repo.save(p);
        return toResponse(p);
    }

    public List<ProductResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getById(Long id) {
        Product p = repo.findById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return toResponse(p);
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product p = repo.findById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        // check sku conflict (if changing sku)
        if (!p.getSku().equals(req.getSku()) && repo.existsBySku(req.getSku())) {
            throw new IllegalArgumentException("SKU already exists: " + req.getSku());
        }
        p.setSku(req.getSku());
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p = repo.save(p);
        return toResponse(p);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Product not found with id: " + id);
        repo.deleteById(id);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(p.getId(), p.getSku(), p.getName(), p.getDescription(), p.getPrice());
    }
}
