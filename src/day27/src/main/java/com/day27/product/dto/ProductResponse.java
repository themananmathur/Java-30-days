package com.day27.product.dto;

public class ProductResponse {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;

    public ProductResponse() {}

    public ProductResponse(Long id, String sku, String name, String description, Double price) {
        this.id = id; this.sku = sku; this.name = name; this.description = description; this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
