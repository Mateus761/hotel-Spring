package com.api.hotelSpring.request;



import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Nome do usuário", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(notes = "Idade do usuário", required = true)
    private Integer idade;

    @NotNull
    @ApiModelProperty(notes = "CPF do usuário", required = true)
    private Long cpf;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Tipo do usuário", required = true)
    private String tipo;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Dia do check-in do usuário", required = true)
    private String checkIn;


    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Dia do check-out do usuário", required = true)
    private String checkOut;

    @NotNull
    @ApiModelProperty(notes = "Id do quarto do usuário", required = true)
    private Integer quartoId;
}
