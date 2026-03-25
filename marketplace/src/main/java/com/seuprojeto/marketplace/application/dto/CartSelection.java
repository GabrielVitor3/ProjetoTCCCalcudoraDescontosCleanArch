package com.seuprojeto.marketplace.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class CartSelection {

    private Long productId;
    private int quantity;

    public CartSelection(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}