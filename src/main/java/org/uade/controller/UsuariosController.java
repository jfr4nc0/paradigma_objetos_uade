package org.uade.controller;

import org.uade.model.Usuario;

import java.util.Collection;
import java.util.Objects;

public final class UsuariosController {
    private static volatile UsuariosController INSTANCE;
    private Collection<Usuario> usuarios;

    private UsuariosController(){}

    public static UsuariosController getInstance() {
        UsuariosController result = INSTANCE;
        if(result != null) {
            return result;
        }
        synchronized(UsuariosController.class) {
            if (INSTANCE == null) {
                INSTANCE = new UsuariosController();
            }
            return INSTANCE;
        }
    }

    private Integer crearUsuario(String nombre, Integer dni, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        if (Objects.isNull(nombre)) {throw new IllegalArgumentException("Nombre no puede ser nulo");}
        if (Objects.isNull(dni)) {throw new IllegalArgumentException("DNI no puede ser nulo");}
        if (Objects.isNull(calle)) {throw new IllegalArgumentException("Calle no puede ser nulo");}
        if (Objects.isNull(altura)) {throw new IllegalArgumentException("Altura no puede ser nulo");}
        if (Objects.isNull(piso)) {throw new IllegalArgumentException("Piso no puede ser nulo");}
        if (Objects.isNull(depto)) {throw new IllegalArgumentException("Depto no puede ser nulo");}
        if (Objects.isNull(codigoPostal)) {throw new IllegalArgumentException("CodigoPostal no puede ser nulo");}
        if (Objects.isNull(localidad)) {throw new IllegalArgumentException("Localidad no puede ser nulo");}
        if (Objects.isNull(provincia)) {throw new IllegalArgumentException("Provincia no puede ser nulo");}

        Integer nroUsuario = getInstance().usuarios.size() + 1;

        Usuario nuevoUsuario = new Usuario(nroUsuario, calle, altura, piso, depto, codigoPostal, localidad, provincia);

        getInstance().usuarios.add(nuevoUsuario);

        return nuevoUsuario.getNroUsuario();
    }

    public Integer crearUsuarioResidencial(String nombre, Integer dni, String calle, Integer altura, Integer piso, Integer depto, Integer codigoPostal, String localidad, String provincia){
        return null;
    }

    public Integer crearUsuarioIndustrial(String nombre, Integer dni, String calle, Integer altura, Integer piso, Integer depto, Integer codigoPostal, String localidad, String provincia){
        return null;
    }

    public Usuario buscarUsuario(Integer nroUsuario) {
        return null;
    }

    public Double consultarConsumo(Integer nroUsuario, Integer anio, Integer bimestre) {
        return null;
    }

    public Boolean existeUsuarioIndustrial(){
        return false;
    }

    public Boolean existeUsuarioResidencial(){
        return false;
    }
}
