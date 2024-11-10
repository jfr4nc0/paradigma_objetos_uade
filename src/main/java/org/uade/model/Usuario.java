package org.uade.model;

public abstract class Usuario {
    private Integer nroUsuario;
    private Medidor medidor;
    private Tarifa tarifa;
    private String calle;
    private Integer altura;
    private Integer piso;
    private String depto;
    private Integer codigoPostal;
    private String localidad;
    private String provincia;

    public Usuario() {}

    public Usuario(Integer nroUsuario, Medidor medidor, String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia) {
        this.nroUsuario = nroUsuario;
        this.medidor = medidor;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Usuario(String calle, Integer altura, Integer piso, String depto, Integer codigoPostal, String localidad, String provincia) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Double calcularTarifaPorConsumo(Integer anio, Integer bimestre) {
        Double cantidadKwh = obtenerUltimoConsumo(anio, bimestre);
        return tarifa.calcularTarifa(cantidadKwh);
    }

    public Double obtenerUltimoConsumo(Integer anio, Integer bimestre){
        return obtenerMedicionDeConsumo(anio, bimestre) - obtenerMedicionDeConsumo(anio, bimestre - 1);
    }

    private Double obtenerMedicionDeConsumo(Integer anio, Integer bimestre) {
        return medidor.getMediciones().stream()
                .filter(medicion_ -> medicion_.getAnio().equals(anio) && medicion_.getBimestre().equals(bimestre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una medicion para el bimestre: " + bimestre))
                .getLectura();
    }

    public Integer getNroUsuario() {
        return nroUsuario;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public Integer getPiso() {
        return piso;
    }

    public String getDepto() {
        return depto;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}
