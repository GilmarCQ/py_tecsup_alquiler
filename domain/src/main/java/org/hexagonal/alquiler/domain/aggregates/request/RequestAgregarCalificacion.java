package org.hexagonal.alquiler.domain.aggregates.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestAgregarCalificacion {
    private Long id;
    private Long idUsuario;
    private Long puntaje;
    private String comentario;
    private String descripcion;
}
