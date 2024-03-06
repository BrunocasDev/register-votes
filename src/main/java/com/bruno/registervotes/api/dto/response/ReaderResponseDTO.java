package com.bruno.registervotes.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReaderResponseDTO {
    private Long id;
    private String name;
    private MesaVotoResponseDTO mesaVoto;
}
