package com.day25.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductDto {
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotNull @Positive
    private BigDecimal price;

    public ProductDto() {}

    public ProductDto(Long id, String name, String description, BigDecimal price) {
        this.id = id; this.name = name; this.description = description; this.price = price;
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
