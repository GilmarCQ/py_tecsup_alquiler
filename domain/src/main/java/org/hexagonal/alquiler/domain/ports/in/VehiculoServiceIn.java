package org.hexagonal.alquiler.domain.ports.in;

import org.hexagonal.alquiler.domain.aggregates.dto.VehiculoDTO;
import org.hexagonal.alquiler.domain.aggregates.request.RequestAgregarVehiculo;

import java.util.List;

public interface VehiculoServiceIn {

    VehiculoDTO agregarIn(RequestAgregarVehiculo vehiculo);
    VehiculoDTO buscarVehiculo(Long id);
    List<VehiculoDTO> listarTodosIn();
    VehiculoDTO actualizarIn(Long id, RequestAgregarVehiculo vehiculo);
    VehiculoDTO anularIn(Long id);

}
