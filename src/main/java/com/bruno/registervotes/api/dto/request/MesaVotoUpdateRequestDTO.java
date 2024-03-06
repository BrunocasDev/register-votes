package com.bruno.registervotes.api.dto.request;

import lombok.Data;

@Data
public class MesaVotoUpdateRequestDTO{
    private String name;
    private String location;
    private String district;
}
