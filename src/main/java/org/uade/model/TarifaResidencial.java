package org.uade.model;

public class TarifaResidencial extends Tarifa{
    private Double contribucionesMunicipales;

    @Override
    public Double calcularTarifa(Double consumo) {
        Double subtotal = calcularSubtotalConIva(consumo);
        Double impContrib = subtotal * contribucionesMunicipales / 100;

        return subtotal + impContrib;
    }
}
