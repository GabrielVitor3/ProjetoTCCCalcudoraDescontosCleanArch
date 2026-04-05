package com.seuprojeto.marketplace.application.dto;

public class SelecaoCarrinho {

    private Long idProduto;
    private Integer quantidade;

    public SelecaoCarrinho() {
    }

    public SelecaoCarrinho(Long idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}