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
public class UsuarioDto {

    @ApiModelProperty(notes = "Nome do usuário")
    private String name;

    @ApiModelProperty(notes = "Idade do usuário")
    private Integer idade;

    @ApiModelProperty(notes = "CPF do usuário")
    private Long cpf;

    @ApiModelProperty(notes = "Tipo do usuário")
    private String tipo;

    @ApiModelProperty(notes = "Informações do quarto em que o usuário está hospedado")
    private QuartoDto quarto;

    @ApiModelProperty(notes = "Id do quarto do usuário")
    private Integer quartoId;
}
