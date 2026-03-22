package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.domain.model.CartItem;
import com.seuprojeto.marketplace.domain.model.CartSummary;
import com.seuprojeto.marketplace.domain.model.Product;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CalculateCartUseCaseTest {

    private ProductRepository repository;
    private CalculateCartUseCase useCase;

    @BeforeEach
    void setup() {
        repository = mock(ProductRepository.class);
        useCase = new CalculateCartUseCase(repository);
    }

    @Test
    void shouldCalculateTotalWithoutDiscount() {
        Product product = new Product("Produto A", 50.0);
        CartItem item = new CartItem(product, 2); // 100

        CartSummary result = useCase.execute(List.of(item));

        assertEquals(100.0, result.getTotal());
        assertEquals(0.0, result.getDiscount());
        assertEquals(100.0, result.getFinalTotal());
    }

    @Test
    void shouldApplyFivePercentDiscount() {
        Product product = new Product("Produto A", 60.0);
        CartItem item = new CartItem(product, 2); // 120

        CartSummary result = useCase.execute(List.of(item));

        assertEquals(120.0, result.getTotal());
        assertEquals(6.0, result.getDiscount()); // 5%
        assertEquals(114.0, result.getFinalTotal());
    }

    @Test
    void shouldApplyTenPercentDiscount() {
        Product product = new Product ("Produto A", 150.0);
        CartItem item = new CartItem(product, 2); // 300

        CartSummary result = useCase.execute(List.of(item));

        assertEquals(300.0, result.getTotal());
        assertEquals(30.0, result.getDiscount()); // 10%
        assertEquals(270.0, result.getFinalTotal());
    }

    @Test
    void shouldHandleMultipleItems() {
        Product p1 = new Product("Produto A", 50.0);
        Product p2 = new Product( "Produto B", 30.0);

        CartItem item1 = new CartItem(p1, 2); // 100
        CartItem item2 = new CartItem(p2, 2); // 60

        CartSummary result = useCase.execute(List.of(item1, item2));

        assertEquals(160.0, result.getTotal());
        assertEquals(8.0, result.getDiscount()); // 5%
        assertEquals(152.0, result.getFinalTotal());
    }

    @Test
    void shouldReturnZeroWhenCartIsEmpty() {
        CartSummary result = useCase.execute(List.of());

        assertEquals(0.0, result.getTotal());
        assertEquals(0.0, result.getDiscount());
        assertEquals(0.0, result.getFinalTotal());
    }
}