package com.bruno.registervotes.api.mapper;

import com.bruno.registervotes.api.dto.request.MesaVotoCreateRequestDTO;
import com.bruno.registervotes.api.dto.request.MesaVotoUpdateRequestDTO;
import com.bruno.registervotes.api.dto.response.MesaVotoResponseDTO;
import com.bruno.registervotes.domain.entity.MesaVoto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaVotoMapper {
    MesaVotoResponseDTO toResponseDTO(MesaVoto mesaVoto);

    MesaVoto entityToCreateRequestDTO(MesaVotoCreateRequestDTO dto);

    MesaVoto updateRequestDTOToEntity(MesaVotoUpdateRequestDTO dto);
}
