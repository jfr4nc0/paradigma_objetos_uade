package org.uade.model;

import java.util.Date;

public class Medicion {
    private Date fechaLectura;
    private Integer anio;
    private Integer bimestre;
    private Double lectura;

    public Medicion(Date fechaLectura, Integer anio, Integer bimestre, Double lectura) {
        this.fechaLectura = fechaLectura;
        this.anio = anio;
        this.bimestre = bimestre;
        this.lectura = lectura;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getBimestre() {
        return bimestre;
    }

    public Double getLectura() {
        return lectura;
    }
}
