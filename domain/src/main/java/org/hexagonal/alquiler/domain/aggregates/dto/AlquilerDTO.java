package org.hexagonal.alquiler.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlquilerDTO {
    private Long id;
    private Long idUsuario;
    private Long idVehiculo;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private String lugarRecojo;
    private String latitudRecojo;
    private String longitudRecojo;
    private String tipo;
    private Float cantidad;
}
