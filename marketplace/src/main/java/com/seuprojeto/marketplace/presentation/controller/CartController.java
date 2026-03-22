package com.seuprojeto.marketplace.presentation.controller;

import com.seuprojeto.marketplace.application.dto.CartRequest;
import com.seuprojeto.marketplace.application.usecase.CalculateCartUseCase;
import com.seuprojeto.marketplace.domain.model.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CalculateCartUseCase useCase;

    public CartController(CalculateCartUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/calculate")
    public CartSummary calculate(@RequestBody CartRequest request) {

        List<CartItem> items = request.getItems().stream()
                .map(i -> new CartItem(
                        new Product(i.name, i.price),
                        i.quantity
                ))
                .collect(Collectors.toList());

        return useCase.execute(items);
    }
}