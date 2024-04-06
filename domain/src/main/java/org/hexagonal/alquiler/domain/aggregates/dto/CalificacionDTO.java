package org.hexagonal.alquiler.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalificacionDTO {
    private Long id;
    private Long idUsuario;
    private Long puntaje;
    private String comentario;
    private String descripcion;
}
