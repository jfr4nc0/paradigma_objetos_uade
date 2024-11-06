package org.uade.controller;

import org.uade.model.Usuario;
import org.uade.model.UsuarioIndustrial;
import org.uade.model.UsuarioResidencial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public final class UsuariosController {
    private static volatile UsuariosController INSTANCE;
    private Collection<UsuarioResidencial> usuariosResidenciales;
    private Collection<UsuarioIndustrial> usuariosIndustriales;

    private UsuariosController(){
        usuariosIndustriales = new ArrayList<>();
        usuariosResidenciales = new ArrayList<>();
    }

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

    private Integer calcularNroUsuario(){
        return usuariosResidenciales.size() + usuariosIndustriales.size() + 1;
    }

    private void validateUsuario(Usuario usuario){
        if (Objects.isNull(usuario.getCalle())) {throw new IllegalArgumentException("Calle no puede ser nulo");}
        if (Objects.isNull(usuario.getAltura())) {throw new IllegalArgumentException("Altura no puede ser nulo");}
        if (Objects.isNull(usuario.getPiso())) {throw new IllegalArgumentException("Piso no puede ser nulo");}
        if (Objects.isNull(usuario.getDepto())) {throw new IllegalArgumentException("Depto no puede ser nulo");}
        if (Objects.isNull(usuario.getCodigoPostal())) {throw new IllegalArgumentException("CodigoPostal no puede ser nulo");}
        if (Objects.isNull(usuario.getLocalidad())) {throw new IllegalArgumentException("Localidad no puede ser nulo");}
        if (Objects.isNull(usuario.getProvincia())) {throw new IllegalArgumentException("Provincia no puede ser nulo");}
    }

    private void validateUsuarioIndustrial(Usuario usuario, String razonSocial, String cuit, String iibb, String condicionFiscal){
        validateUsuario(usuario);
        if (Objects.isNull(razonSocial)) {throw new IllegalArgumentException("Razon Social no puede ser nulo");}
        if (Objects.isNull(cuit)) {throw new IllegalArgumentException("Cuit no puede ser nulo");}
        if (Objects.isNull(iibb)) {throw new IllegalArgumentException("Iibb no puede ser nulo");}
        if (Objects.isNull(condicionFiscal)) {throw new IllegalArgumentException("Condicion Fiscal no puede ser nulo");}
    }

    private void validateUsuarioResidencial(Usuario usuario, String nombre, Integer dni){
        validateUsuario(usuario);
        if (Objects.isNull(nombre)) {throw new IllegalArgumentException("Nombre no puede ser nulo");}
        if (Objects.isNull(dni)) {throw new IllegalArgumentException("Dni no puede ser nulo");}
    }

    public Integer crearUsuarioResidencial(String nombre, Integer dni, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        Usuario usuario = new Usuario(calle, altura, piso, depto, codigoPostal, localidad, provincia);

        validateUsuarioResidencial(usuario, nombre, dni);

        UsuarioResidencial newUser = new UsuarioResidencial(calcularNroUsuario(), usuario, nombre, dni);
        getInstance().usuariosResidenciales.add(newUser);

        return newUser.getNroUsuario();
    }

    public Integer crearUsuarioIndustrial(String razonSocial, String cuit, String iibb, String condicionFiscal, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        Usuario usuario = new Usuario(calle, altura, piso, depto, codigoPostal, localidad, provincia);

        validateUsuarioIndustrial(usuario, razonSocial, cuit, iibb, condicionFiscal);

        UsuarioIndustrial newUser = new UsuarioIndustrial(calcularNroUsuario(), usuario, razonSocial, cuit, iibb, condicionFiscal);
        getInstance().usuariosIndustriales.add(newUser);

        return newUser.getNroUsuario();
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
