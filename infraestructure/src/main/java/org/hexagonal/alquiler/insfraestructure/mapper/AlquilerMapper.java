package org.hexagonal.alquiler.insfraestructure.mapper;

import org.hexagonal.alquiler.domain.aggregates.dto.AlquilerDTO;
import org.hexagonal.alquiler.insfraestructure.entity.AlquilerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlquilerMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public AlquilerDTO maToDTO(AlquilerEntity entity) {
        return modelMapper.map(entity, AlquilerDTO.class);
    }

    public AlquilerEntity mapToEntity(AlquilerEntity alquilerEntity) {
        return modelMapper.map(alquilerEntity, AlquilerEntity.class);
    }
}
