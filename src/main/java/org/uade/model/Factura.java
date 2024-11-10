package org.uade.model;

public class Factura {
    private Integer anio;
    private Integer bimestre;
    private Usuario usuario;
    private Double consumo;
    private Double montoTotal;

    public Factura(Integer anio, Integer bimestre, Usuario usuario, Double consumo, Double montoTotal) {
        this.anio = anio;
        this.bimestre = bimestre;
        this.usuario = usuario;
        this.consumo = consumo;
        this.montoTotal = montoTotal;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getBimestre() {
        return bimestre;
    }

    public void setBimestre(Integer bimestre) {
        this.bimestre = bimestre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
