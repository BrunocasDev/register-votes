package com.bruno.registervotes.api.mapper;

import com.bruno.registervotes.api.dto.request.MesaVotoCreateRequestDTO;
import com.bruno.registervotes.api.dto.request.MesaVotoUpdateRequestDTO;
import com.bruno.registervotes.api.dto.request.ReaderCreateRequestDTO;
import com.bruno.registervotes.api.dto.request.ReaderUpdateRequestDTO;
import com.bruno.registervotes.api.dto.response.MesaVotoResponseDTO;
import com.bruno.registervotes.api.dto.response.ReaderResponseDTO;
import com.bruno.registervotes.domain.entity.MesaVoto;
import com.bruno.registervotes.domain.entity.Reader;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReaderMapper {
    ReaderResponseDTO toResponseDTO(Reader reader);

    Reader entityToCreateRequestDTO(ReaderCreateRequestDTO dto);

    Reader updateRequestDTOToEntity(ReaderUpdateRequestDTO dto);
}
