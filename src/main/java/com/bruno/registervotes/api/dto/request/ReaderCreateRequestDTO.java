package com.bruno.registervotes.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReaderCreateRequestDTO {
        @NotBlank
        private String name;
        @NotBlank
        IdRequestDTO mesaVoto;
}
