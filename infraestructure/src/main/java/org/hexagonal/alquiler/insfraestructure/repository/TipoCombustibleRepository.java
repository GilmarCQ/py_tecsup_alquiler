package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.TipoCombustibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCombustibleRepository extends JpaRepository<TipoCombustibleEntity, Long> {
}
