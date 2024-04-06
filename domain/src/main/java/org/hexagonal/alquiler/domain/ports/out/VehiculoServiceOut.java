package org.hexagonal.alquiler.domain.ports.out;

import org.hexagonal.alquiler.domain.aggregates.dto.VehiculoDTO;
import org.hexagonal.alquiler.domain.aggregates.request.RequestAgregarVehiculo;

import java.util.List;

public interface VehiculoServiceOut {
    VehiculoDTO agregarOut(RequestAgregarVehiculo vehiculo);
    VehiculoDTO buscarVehiculoOut(Long id);
    List<VehiculoDTO> listarTodosOut();
    VehiculoDTO actualizarOut(Long id, RequestAgregarVehiculo vehiculo);
    VehiculoDTO anularOut(Long id);
}
