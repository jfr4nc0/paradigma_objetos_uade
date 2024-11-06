package org.uade.model;

public class UsuarioResidencial extends Usuario {
    private String nombre;
    private Integer dni;

    public UsuarioResidencial(Integer nroUsuario, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String nombre, Integer dni) {
        super(nroUsuario, calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.nombre = nombre;
        this.dni = dni;
    }

    public UsuarioResidencial(Integer nroUsuario, Usuario usuario, String nombre, Integer dni) {
        super(nroUsuario, usuario.getCalle(), usuario.getAltura(), usuario.getPiso(), usuario.getDepto(), usuario.getCodigoPostal(), usuario.getLocalidad(), usuario.getProvincia());
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDni() {
        return dni;
    }
}
