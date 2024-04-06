package org.hexagonal.alquiler.domain.impl;

import lombok.RequiredArgsConstructor;
import org.hexagonal.alquiler.domain.aggregates.dto.VehiculoDTO;
import org.hexagonal.alquiler.domain.aggregates.request.RequestAgregarVehiculo;
import org.hexagonal.alquiler.domain.ports.in.VehiculoServiceIn;
import org.hexagonal.alquiler.domain.ports.out.VehiculoServiceOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoServiceIn {

    private final VehiculoServiceOut vehiculoServiceOut;

    @Override
    public VehiculoDTO agregarIn(RequestAgregarVehiculo vehiculo) {
        return vehiculoServiceOut.agregarOut(vehiculo);
    }

    @Override
    public VehiculoDTO buscarVehiculo(Long id) {
        return vehiculoServiceOut.buscarVehiculoOut(id);
    }

    @Override
    public List<VehiculoDTO> listarTodosIn() {
        return vehiculoServiceOut.listarTodosOut();
    }

    @Override
    public VehiculoDTO actualizarIn(Long id, RequestAgregarVehiculo vehiculo) {
        return null;
    }

    @Override
    public VehiculoDTO anularIn(Long id) {
        return null;
    }
}
