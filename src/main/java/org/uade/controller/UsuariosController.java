package org.uade.controller;

import org.uade.model.Usuario;

import java.util.Collection;

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

    private Integer crearUsuario(String nombre, Integer dni, String calle, Integer altura, Integer piso, Integer depto, Integer codigoPostal, String localidad, String provincia){
        return null;
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
