package com.api.hotelSpring.request;


import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Nome do hotel", required = true)
    private String nomeDoHotel;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Nome do dono do hotel", required = true)
    private String dono;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Localização do hotel", required = true)
    private String location;
}
