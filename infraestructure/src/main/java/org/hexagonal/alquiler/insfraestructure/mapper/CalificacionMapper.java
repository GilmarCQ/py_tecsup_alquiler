package org.hexagonal.alquiler.insfraestructure.mapper;

import org.hexagonal.alquiler.domain.aggregates.dto.CalificacionDTO;
import org.hexagonal.alquiler.insfraestructure.entity.CalificacionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CalificacionMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CalificacionDTO mapToDTO(CalificacionEntity entity) {
        return modelMapper.map(entity, CalificacionDTO.class);
    }

    public CalificacionEntity mapToEntity(CalificacionDTO calificacionDTO) {
        return modelMapper.map(calificacionDTO, CalificacionEntity.class);
    }

}
