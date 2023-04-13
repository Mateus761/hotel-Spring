package com.api.hotelSpring.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HotelDto {

    @ApiModelProperty(notes = "Nome do hotel")
    private String nomeDoHotel;

    @ApiModelProperty(notes = "Nome do dono do hotel")
    private String dono;

    @ApiModelProperty(notes = "Localização do hotel")
    private String location;
}
