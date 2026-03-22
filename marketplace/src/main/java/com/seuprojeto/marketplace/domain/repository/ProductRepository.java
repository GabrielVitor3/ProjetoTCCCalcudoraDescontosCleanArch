package com.seuprojeto.marketplace.domain.repository;

import com.seuprojeto.marketplace.domain.model.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}