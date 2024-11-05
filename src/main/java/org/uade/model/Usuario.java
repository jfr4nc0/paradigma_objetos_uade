package org.uade.model;

public class Usuario {
    private String calle;
    private Integer altura;
    private Integer piso;
    private String depto;
    private Integer codigoPostal;
    private String localidad;
    private String provincia;

    public Usuario(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
