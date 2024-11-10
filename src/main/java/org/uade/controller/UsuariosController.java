package org.uade.controller;

import org.uade.model.Factura;
import org.uade.model.Usuario;
import org.uade.model.UsuarioIndustrial;
import org.uade.model.UsuarioResidencial;

import java.util.*;
import java.util.function.Predicate;

import static org.uade.controller.MedidorController.crearMedidor;

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

    public Integer crearUsuarioResidencial(String nombre, Integer dni, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        validateUsuarioResidencial(calle, altura, piso, depto, codigoPostal, localidad, provincia, nombre, dni);

        UsuarioResidencial newUser = new UsuarioResidencial(calcularNroUsuario(), crearMedidor(), calle, altura, piso, depto, codigoPostal, localidad, provincia, nombre, dni);
        getInstance().usuariosResidenciales.add(newUser);

        return newUser.getNroUsuario();
    }

    public Integer crearUsuarioIndustrial(String razonSocial, String cuit, String iibb, String condicionFiscal, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        validateUsuarioIndustrial(calle, altura, piso, depto, codigoPostal, localidad, provincia, razonSocial, cuit, iibb, condicionFiscal);

        UsuarioIndustrial newUser = new UsuarioIndustrial(calcularNroUsuario(), crearMedidor(), calle, altura, piso, depto, codigoPostal, localidad, provincia, razonSocial, cuit, iibb, condicionFiscal);
        getInstance().usuariosIndustriales.add(newUser);

        return newUser.getNroUsuario();
    }

    public Usuario buscarUsuario(Integer nroUsuario) {
        Optional<UsuarioResidencial> usuarioResidencial = buscarUsuarioResidencial(usuario -> usuario.getNroUsuario().equals(nroUsuario));
        if (usuarioResidencial.isPresent()) {return usuarioResidencial.get();}

        Optional<UsuarioIndustrial> usuarioIndustrial = buscarUsuarioIndustrial(usuario -> usuario.getNroUsuario().equals(nroUsuario));
        if (usuarioIndustrial.isPresent()) {return usuarioIndustrial.get();}

        throw new IllegalArgumentException("No existe el usuario con el nro '" + nroUsuario + "'");
    }

    public Factura generarFactura(Integer nroUsuario, Integer anio, Integer bimestre){
        Usuario usuario = buscarUsuario(nroUsuario);
        Double consumo = usuario.obtenerUltimoConsumo(anio, bimestre);
        Double montoTotal = usuario.calcularTarifaPorConsumo(anio, bimestre);

        return new Factura(anio, bimestre, usuario, consumo, montoTotal);
    }

    public Double calcularTarifaPorConsumo(Integer nroUsuario, Integer anio, Integer bimestre) {
        return buscarUsuario(nroUsuario).calcularTarifaPorConsumo(anio, bimestre);
    }

    public Boolean existeUsuarioIndustrial(String cuit){
        return buscarUsuarioIndustrial(usuarioIndustrial -> usuarioIndustrial.getCuit().equals(cuit)).isPresent();
    }

    public Boolean existeUsuarioResidencial(Integer dni){
        return buscarUsuarioResidencial(usuarioResidencial -> usuarioResidencial.getDni().equals(dni)).isPresent();
    }

    private Integer calcularNroUsuario(){
        return usuariosResidenciales.size() + usuariosIndustriales.size() + 1;
    }

    private void validateUsuario(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia){
        if (Objects.isNull(calle)) {throw new IllegalArgumentException("Calle no puede ser nulo");}
        if (Objects.isNull(altura)) {throw new IllegalArgumentException("Altura no puede ser nulo");}
        if (Objects.isNull(piso)) {throw new IllegalArgumentException("Piso no puede ser nulo");}
        if (Objects.isNull(depto)) {throw new IllegalArgumentException("Depto no puede ser nulo");}
        if (Objects.isNull(codigoPostal)) {throw new IllegalArgumentException("CodigoPostal no puede ser nulo");}
        if (Objects.isNull(localidad)) {throw new IllegalArgumentException("Localidad no puede ser nulo");}
        if (Objects.isNull(provincia)) {throw new IllegalArgumentException("Provincia no puede ser nulo");}
    }

    private void validateUsuarioIndustrial(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String iibb, String condicionFiscal){
        validateUsuario(calle, altura, piso, depto, codigoPostal, localidad, provincia);
        if (Objects.isNull(razonSocial)) {throw new IllegalArgumentException("Razon Social no puede ser nulo");}
        if (Objects.isNull(cuit)) {throw new IllegalArgumentException("Cuit no puede ser nulo");}
        if (Objects.isNull(iibb)) {throw new IllegalArgumentException("Iibb no puede ser nulo");}
        if (Objects.isNull(condicionFiscal)) {throw new IllegalArgumentException("Condicion Fiscal no puede ser nulo");}
    }

    private void validateUsuarioResidencial(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String nombre, Integer dni){
        validateUsuario(calle, altura, piso, depto, codigoPostal, localidad, provincia);
        if (Objects.isNull(nombre)) {throw new IllegalArgumentException("Nombre no puede ser nulo");}
        if (Objects.isNull(dni)) {throw new IllegalArgumentException("Dni no puede ser nulo");}
    }

    private static Optional<UsuarioIndustrial> buscarUsuarioIndustrial(Predicate<UsuarioIndustrial> condition) {
        return getInstance().usuariosIndustriales.stream()
                .filter(condition)
                .findFirst();
    }

    private static Optional<UsuarioResidencial> buscarUsuarioResidencial(Predicate<UsuarioResidencial> condition) {
        return getInstance().usuariosResidenciales.stream()
                .filter(condition)
                .findFirst();
    }
}
