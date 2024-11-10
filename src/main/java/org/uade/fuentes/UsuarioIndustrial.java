package org.uade.fuentes;

public class UsuarioIndustrial extends Usuario {
	private String razonSocial;
	private String cuit;
	private String IIBB;
	private String condicionFiscal;

	/* constructor */
	public UsuarioIndustrial(String calle, int altura, int piso, String dpto,int cp, String local, String pcia,String rs,String cuit,String iibb,String condicion) {
		super(calle, altura, piso, dpto, cp, local, pcia);
		this.setRazonSocial(rs);
		this.setCuit(cuit);
		this.setIIBB(iibb);
		this.setCondicionFiscal(condicion);
	}
	
	/* getters && setters */
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getIIBB() {
		return IIBB;
	}

	public void setIIBB(String iIBB) {
		IIBB = iIBB;
	}

	public String getCondicionFiscal() {
		return condicionFiscal;
	}

	public void setCondicionFiscal(String condicionFiscal) {
		this.condicionFiscal = condicionFiscal;
	}

	/* metodos*/
	@Override
	public int obtenerUltimoConsumo(int anio, int bimestre) {
		int consumoKwh 	= this.getMedidor().obtenerUltimoConsumo(anio, bimestre) - this.getMedidor().obtenerAnteriorConsumo(anio, bimestre);
		int tarifa 		= (int) getTarifa().calcularTarifa(consumoKwh);
		return consumoKwh + tarifa;
	}

	public boolean sosCuitUsuario(String nroCuit) {
		if(this.getCuit().equals(nroCuit)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean sosUsuarioPorDato(int dato) {
		if(this.getCuit().equals(dato)){
			return true;
		}else{
			return false;
		}
	}
}
