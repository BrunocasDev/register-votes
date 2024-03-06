package com.bruno.registervotes.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MesaVotoCreateRequestDTO{
        @NotBlank
        private String name;
        @NotBlank
        private String location;
        @NotBlank
        private String district;
}
