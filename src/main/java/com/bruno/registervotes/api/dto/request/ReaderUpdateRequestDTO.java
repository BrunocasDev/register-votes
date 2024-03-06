package com.bruno.registervotes.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReaderUpdateRequestDTO {
    private String name;
    IdRequestDTO mesaVoto;
}
