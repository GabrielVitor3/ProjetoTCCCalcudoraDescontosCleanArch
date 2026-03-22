package com.seuprojeto.marketplace.domain.model;

public class CartSummary {

    private final double total;
    private final double discount;
    private final double finalTotal;

    public CartSummary(double total, double discount, double finalTotal) {
        this.total = total;
        this.discount = discount;
        this.finalTotal = finalTotal;
    }

    public double getTotal() {
        return total;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalTotal() {
        return finalTotal;
    }
}