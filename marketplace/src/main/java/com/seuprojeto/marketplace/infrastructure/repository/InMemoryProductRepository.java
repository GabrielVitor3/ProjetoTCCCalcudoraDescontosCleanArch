package com.seuprojeto.marketplace.infrastructure.repository;

import com.seuprojeto.marketplace.domain.model.Product;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return List.of(
                new Product("Notebook", 3000),
                new Product("Mouse", 100),
                new Product("Teclado", 200)
        );
    }
}