package org.hexagonal.alquiler.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String placa;
    private Long asientos;
    private String anioFabricacion;
    private String color;
    private String transmision;
    private Float costoDiaAlquiler;
    private Float costoHoraAlquiler;
    private String descripcion;
}
