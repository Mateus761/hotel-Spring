package com.api.hotelSpring.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor // Sempre colocar isso no DTO
@AllArgsConstructor // Sempre colocar isso no DTO
public class QuartoDto {

    @ApiModelProperty(notes = "Andar do quarto")
    private Integer andar;

    @ApiModelProperty(notes = "Número do quarto")
    private Integer number;

    @ApiModelProperty(notes = "Tipo do quarto")
    private String tipo;

    //private UsuarioDto usuario;

    //private Integer usuarioId;

    @ApiModelProperty(notes = "Informações do hotel a qual o quarto pertence")
    private HotelDto hotel;

    @ApiModelProperty(notes = "Id do hotel do quarto")
    private Integer hotelId;
}
