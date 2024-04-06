package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    Optional<VehiculoEntity> findByVinAndEstado(String vin, Integer estado);
    Optional<VehiculoEntity> findByPlacaAndEstado(String placa, Integer estado);
    List<VehiculoEntity> findAllByEstado(Integer estado);
}
