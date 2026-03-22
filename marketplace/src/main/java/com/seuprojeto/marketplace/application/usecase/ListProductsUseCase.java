package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.domain.model.Product;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import java.util.List;

public class ListProductsUseCase {

    private final ProductRepository repository;

    public ListProductsUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute() {
        return repository.findAll();
    }
}