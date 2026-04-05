package com.seuprojeto.marketplace.application.dto;

import lombok.Getter;

@Getter
public class SelecaoCarrinho {

    private Long idProduto;
    private int quantidade;

    public SelecaoCarrinho(Long idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
}