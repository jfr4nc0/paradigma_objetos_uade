package org.uade.model;

public class TarifaIndustrial extends Tarifa {
    private Double iibb;

    public TarifaIndustrial(Double valorKwh, Double iva, Double iibb) {
        super(valorKwh, iva);
        this.iibb = iibb;
    }

    @Override
    public Double calcularTarifa(Double consumo) {
        Double subtotal = calcularSubtotalConIva(consumo);
        Double impIIBB = subtotal * this.iibb / 100;

        return subtotal + impIIBB;
    }
}
