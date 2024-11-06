package org.uade.model;

public class UsuarioIndustrial extends Usuario {
    private String razonSocial;
    private String cuit;
    private String iibb;
    private String condicionFiscal;

    public UsuarioIndustrial(Integer nroUsuario, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String iibb, String condicionFiscal) {
        super(nroUsuario, calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.iibb = iibb;
        this.condicionFiscal = condicionFiscal;
    }

    public UsuarioIndustrial(Integer nroUsuario, Usuario usuario, String razonSocial, String cuit, String iibb, String condicionFiscal) {
        super(nroUsuario, usuario.getCalle(), usuario.getAltura(), usuario.getPiso(), usuario.getDepto(), usuario.getCodigoPostal(), usuario.getLocalidad(), usuario.getProvincia());
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.iibb = iibb;
        this.condicionFiscal = condicionFiscal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public String getIibb() {
        return iibb;
    }

    public String getCondicionFiscal() {
        return condicionFiscal;
    }
}
