package com.seuprojeto.marketplace.domain.model;

import com.seuprojeto.marketplace.domain.model.ProductCategory;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private ProductCategory category;
    private BigDecimal price;

    public Product(Long id, String name, ProductCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}