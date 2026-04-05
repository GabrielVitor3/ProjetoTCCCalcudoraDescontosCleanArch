package com.seuprojeto.marketplace.presentation.controller;

import com.seuprojeto.marketplace.application.dto.SelecaoCarrinho;
import com.seuprojeto.marketplace.application.usecase.CalcularCarrinhoUseCase;
import com.seuprojeto.marketplace.domain.model.*;

import com.seuprojeto.marketplace.domain.repository.ProdutoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CarrinhoController {

    private final CalcularCarrinhoUseCase useCase;

    public CarrinhoController(ProdutoRepositorio repository) {
        this.useCase = new CalcularCarrinhoUseCase(repository);
    }

    @PostMapping
    public ResumoCarrinho calculate(@RequestBody List<SelecaoCarrinho> selections) {
        return useCase.execute(selections);
    }
}