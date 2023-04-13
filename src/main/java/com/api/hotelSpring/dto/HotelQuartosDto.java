package com.api.hotelSpring.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HotelQuartosDto extends HotelDto{
    @ApiModelProperty(notes = "Lista dos quartos que o hotel possui")
    private List<QuartoDto> quartos;
}
