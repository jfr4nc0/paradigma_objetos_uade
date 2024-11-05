package org.uade.model;

public class UsuarioResidencial extends Usuario {
    private String nombre;
    private Integer dni;

    public UsuarioResidencial(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String nombre, Integer dni) {
        super(calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.nombre = nombre;
        this.dni = dni;
    }
}
