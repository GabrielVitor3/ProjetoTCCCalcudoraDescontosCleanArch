package com.seuprojeto.marketplace.domain.repository;

import com.seuprojeto.marketplace.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositorio {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
}