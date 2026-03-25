package com.seuprojeto.marketplace.presentation.controller;

import com.seuprojeto.marketplace.application.dto.CartSelection;
import com.seuprojeto.marketplace.application.usecase.CalculateCartUseCase;
import com.seuprojeto.marketplace.domain.model.*;

import com.seuprojeto.marketplace.domain.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CalculateCartUseCase useCase;

    public CartController(ProductRepository repository) {
        this.useCase = new CalculateCartUseCase(repository);
    }

    @PostMapping
    public CartSummary calculate(@RequestBody List<CartSelection> selections) {
        return useCase.execute(selections);
    }
}