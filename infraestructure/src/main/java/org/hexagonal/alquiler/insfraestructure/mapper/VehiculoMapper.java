package org.hexagonal.alquiler.insfraestructure.mapper;

import org.hexagonal.alquiler.domain.aggregates.dto.VehiculoDTO;
import org.hexagonal.alquiler.insfraestructure.entity.VehiculoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public VehiculoDTO mapToDTO(VehiculoEntity entity) {
        return modelMapper.map(entity, VehiculoDTO.class);
    }

    public VehiculoEntity mapToEntity(VehiculoDTO vehiculoDTO) {
        return modelMapper.map(vehiculoDTO, VehiculoEntity.class);
    }

    public List<VehiculoDTO> maṕToDTOList(List<VehiculoEntity> lista) {
        List<VehiculoDTO> listaDTO = new ArrayList<VehiculoDTO>();
        for (VehiculoEntity entity: lista) {
            listaDTO.add(modelMapper.map(entity, VehiculoDTO.class));
        }
        return listaDTO;
    }
}
