package org.uade.model;

public class UsuarioIndustrial extends Usuario {
    private String razonSocial;
    private String cuit;
    private String iibb;
    private String condicionFiscal;

    public UsuarioIndustrial(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String iibb, String condicionFiscal) {
        super(calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.iibb = iibb;
        this.condicionFiscal = condicionFiscal;
    }
}
