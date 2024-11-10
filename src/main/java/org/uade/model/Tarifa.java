package org.uade.model;

public abstract class Tarifa {
    private Double valorKwh;
    private Double iva;

    public Double getValorKwh() {
        return valorKwh;
    }

    public void setValorKwh(Double valorKwh) {
        this.valorKwh = valorKwh;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public abstract Double calcularTarifa(Double consumo);

    public Double calcularSubtotalConIva(Double consumo) {
        Double subtotal = consumo * valorKwh;
        Double iva = subtotal * this.iva / 100;
        return subtotal + iva;
    }
}
