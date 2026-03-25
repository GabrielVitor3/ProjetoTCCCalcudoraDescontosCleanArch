package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.application.dto.CartSelection;
import com.seuprojeto.marketplace.domain.model.CartSummary;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class CalculateCartUseCase {

    private final ProductRepository productRepository;

    public CalculateCartUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CartSummary execute(List<CartSelection> selections) {
        return new CartSummary(
                new BigDecimal("100"),
                new BigDecimal("10")
        );
    }
}