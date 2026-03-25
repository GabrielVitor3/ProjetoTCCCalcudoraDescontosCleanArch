package com.seuprojeto.marketplace.infrastructure.repository;

import com.seuprojeto.marketplace.domain.model.Product;
import com.seuprojeto.marketplace.domain.model.ProductCategory;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = List.of(
            new Product(1L, "Capinha Premium", ProductCategory.CAPINHA, new BigDecimal("50.00")),
            new Product(2L, "Carregador Turbo 30W", ProductCategory.CARREGADOR, new BigDecimal("100.00")),
            new Product(3L, "Fone Bluetooth AirSound", ProductCategory.FONE, new BigDecimal("200.00")),
            new Product(4L, "Película 3D", ProductCategory.PELICULA, new BigDecimal("30.00")),
            new Product(5L, "Suporte Veicular Magnético", ProductCategory.SUPORTE, new BigDecimal("80.00"))
    );

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}