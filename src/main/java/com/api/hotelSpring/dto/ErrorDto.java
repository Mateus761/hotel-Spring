package com.api.hotelSpring.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    @ApiModelProperty(notes = "Mensagem de erro")
    private String message;

    @ApiModelProperty(notes = "Código do erro")
    private int error;
}
