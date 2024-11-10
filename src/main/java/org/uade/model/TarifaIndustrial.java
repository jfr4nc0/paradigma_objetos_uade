package org.uade.model;

public class TarifaIndustrial extends Tarifa {
    private Double iibb;

    public Double getIibb() {
        return iibb;
    }

    public void setIibb(Double iibb) {
        this.iibb = iibb;
    }

    @Override
    public Double calcularTarifa(Double consumo) {
        Double subtotal = calcularSubtotalConIva(consumo);
        Double impIIBB = subtotal * this.iibb / 100;

        return subtotal + impIIBB;
    }
}
