package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.TipoVehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculoEntity, Long> {
}
