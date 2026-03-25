package com.seuprojeto.marketplace.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartSummary {

    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal total;

    public CartSummary(BigDecimal subtotal, BigDecimal discount) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.total = subtotal.subtract(discount);
    }
}