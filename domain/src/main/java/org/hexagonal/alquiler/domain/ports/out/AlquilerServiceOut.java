package org.hexagonal.alquiler.domain.ports.out;

import org.hexagonal.alquiler.domain.aggregates.dto.AlquilerDTO;

public interface AlquilerServiceOut {

    AlquilerDTO crear();

}
