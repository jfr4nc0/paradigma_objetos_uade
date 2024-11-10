package org.uade.model;

public class UsuarioIndustrial extends Usuario {
    private String razonSocial;
    private String cuit;
    private String iibb;
    private String condicionFiscal;

    public UsuarioIndustrial(Integer nroUsuario, Medidor medidor, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String iibb, String condicionFiscal) {
        super(nroUsuario, medidor, calle, altura, piso, depto, codigoPostal, localidad, provincia);
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
