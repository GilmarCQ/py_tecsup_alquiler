package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
}
