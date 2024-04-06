package org.hexagonal.alquiler.insfraestructure.adapters;

import lombok.RequiredArgsConstructor;
import org.hexagonal.alquiler.domain.aggregates.constants.Constants;
import org.hexagonal.alquiler.domain.aggregates.dto.VehiculoDTO;
import org.hexagonal.alquiler.domain.aggregates.request.RequestAgregarVehiculo;
import org.hexagonal.alquiler.domain.ports.out.VehiculoServiceOut;
import org.hexagonal.alquiler.insfraestructure.entity.MarcaEntity;
import org.hexagonal.alquiler.insfraestructure.entity.TipoCombustibleEntity;
import org.hexagonal.alquiler.insfraestructure.entity.TipoVehiculoEntity;
import org.hexagonal.alquiler.insfraestructure.entity.VehiculoEntity;
import org.hexagonal.alquiler.insfraestructure.mapper.VehiculoMapper;
import org.hexagonal.alquiler.insfraestructure.repository.MarcaRepository;
import org.hexagonal.alquiler.insfraestructure.repository.TipoCombustibleRepository;
import org.hexagonal.alquiler.insfraestructure.repository.TipoVehiculoRepository;
import org.hexagonal.alquiler.insfraestructure.repository.VehiculoRepository;
import org.hexagonal.alquiler.insfraestructure.utils.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoAdapter implements VehiculoServiceOut {

    private final VehiculoRepository vehiculoRepository;
    private final TipoVehiculoRepository tipoVehiculoRepository;
    private final TipoCombustibleRepository tipoCombustibleRepository;
    private final MarcaRepository marcaRepository;
    private final VehiculoMapper vehiculoMapper;
    private String mensaje;

    @Override
    public VehiculoDTO agregarOut(RequestAgregarVehiculo requestVehiculo) {

        VehiculoEntity vehiculoEntity;

        //  Validar parametros entrada
        if (!valParamsAgregar(requestVehiculo))
            throw new IllegalArgumentException(mensaje);

        //  Validar restricciones
        if (!valRestricciones(requestVehiculo))
            throw new IllegalArgumentException(mensaje);

        vehiculoEntity = vehiculoRepository.save(getEntityAgregar(requestVehiculo));
        return vehiculoMapper.mapToDTO(vehiculoEntity);
    }

    @Override
    public VehiculoDTO buscarVehiculoOut(Long id) {
        VehiculoEntity vehiculoBD = vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro el vehiculo."));
        return vehiculoMapper.mapToDTO(vehiculoBD);
    }

    @Override
    public List<VehiculoDTO> listarTodosOut() {
        List<VehiculoEntity> listaVehiculos = vehiculoRepository.findAllByEstado(Constants.STATUS_ACTIVE);
        return vehiculoMapper.maṕToDTOList(listaVehiculos);
    }

    @Override
    public VehiculoDTO actualizarOut(Long id, RequestAgregarVehiculo vehiculo) {
        return null;
    }

    @Override
    public VehiculoDTO anularOut(Long id) {
        return null;
    }

    //  Metodos para agregar
    private Boolean valParamsAgregar(RequestAgregarVehiculo vehiculo) {
        if (vehiculo.getAnioFabricacion() == null || vehiculo.getAnioFabricacion().isBlank()) {
            mensaje = "Año de fabricación." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getPlaca() == null || vehiculo.getPlaca().isBlank()) {
            mensaje = "Placa." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getAsientos() == null) {
            mensaje = "Asientos." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getColor() == null || vehiculo.getColor().isBlank()) {
            mensaje = "Color." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getTransmision() == null || vehiculo.getTransmision().isBlank()) {
            mensaje = "Transmisión." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getCostoDiaAlquiler() == null || vehiculo.getCostoDiaAlquiler().isNaN()) {
            mensaje = "Costo de alquiler por día." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getCostoHoraAlquiler() == null || vehiculo.getCostoHoraAlquiler().isNaN()) {
            mensaje = "Costo de alquiler por hora." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getDescripcion() == null || vehiculo.getDescripcion().isBlank()) {
            mensaje = "Descripción." + Constants.MESS_PARAMS_ERROR;
            return false;
        } else if (vehiculo.getVin() == null || vehiculo.getVin().isBlank()) {
            mensaje = "Código VIN." + Constants.MESS_PARAMS_ERROR;
            return false;
        }
        return true;
    }
    private Boolean valRestricciones(RequestAgregarVehiculo vehiculo) {
        Optional<VehiculoEntity> vehiculoBD = vehiculoRepository.findByPlacaAndEstado(vehiculo.getPlaca(), Constants.STATUS_ACTIVE);
        if (vehiculoBD.isPresent())
            throw new IllegalArgumentException("La placa del vehiculo " + vehiculo.getPlaca() + " ya existe.");

        vehiculoBD = vehiculoRepository.findByVinAndEstado(vehiculo.getVin(), Constants.STATUS_ACTIVE);
        if (vehiculoBD.isPresent())
            throw new IllegalArgumentException("El codigo VIN del vehículo " + vehiculo.getVin() + " ya existe.");
        return true;
    }

    private VehiculoEntity getEntityAgregar(RequestAgregarVehiculo vehiculo) {
        VehiculoEntity entity = new VehiculoEntity();

        MarcaEntity marca = marcaRepository.findById(vehiculo.getIdMarca())
                .orElseThrow(() -> new IllegalArgumentException("La marca del vehículo no existe."));

        TipoVehiculoEntity tipoVehiculo = tipoVehiculoRepository.findById(vehiculo.getIdMarca())
                .orElseThrow(() -> new IllegalArgumentException("El tipo de vehiculo no existe."));

        TipoCombustibleEntity tipoCombustible = tipoCombustibleRepository.findById(vehiculo.getIdMarca())
                .orElseThrow(() -> new IllegalArgumentException("El tipo de combustible no existe."));

        entity.setVin(vehiculo.getVin());
        entity.setPlaca(vehiculo.getPlaca());
        entity.setAsientos(vehiculo.getAsientos());
        entity.setAnioFabricacion(vehiculo.getAnioFabricacion());
        entity.setColor(vehiculo.getColor());
        entity.setTransmision(vehiculo.getTransmision());
        entity.setCostoHoraAlquiler(vehiculo.getCostoHoraAlquiler());
        entity.setCostoDiaAlquiler(vehiculo.getCostoDiaAlquiler());
        entity.setDescripcion(vehiculo.getDescripcion());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCreate(Util.getUser());
        entity.setDateCreate(Util.getTimestamp());
        entity.setMarca(marca);
        entity.setTipoVehiculo(tipoVehiculo);
        entity.setTipoCombustible(tipoCombustible);
        return entity;
    }


}
