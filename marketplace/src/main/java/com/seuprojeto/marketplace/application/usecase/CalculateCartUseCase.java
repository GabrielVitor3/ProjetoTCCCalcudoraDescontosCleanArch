package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.domain.model.*;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import java.util.List;

public class CalculateCartUseCase {

    private final ProductRepository repository;

    public CalculateCartUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public CartSummary execute(List<CartItem> items) {

        double total = 0;

        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        double discount = calculateDiscount(total);

        return new CartSummary(total, discount, total - discount);
    }

    private double calculateDiscount(double total) {
        if (total > 200) return total * 0.10;
        if (total > 100) return total * 0.05;
        return 0;
    }
}