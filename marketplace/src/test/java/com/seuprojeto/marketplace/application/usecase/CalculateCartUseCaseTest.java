package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.application.dto.CartSelection;
import com.seuprojeto.marketplace.domain.model.Product;
import com.seuprojeto.marketplace.domain.model.ProductCategory;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculateCartUseCaseTest {

    private CalculateCartUseCase useCase;

    @BeforeEach
    void setup() {
        useCase = new CalculateCartUseCase(new FakeProductRepository());
    }
    @Test
    void shouldReturnNoDiscountWhenSingleItem() {

        List<CartSelection> input = List.of(
                new CartSelection(1L, 1)
        );

        var result = useCase.execute(input);

        assertEquals(0, result.getDiscount().compareTo(BigDecimal.ZERO));
        assertEquals(result.getSubtotal(), result.getTotal());
    }

    @Test
    void shouldApplyQuantityDiscount() {

        List<CartSelection> input = List.of(
                new CartSelection(1L, 2) // 2 itens → 5%
        );

        var result = useCase.execute(input);

        assertTrue(result.getDiscount().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void shouldApplyCategoryDiscount() {

        List<CartSelection> input = List.of(
                new CartSelection(2L, 1) // CARREGADOR → 10%
        );

        var result = useCase.execute(input);

        assertTrue(result.getDiscount().compareTo(BigDecimal.ZERO) > 0);
    }

    // ================================
    // TESTE 4 - Descontos cumulativos
    // ================================
    @Test
    void shouldApplyCumulativeDiscounts() {

        List<CartSelection> input = List.of(
                new CartSelection(1L, 2), // CAPINHA
                new CartSelection(2L, 2)  // CARREGADOR
        );

        var result = useCase.execute(input);

        assertTrue(result.getDiscount().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void shouldNotExceedMaxDiscountLimit() {

        List<CartSelection> input = List.of(
                new CartSelection(2L, 10) // força desconto alto
        );

        var result = useCase.execute(input);

        BigDecimal maxAllowed = result.getSubtotal().multiply(new BigDecimal("0.25"));

        assertTrue(result.getDiscount().compareTo(maxAllowed) <= 0);
    }

    // ================================
    // TESTE 6 - Total correto
    // ================================
    @Test
    void shouldCalculateTotalCorrectly() {

        List<CartSelection> input = List.of(
                new CartSelection(3L, 1) // FONE
        );

        var result = useCase.execute(input);

        BigDecimal expectedTotal = result.getSubtotal().subtract(result.getDiscount());

        assertEquals(0, expectedTotal.compareTo(result.getTotal()));
    }

    static class FakeProductRepository implements ProductRepository {

        private final List<Product> products = List.of(
                new Product(1L, "Capinha", ProductCategory.CAPINHA, new BigDecimal("50")),
                new Product(2L, "Carregador", ProductCategory.CARREGADOR, new BigDecimal("100")),
                new Product(3L, "Fone", ProductCategory.FONE, new BigDecimal("200")),
                new Product(4L, "Película", ProductCategory.PELICULA, new BigDecimal("30")),
                new Product(5L, "Suporte", ProductCategory.SUPORTE, new BigDecimal("80"))
        );

        @Override
        public List<Product> findAll() {
            return products;
        }

        @Override
        public Optional<Product> findById(Long id) {
            return products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
        }
    }
}