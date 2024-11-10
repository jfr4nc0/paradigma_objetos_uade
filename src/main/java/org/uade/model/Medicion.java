package org.uade.model;

import java.util.Date;

public class Medicion {
    private Date fechaLectura;
    private Integer anio;
    private Integer bimestre;
    private Double lectura;

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
