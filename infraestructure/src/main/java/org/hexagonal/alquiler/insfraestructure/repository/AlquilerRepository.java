package org.hexagonal.alquiler.insfraestructure.repository;

import org.hexagonal.alquiler.insfraestructure.entity.AlquilerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<AlquilerEntity, Long> {
}
