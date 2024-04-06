package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
}
