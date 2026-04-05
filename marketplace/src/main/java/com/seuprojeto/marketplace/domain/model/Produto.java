package com.seuprojeto.marketplace.domain.model;

import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private CategoriaProduto categoriaProduto;
    private BigDecimal preco;

    public Produto(Long id, String nome, CategoriaProduto categoriaProduto, BigDecimal price) {
        this.id = id;
        this.nome = nome;
        this.categoriaProduto = categoriaProduto;
        this.preco = price;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}