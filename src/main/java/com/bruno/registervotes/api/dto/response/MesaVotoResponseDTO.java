package com.bruno.registervotes.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesaVotoResponseDTO{
    private Long id;
    private String name;
    private String location;
    private String district;
}
