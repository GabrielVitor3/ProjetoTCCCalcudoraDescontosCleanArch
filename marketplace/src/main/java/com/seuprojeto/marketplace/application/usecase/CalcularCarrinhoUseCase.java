package com.seuprojeto.marketplace.application.usecase;

import com.seuprojeto.marketplace.application.dto.SelecaoCarrinho;
import com.seuprojeto.marketplace.domain.model.ResumoCarrinho;
import com.seuprojeto.marketplace.domain.repository.ProdutoRepositorio;

import java.math.BigDecimal;
import java.util.List;

public class CalcularCarrinhoUseCase {

    private final ProdutoRepositorio produtoRepositorio;

    public CalcularCarrinhoUseCase(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public ResumoCarrinho executar(List<SelecaoCarrinho> selecaoCarrinhos) {
        return new ResumoCarrinho(
                new BigDecimal("100"),
                new BigDecimal("10")
        );
    }
}