package org.uade.model;

public class Usuario {
    private Integer nroUsuario;
    private Medidor medidor;
    private String calle;
    private Integer altura;
    private Integer piso;
    private String depto;
    private Integer codigoPostal;
    private String localidad;
    private String provincia;

    public Usuario(Integer nroUsuario, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia) {
        this.nroUsuario = nroUsuario;
        this.medidor = new Medidor();
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Integer getNroUsuario() {
        return nroUsuario;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public Integer getPiso() {
        return piso;
    }

    public String getDepto() {
        return depto;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }
}
