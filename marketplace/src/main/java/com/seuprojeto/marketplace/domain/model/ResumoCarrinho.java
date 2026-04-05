package com.seuprojeto.marketplace.domain.model;

import java.math.BigDecimal;

public class ResumoCarrinho {

    private BigDecimal subtotal;
    private BigDecimal desconto;
    private BigDecimal total;

    public ResumoCarrinho(BigDecimal subtotal, BigDecimal desconto) {
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = subtotal.subtract(desconto);
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        atualizarTotal();
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
        atualizarTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }

    private void atualizarTotal() {
        if (subtotal != null && desconto != null) {
            this.total = subtotal.subtract(desconto);
        }
    }
}