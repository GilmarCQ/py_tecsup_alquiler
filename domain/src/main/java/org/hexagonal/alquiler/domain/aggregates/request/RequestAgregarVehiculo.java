package org.hexagonal.alquiler.domain.aggregates.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestAgregarVehiculo {
    private String placa;
    private String vin;
    private Long asientos;
    private String anioFabricacion;
    private String color;
    private String transmision;
    private Float costoDiaAlquiler;
    private Float costoHoraAlquiler;
    private String descripcion;
    private Long idMarca;
    private Long idTipoVehiculo;
    private Long idTipoCombustible;
}
