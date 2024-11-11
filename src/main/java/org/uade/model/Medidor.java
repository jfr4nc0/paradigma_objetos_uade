package org.uade.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Medidor {
    private Integer nroMedidor;
    private Date fechaInstalacion;
    private Collection<Medicion> mediciones;

    public Medidor(Integer nroMedidor, Date fechaInstalacion) {
        this.nroMedidor = nroMedidor;
        this.fechaInstalacion = fechaInstalacion;
        this.mediciones = new ArrayList<Medicion>();
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public Integer getNroMedidor() {
        return nroMedidor;
    }

    public Collection<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(Collection<Medicion> mediciones) {
        this.mediciones = mediciones;
    }
}
